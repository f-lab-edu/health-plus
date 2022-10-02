package org.healthplus.vendor.dto;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.model.entity.CommonDateTime;
import org.healthplus.vendor.entity.Menu;
import org.healthplus.vendor.enums.Category;

import java.time.LocalDateTime;

@Getter
@Builder
public class ProductInfoRegistrationDTO {

  private String name;
  private Integer price;
  private String description;
  private Integer calorie;
  private String type;
  private ProductOptionGroupInfoDTO optionGroup;


  public Menu toMenuEntity(Long vendorId) {
    return Menu.builder()
            .name(name)
            .price(price)
            .calorie(calorie)
            .description(description)
            .commonDateTime(new CommonDateTime(LocalDateTime.now()))
            .categoryId(Category.selectCategoryId(type))
            .restaurantId(vendorId)
            .build();

  }

}
