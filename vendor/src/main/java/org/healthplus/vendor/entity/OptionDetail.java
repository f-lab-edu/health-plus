package org.healthplus.vendor.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.enums.IsYn;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@ToString
@Entity
@Table(name = "option_detail")
@NoArgsConstructor
public class OptionDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "option_detail_id")
  private Long optionDetailId;

  @Column(name = "option_group_id")
  private Long optionGroupId;

  @Column(name = "name")
  private String name;

  @Column(name = "price")
  private Integer price;

  @Enumerated(EnumType.STRING)
  @Column(name = "use_yn")
  private IsYn useYn;

  public OptionDetail(Long optionGroupId, String name, Integer price) {
    this.optionGroupId = optionGroupId;
    this.name = name;
    this.price = price;
    this.useYn = IsYn.Y;
  }

  public static List<OptionDetail> addOptionDetails(Long optionGroupId, List<ProductOptionDetailInfoDTO> optionDetails) {
    if(optionDetails.size() == 0) return Collections.EMPTY_LIST;

    List<OptionDetail> optionDetailList = new ArrayList<>();
    for (ProductOptionDetailInfoDTO dto : optionDetails) {
      optionDetailList.add(new OptionDetail(optionGroupId, dto.getName(), dto.getPrice()));
    }

    return optionDetailList;
  }

  public static List<ProductOptionDetailInfoDTO> toDTO(List<OptionDetail> optionDetails) {
    List<ProductOptionDetailInfoDTO> optionDetailDTOList = new ArrayList<>();

    for (OptionDetail optionDetail : optionDetails) {
      optionDetailDTOList.add(new ProductOptionDetailInfoDTO(optionDetail.getName(), optionDetail.getPrice()));
    }

    return optionDetailDTOList;
  }
}
