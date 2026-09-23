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

@Table(name = "sucursales", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SucursalEntity{
    @Id
    @Column("sucu_id")
    private UUID sucuId;

    @Column("nombre")
    private String nombre;

    @Column("estado")
    private String estado;

    @Column("franq_id")
    private UUID franqId;

    @Column("fecha")
    private OffsetDateTime fecha;
}
