package org.healthplus.vendor.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.healthplus.vendor.entity.QOptionGroup.*;


@Repository
@RequiredArgsConstructor
public class OptionGroupRepositoryImpl implements OptionGroupRepositoryCustom {

  private final JPAQueryFactory query;

  @Override
  public List<Long> findIdList(List<Long> menuIdList) {
    return query.select(optionGroup.optionGroupId)
            .from(optionGroup)
            .where(optionGroup.menuId.in(menuIdList))
            .fetch();

  }
}
