package org.healthplus.vendor.menu;

import org.healthplus.vendor.dto.ProductInfoInquiryDTO;
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
}
