package org.healthplus.vendor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.vendor.enums.IsYn;

import javax.persistence.*;
import java.util.ArrayList;
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

  @Enumerated(EnumType.STRING)
  @Column(name = "basic_choice_yn")
  private IsYn basicChoiceYn;

  @Enumerated(EnumType.STRING)
  @Column(name = "etc_choice_yn")
  private IsYn etcChoiceYn;

  @Enumerated(EnumType.STRING)
  @Column(name = "use_yn")
  private IsYn useYn;

  public OptionGroup(Long menuId) {
    this.menuId = menuId;
  }



}
