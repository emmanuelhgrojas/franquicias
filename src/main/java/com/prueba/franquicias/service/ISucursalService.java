package com.prueba.franquicias.service;

import com.prueba.franquicias.dto.SucursalDTO;
import com.prueba.franquicias.entity.SucursalEntity;
import reactor.core.publisher.Mono;

public interface ISucursalService {
    Mono<SucursalEntity> agregarSucursal(SucursalDTO request);
    Mono<SucursalEntity> actualizarNombreSucursal(SucursalDTO request);
}
