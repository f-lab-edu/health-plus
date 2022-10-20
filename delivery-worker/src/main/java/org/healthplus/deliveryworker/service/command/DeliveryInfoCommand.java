package org.healthplus.deliveryworker.service.command;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.deliveryworker.entity.DeliveryDriver;
import org.healthplus.deliveryworker.enums.DeliveryType;
import org.healthplus.deliveryworker.enums.IsYn;

@NoArgsConstructor
@Getter
@ToString
public class DeliveryInfoCommand {

  private String id;
  private String password;
  private String email;
  private String location;
  private DeliveryType deliveryType;
  private String vehicleNumber;
  private String phoneNumber;
  private String name;
  private IsYn userYn;

  public DeliveryInfoCommand(String id, String password, String email, String location,
      DeliveryType deliveryType, String vehicleNumber, String phoneNumber, String name,
      IsYn userYn) {
    this.id = id;
    this.password = password;
    this.email = email;
    this.location = location;
    this.deliveryType = deliveryType;
    this.vehicleNumber = vehicleNumber;
    this.phoneNumber = phoneNumber;
    this.name = name;
    this.userYn = userYn;
  }

  public DeliveryDriver toEntity() {
    return DeliveryDriver.builder()
        .id(id)
        .name(name)
        .password(password)
        .email(email)
        .location(location)
        .phoneNumber(phoneNumber)
        .vehicleNumber(vehicleNumber)
        .deliveryType(deliveryType)
        .createdAt(LocalDateTime.now())
        .userYn(userYn)
        .build();
  }
}
