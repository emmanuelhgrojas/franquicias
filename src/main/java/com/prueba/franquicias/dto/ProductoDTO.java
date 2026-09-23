package com.prueba.franquicias.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {
    private UUID prodId;
    private String nombre;
    private Integer stock;
    private String estado;
    private UUID sucuId;
    private OffsetDateTime fecha;
}
