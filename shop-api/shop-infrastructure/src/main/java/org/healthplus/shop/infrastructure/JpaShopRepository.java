package org.healthplus.shop.infrastructure;

import org.healthplus.shop.domain.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaShopRepository extends JpaRepository<Shop, Long> {

//  @EntityGraph(
//          attributePaths = {"menus", "menus.optionGroup", "menus.optionGroup.options"},
//          type = EntityGraph.EntityGraphType.LOAD)
//  Optional<Menu> findById(Long shopId);
}
