package com.prueba.franquicias.repository;

import com.prueba.franquicias.entity.FranquiciaEntity;
import com.prueba.franquicias.entity.ProductoEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface FranquiciaRepository extends R2dbcRepository<FranquiciaEntity, UUID> {
    Mono<FranquiciaEntity> findByFranId(UUID franId);
}
