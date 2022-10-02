package org.healthplus.vendor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.model.entity.CommonDateTime;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.enums.Category;
import org.healthplus.vendor.enums.IsYn;
import org.healthplus.vendor.enums.MenuType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Entity
@Table(name = "menu")
@NoArgsConstructor
public class Menu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "menu_id")
  private Long menuId;

  @Column(name = "restaurant_id")
  private Long restaurantId;

  @Column(name = "category_id")
  private Long categoryId;

  @Enumerated(EnumType.STRING)
  private MenuType type;

  @Column(name = "desc")
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(name = "sold_yn")
  private IsYn soldYn;

  @Enumerated(EnumType.STRING)
  @Column(name = "use_yn")
  private IsYn useYn;

  @Embedded
  private CommonDateTime commonDateTime;

  private String name;
  private Integer price;
  private Integer calorie;

  @Builder
  public Menu(Long menuId,
              Long restaurantId,
              Long categoryId,
              CommonDateTime commonDateTime,
              String name,
              Integer price,
              Integer calorie,
              String description) {
    this.menuId = menuId;
    this.restaurantId = restaurantId;
    this.categoryId = categoryId;
    this.commonDateTime = commonDateTime;
    this.name = name;
    this.price = price;
    this.calorie = calorie;
    this.description = description;
  }

  public static Menu addMenu(Long vendorId, ProductInfoRegistrationDTO dto) {
    return Menu.builder()
            .name(dto.getName())
            .price(dto.getPrice())
            .calorie(dto.getCalorie())
            .description(dto.getDescription())
            .commonDateTime(new CommonDateTime(LocalDateTime.now()))
            .categoryId(Category.selectCategoryId(dto.getType()))
            .restaurantId(vendorId)
            .build();
  }
}
