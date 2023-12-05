package com.daliaga.MantenedorUsuariosSpring.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TelefonoDto {

    private String number;
    private String cityCode;
    private String contryCode;
}
