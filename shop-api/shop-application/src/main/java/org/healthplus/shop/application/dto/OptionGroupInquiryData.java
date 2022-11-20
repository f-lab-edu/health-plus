package org.healthplus.shop.application.dto;

import lombok.Getter;
import org.healthplus.shop.domain.shop.enums.IsYn;

import java.util.List;

@Getter
public class OptionGroupInquiryData {

  private Long optionGroupId;
  private IsYn basicChoiceYn;
  private IsYn etcChoiceYn;
  private List<OptionInquiryData> optionDataList;


}
