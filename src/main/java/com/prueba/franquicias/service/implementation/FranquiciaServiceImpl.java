package com.prueba.franquicias.service.implementation;

import com.prueba.franquicias.dto.FranquiciaDTO;
import com.prueba.franquicias.entity.FranquiciaEntity;
import com.prueba.franquicias.repository.FranquiciaRepository;
import com.prueba.franquicias.service.IFranquiciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FranquiciaServiceImpl implements IFranquiciaService {

    @Autowired private FranquiciaRepository franquiciaRepository;

    @Override
    @Transactional
    public Mono<FranquiciaEntity> crearFranquicia(FranquiciaDTO request) {
        FranquiciaEntity franquicia = FranquiciaEntity.builder()
                .nombre(request.getNombre())
                .build();
        return franquiciaRepository.save(franquicia);
    }

    @Override
    @Transactional
    public Mono<FranquiciaEntity> actualizarNombreFranquicia(FranquiciaDTO request) {
        return franquiciaRepository.findByFranId(request.getFranId())
                .switchIfEmpty(Mono.error(new RuntimeException("Franquicia no encontrada con ID: " + request.getFranId())))
                .flatMap(franquicia -> {
                    franquicia.setNombre(request.getNombre());
                    return franquiciaRepository.save(franquicia);
                });
    }
}
