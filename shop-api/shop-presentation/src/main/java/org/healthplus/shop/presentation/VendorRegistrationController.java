package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.VendorRegistrationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VendorRegistrationController {

  private final VendorRegistrationService vendorRegistrationService;
}
