package org.healthplus.vendor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.vendor.dto.*;
import org.healthplus.vendor.entity.*;
import org.healthplus.vendor.exception.MenuModificationFailException;
import org.healthplus.vendor.exception.NoVendorProfileException;
import org.healthplus.vendor.exception.OptionDetailUpdateFailException;
import org.healthplus.vendor.repository.*;
import org.healthplus.vendor.service.VendorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendorServiceImpl implements VendorService {

  private final VendorRepository vendorRepository;
  private final RestaurantRepository restaurantRepository;
  private final MenuRepository menuRepository;
  private final OptionGroupRepository optionGroupRepository;
  private final OptionDetailRepository optionDetailRepository;

  @Override
  public ProductInfoInquiryDTO getProduct(Long vendorId, Long productId) throws Exception {

    ProductInfoInquiryDTO product = vendorRepository.findProductInfo(vendorId, productId);
    List<ProductOptionDetailInfoDTO> optionList = vendorRepository.findProductOptionInfo(productId);

    product.addOptionGroup(new ProductOptionGroupInfoDTO(optionList));

    return product;
  }

  @Override
  public RestaurantInfoInquiryDTO getRestaurant(Long vendorId) throws Exception {
    return vendorRepository.findRestaurantInfo(vendorId);
  }

  @Override
  public String updateProduct(Long vendorId, Long productId, ProductInfoDTO productInfo) throws Exception {

    long result = menuRepository.modifyProductInfo(vendorId, productId, productInfo);
    if(result == 0) throw new MenuModificationFailException();

    long optionCount = productInfo.getOptionGroup().getOptionDetails().size();
    long successCount = menuRepository.modifyOptionDetailInfo(productInfo.getOptionGroup().getOptionDetails());

    if(successCount != optionCount) throw new OptionDetailUpdateFailException();

    return null;
  }

  @Override
  public ProductInfoRegistrationResultDTO registerProductInfo(Long vendorId, ProductInfoRegistrationDTO productInfo) throws Exception {

    Menu menuEntity = productInfo.toMenuEntity(vendorId);

    Menu savedMenu = menuRepository.save(menuEntity);

    OptionGroup savedOptionGroup = optionGroupRepository.save(new OptionGroup(savedMenu.getMenuId()));

    List<OptionDetail> optionDetails = OptionDetail.addOptionDetails(savedOptionGroup.getOptionGroupId(), productInfo.getOptionGroup().getOptionDetails());

    List<OptionDetail> savedOptionDetails;
    if(optionDetails.size() != 0) {
      savedOptionDetails = optionDetailRepository.saveAll(optionDetails);
    }
    else {
      savedOptionDetails = Collections.EMPTY_LIST;
      log.info("No Menu Option Detail to register");
    }

    return ProductInfoRegistrationResultDTO.addProduct(savedMenu, savedOptionDetails);
  }

  @Override
  public VendorRegistrationResultDTO registerVendor(VendorRegistrationDTO vendorInfo) throws Exception {

    Vendor savedVendor = vendorRepository.save(vendorInfo.toVendorEntity());

    Restaurant savedRestaurant = restaurantRepository.save(vendorInfo.toRestaurantEntity());

    return VendorRegistrationResultDTO.addVendorAndRestaurant(savedVendor, savedRestaurant);

  }

  @Override
  public VendorProfileInquiryDTO getVendorProfile(Long vendorId) throws Exception {

    Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(NoVendorProfileException::new);
    Restaurant restaurant = restaurantRepository.findById(vendorId).get();

    return VendorProfileInquiryDTO.setProfile(vendor, restaurant);
  }

  @Transactional(isolation = Isolation.SERIALIZABLE)
  @Override
  public String removeVendor(Long vendorId) {
    try {
      vendorRepository.deleteById(vendorId);
      Long restaurantId = restaurantRepository.findById(vendorId).get().getRestaurantId();
      List<Long> menuIdList = menuRepository.findIdList(restaurantId);
      menuRepository.deleteAllById(menuIdList);
      List<Long> optionGroupIdList = optionGroupRepository.findIdList(menuIdList);
      optionGroupRepository.deleteAllById(optionGroupIdList);
      List<Long> optionDetailIdList = optionDetailRepository.findIdList(optionGroupIdList);
      optionDetailRepository.deleteAllById(optionDetailIdList);

      return "Success";
    }
    catch (Exception e) {
      log.info("Vendor Info Removal Failed = {}", e.getMessage());
      return "Fail";
    }
  }
}
