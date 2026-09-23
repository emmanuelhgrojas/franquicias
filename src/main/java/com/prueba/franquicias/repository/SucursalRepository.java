package com.prueba.franquicias.repository;

import com.prueba.franquicias.entity.SucursalEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SucursalRepository extends R2dbcRepository<SucursalEntity, UUID> {
    Flux<SucursalEntity> findByFranqId(UUID franquiciaId);
    Mono<SucursalEntity> findBySucuId(UUID sucuId);

}
