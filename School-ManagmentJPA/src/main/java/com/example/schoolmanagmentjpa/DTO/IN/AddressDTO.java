package com.example.schoolmanagmentjpa.DTO.IN;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotEmpty(message = "area cannot be empty")
    private String area;

    @NotEmpty(message = "street cannot be empty")
    @Size(min = 3,max = 15,message = "street length must be between 3 and 15")
    private String street;

    @NotNull(message = "building number cannot be null")
    @Positive(message = "building number must be positive")
    private Integer buildingNumber;
}