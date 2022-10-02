package org.healthplus.vendor.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ProductOptionGroupInfoDTO {

  private List<ProductOptionDetailInfoDTO> optionDetails;

  public ProductOptionGroupInfoDTO(List<ProductOptionDetailInfoDTO> optionDetails) {
    this.optionDetails = optionDetails;
  }
}
