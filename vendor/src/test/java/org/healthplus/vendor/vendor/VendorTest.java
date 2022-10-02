package org.healthplus.vendor.vendor;

import org.healthplus.vendor.dto.ProductInfoInquiryDTO;
import org.healthplus.vendor.dto.RestaurantInfoInquiryDTO;
import org.healthplus.vendor.dto.VendorProfileInquiryDTO;
import org.healthplus.vendor.service.VendorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class VendorTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  VendorService vendorService;

  @Test
  void getVendorProfileByUrl() throws Exception {
    Long vendorId = 1L;

    mockMvc.perform(get("/vendor/{vendorId}/profile", vendorId)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());
  }

  @Test
  void getVendorProfile() throws Exception {
    Long vendorId = 1L;

    VendorProfileInquiryDTO vendorProfile = vendorService.getVendorProfile(vendorId);

    assertThat(vendorProfile.getBusinessName()).isEqualTo("슈퍼 샐러드");
    assertThat(vendorProfile.getBusinessNumber()).isEqualTo("1103984932");
  }

  @Test
  void removeVendor() {
    Long vendorId = 1L;

    String result = vendorService.removeVendor(vendorId);

    assertThat(result).isEqualTo("Fail");
  }
}
