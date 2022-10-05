package org.healthplus.vendor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.model.entity.CommonDateTime;
import org.healthplus.vendor.entity.Menu;
import org.healthplus.vendor.enums.Category;
import org.healthplus.vendor.enums.MenuType;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ProductInfoRegistrationDTO {

  private String name;
  private Integer price;
  private String description;
  private Integer calorie;
  private String categoryType;
  private MenuType menuType;
  private ProductOptionGroupInfoDTO optionGroup;

  @Builder
  public ProductInfoRegistrationDTO(String name,
                                    Integer price,
                                    String description,
                                    Integer calorie,
                                    String categoryType,
                                    MenuType menuType,
                                    ProductOptionGroupInfoDTO optionGroup) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.calorie = calorie;
    this.categoryType = categoryType;
    this.menuType = menuType;
    this.optionGroup = optionGroup;
  }

  public Menu toMenuEntity(Long restaurantId) {
    return Menu.builder()
            .restaurantId(restaurantId)
            .categoryId(Category.selectCategoryId(categoryType))
            .commonDateTime(new CommonDateTime(LocalDateTime.now()))
            .name(name)
            .price(price)
            .calorie(calorie)
            .description(description)
            .menuType(menuType)
            .build();

  }

}