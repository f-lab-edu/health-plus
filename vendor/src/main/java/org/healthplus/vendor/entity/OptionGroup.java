package org.healthplus.vendor.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.dto.ProductOptionGroupInfoDTO;
import org.healthplus.vendor.enums.IsYn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Getter
@ToString
@Entity
@Table(name = "option_group")
@NoArgsConstructor
public class OptionGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "option_group_id")
  private Long optionGroupId;

  @Column(name = "menu_id")
  private Long menuId;

  @Column(name = "name")
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "basic_choice_yn")
  private IsYn basicChoiceYn;

  @Enumerated(EnumType.STRING)
  @Column(name = "etc_choice_yn")
  private IsYn etcChoiceYn;

  @Enumerated(EnumType.STRING)
  @Column(name = "use_yn")
  private IsYn useYn;

  public OptionGroup(Long menuId, String name, IsYn basicChoiceYn, IsYn etcChoiceYn) {
    this.menuId = menuId;
    this.name = name;
    this.basicChoiceYn = basicChoiceYn;
    this.etcChoiceYn = etcChoiceYn;
    this.useYn = IsYn.Y;
  }

}
