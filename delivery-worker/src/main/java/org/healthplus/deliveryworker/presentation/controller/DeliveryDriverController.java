package org.healthplus.deliveryworker.presentation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.deliveryworker.presentation.requestDto.DeliveryInfoDto;
import org.healthplus.deliveryworker.service.DeliveryDriverService;
import org.healthplus.deliveryworker.service.command.DeliveryInfoCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery-driver")
@Slf4j
@RequiredArgsConstructor
public class DeliveryDriverController {

  private final DeliveryDriverService deliveryDriverService;

  @
  @PostMapping("/signup")
  public String signUp(@RequestBody DeliveryInfoDto deliveryInfoDto) {
    log.info("deliveryInfoDto = {}", deliveryInfoDto.toString());
    deliveryDriverService.driverSignUp(deliveryInfoDto.toCommand());
    return "ok";
  }
}
