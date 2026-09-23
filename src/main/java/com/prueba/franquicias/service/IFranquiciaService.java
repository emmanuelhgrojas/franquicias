package com.prueba.franquicias.service;

import com.prueba.franquicias.dto.FranquiciaDTO;
import com.prueba.franquicias.entity.FranquiciaEntity;
import reactor.core.publisher.Mono;

public interface IFranquiciaService {
    Mono<FranquiciaEntity> crearFranquicia(FranquiciaDTO request);
    Mono<FranquiciaEntity> actualizarNombreFranquicia(FranquiciaDTO request);
}
