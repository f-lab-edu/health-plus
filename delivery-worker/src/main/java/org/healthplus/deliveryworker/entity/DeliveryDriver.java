package org.healthplus.deliveryworker.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.healthplus.deliveryworker.enums.CarType;
import org.healthplus.deliveryworker.enums.IsYn;
import org.healthplus.model.entity.CommonDateTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_driver")
@NoArgsConstructor
public class DeliveryDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Long driverId;

    @Enumerated(EnumType.STRING)
    @Column(name = "use_yn")
    private IsYn userYn;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "car_number")
    private String carNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "car_type")
    private CarType carType;

    @Column(name = "delete_dt")
    private LocalDateTime deletedAt;

    @Embedded
    private CommonDateTime commonDateTime;

    private String id;
    private String password;
    private String email;
    private String name;
    private String location;

    @Builder
    public DeliveryDriver(Long driverId,
                          IsYn userYn,
                          String phoneNumber,
                          String carNumber,
                          CarType carType,
                          LocalDateTime deletedAt,
                          CommonDateTime commonDateTime,
                          String id,
                          String password,
                          String email,
                          String name,
                          String location) {
        this.driverId = driverId;
        this.userYn = userYn;
        this.phoneNumber = phoneNumber;
        this.carNumber = carNumber;
        this.carType = carType;
        this.deletedAt = deletedAt;
        this.commonDateTime = commonDateTime;
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.location = location;
    }
}
