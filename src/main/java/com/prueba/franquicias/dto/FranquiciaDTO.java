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
public class FranquiciaDTO {
    private UUID franId;
    private String nombre;
    private String estado;
    private Timestamp fecha;
}
