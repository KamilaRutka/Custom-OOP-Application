package com.example.carrent.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentDTO {
    private Long userId;
    private Long carId;
    private Integer days;

}
