package org.healthplus.vendor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.vendor.entity.Menu;
import org.healthplus.vendor.enums.MenuType;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProductInfoRegistrationDTO {

  private Long categoryId;
  private String name;
  private Integer price;
  private String description;
  private Integer calorie;
  private String categoryType;
  private MenuType menuType;
  private List<ProductOptionGroupInfoDTO> optionGroup;

  @Builder
  public ProductInfoRegistrationDTO(Long categoryId,
                                    String name,
                                    Integer price,
                                    String description,
                                    Integer calorie,
                                    String categoryType,
                                    MenuType menuType,
                                    List<ProductOptionGroupInfoDTO> optionGroup) {
    this.categoryId = categoryId;
    this.name = name;
    this.price = price;
    this.description = description;
    this.calorie = calorie;
    this.categoryType = categoryType;
    this.menuType = menuType;
    this.optionGroup = optionGroup;
  }

}
