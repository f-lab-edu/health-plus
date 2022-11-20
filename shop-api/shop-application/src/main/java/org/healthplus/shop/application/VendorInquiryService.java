package org.healthplus.shop.application;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.repository.VendorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorInquiryService {

  private final VendorRepository vendorRepository;

}
