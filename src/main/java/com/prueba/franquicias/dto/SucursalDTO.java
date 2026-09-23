package com.prueba.franquicias.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SucursalDTO {
    private UUID sucuId;
    private String nombre;
    private String estado;
    private UUID franqId;
    private Timestamp fecha;
}
