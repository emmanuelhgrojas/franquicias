package com.prueba.franquicias.service.implementation;

import com.prueba.franquicias.dto.SucursalDTO;
import com.prueba.franquicias.entity.SucursalEntity;
import com.prueba.franquicias.repository.FranquiciaRepository;
import com.prueba.franquicias.repository.SucursalRepository;
import com.prueba.franquicias.service.ISucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements ISucursalService {
    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    @Transactional
    public Mono<SucursalEntity> agregarSucursal(SucursalDTO request) {
        return franquiciaRepository.findById(request.getFranqId())
                .switchIfEmpty(Mono.error(new RuntimeException("Franquicia no encontrada con ID: " + request.getFranqId())))
                .flatMap(franquicia -> sucursalRepository.save(
                        SucursalEntity.builder()
                                .nombre(request.getNombre())
                                .franqId(franquicia.getFranId())
                                .build()
                ));
    }

    @Override
    @Transactional
    public Mono<SucursalEntity> actualizarNombreSucursal(SucursalDTO request) {
        return sucursalRepository.findBySucuId(request.getSucuId())
                .switchIfEmpty(Mono.error(new RuntimeException("Sucursal no encontrada con ID: " + request.getSucuId())))
                .flatMap(sucursal -> {
                    sucursal.setNombre(request.getNombre());
                    return sucursalRepository.save(sucursal);
                });
    }
}
