package org.healthplus.shop.application;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.repository.ShopRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopModificationService {

  private final ShopRepository shopRepository;
}

