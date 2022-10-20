package org.healthplus.deliveryworker.presentation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.deliveryworker.presentation.requestDto.DeliveryInfoDto;
import org.healthplus.deliveryworker.presentation.responseDto.DeliveryDriverProfileDTO;
import org.healthplus.deliveryworker.service.DeliveryDriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery-driver")
@Slf4j
@RequiredArgsConstructor
public class DeliveryDriverController {

  private final DeliveryDriverService deliveryDriverService;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/signup")
  public String signUp(@RequestBody DeliveryInfoDto deliveryInfoDto) {
    log.info("deliveryInfoDto = {}", deliveryInfoDto.toString());
    deliveryDriverService.driverSignUp(deliveryInfoDto.toCommand());
    return "ok";
  }

  @GetMapping("/{driverId}/profile")
  public ResponseEntity<DeliveryDriverProfileDTO> getDriverProfile(@PathVariable Long driverId) {
    log.info("driverController driver Info = {}", driverId);
    return ResponseEntity.ok(deliveryDriverService.getDriverProfile(driverId));
  }
}
