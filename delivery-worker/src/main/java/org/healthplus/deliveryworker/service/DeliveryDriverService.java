package org.healthplus.deliveryworker.service;

import org.healthplus.deliveryworker.presentation.responseDto.DeliveryDriverProfileDTO;
import org.healthplus.deliveryworker.service.command.DeliveryInfoCommand;

public interface DeliveryDriverService {

  void driverSignUp(DeliveryInfoCommand deliveryInfoCommand);

  DeliveryDriverProfileDTO getDriverProfile(Long id);
}
