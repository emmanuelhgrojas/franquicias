package com.prueba.franquicias.repository;

import com.prueba.franquicias.entity.ProductoEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProductoRepository extends R2dbcRepository<ProductoEntity, UUID> {
    Flux<ProductoEntity> findBySucuId(UUID sucursalId);
    Mono<ProductoEntity> findByProdId(UUID prodId);
}
