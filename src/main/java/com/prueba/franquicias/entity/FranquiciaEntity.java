package com.prueba.franquicias.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

@Table(name = "franquicias", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FranquiciaEntity{
    @Id
    @Column("fran_id")
    private UUID franId;

    @Column("nombre")
    private String nombre;

    @Column("estado")
    private String estado;

    @Column("fecha")
    private OffsetDateTime fecha;
}
