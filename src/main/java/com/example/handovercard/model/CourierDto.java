package com.example.handovercard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourierDto extends HandedOverCardDto{
    private YesNo byCourier;
    private String courierName;
}
