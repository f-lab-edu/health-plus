package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.VendorRemovalService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShopRemovalController {

  private final VendorRemovalService vendorRemovalService;
}
