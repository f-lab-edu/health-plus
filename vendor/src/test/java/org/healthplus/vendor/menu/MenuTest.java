package org.healthplus.vendor.menu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.healthplus.vendor.dto.*;
import org.healthplus.vendor.enums.MenuType;
import org.healthplus.vendor.service.VendorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MenuTest {

  @Autowired
  VendorService vendorService;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  static ProductInfoRegistrationDTO productInfo = ProductInfoRegistrationDTO.builder()
          .name("치즈 샐러드")
          .price(9000)
          .calorie(200)
          .description("치즈맛이 풍부한 샐러드")
          .categoryType("SALAD")
          .menuType(MenuType.A)
          .optionGroup(new ProductOptionGroupInfoDTO(Arrays.asList(new ProductOptionDetailInfoDTO[]{
                  new ProductOptionDetailInfoDTO("아메리칸 치즈", 11000),
                  new ProductOptionDetailInfoDTO("모짜렐라 치즈", 10000),
                  new ProductOptionDetailInfoDTO("리코타 치즈", 9500)
          })))
          .build();



  @Test
  void getProductInfoByUrl() throws Exception {
    Long vendorId = 1L;
    Long productId = 1L;

    mockMvc.perform(get("/vendor/{vendorId}/{productId}/info", vendorId, productId)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());
  }

  @Test
  void getProductInfo() throws Exception {
    Long vendorId = 1L;
    Long productId = 1L;

    ProductInfoInquiryDTO productInfo = vendorService.getProduct(vendorId, productId);

    assertThat(productInfo.getBusinessName()).isEqualTo("슈퍼 샐러드");
    assertThat(productInfo.getProductName()).isEqualTo("닭가슴살 샐러드");
    assertThat(productInfo.getOptionGroup().getOptionDetails().size()).isEqualTo(3);
  }

  @Test
  void addProductInfo() {
    Long restaurantId = 1L;

    ProductInfoRegistrationResultDTO result = vendorService.registerProductInfo(restaurantId, productInfo);

    assertThat(result).isNotNull();

  }

  @Test
  void addProductInfoByUrl() throws Exception {
    Long restaurantId = 1L;

    mockMvc.perform(post("/vendor/{restaurantId}/product", restaurantId)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(productInfo)))
            .andExpect(status().isOk())
            .andDo(print());

  }
}