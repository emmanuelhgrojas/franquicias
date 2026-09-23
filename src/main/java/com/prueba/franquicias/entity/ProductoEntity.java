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

@Table(name = "productos", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoEntity{
    @Id
    @Column("prod_id")
    private UUID prodId;

    @Column("nombre")
    private String nombre;

    @Column("stock")
    private Integer stock;

    @Column("estado")
    private String estado;

    @Column("sucu_id")
    private UUID sucuId;

    @Column("fecha")
    private OffsetDateTime fecha;
}
