package com.prueba.franquicias.controllers;

import com.prueba.franquicias.dto.FranquiciaDTO;
import com.prueba.franquicias.entity.FranquiciaEntity;
import com.prueba.franquicias.service.IFranquiciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, maxAge = 3600)
@RequestMapping("/franquicia")
public class FranquiciaController {

    @Autowired
    private IFranquiciaService iFranquiciaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<FranquiciaEntity> crearFranquicia(@Valid @RequestBody FranquiciaDTO request) {
        return iFranquiciaService.crearFranquicia(request);
    }

    @PatchMapping("/{franquiciaId}/nombre")
    public Mono<FranquiciaEntity> actualizarNombreFranquicia(@Valid @RequestBody FranquiciaDTO request) {
        return iFranquiciaService.actualizarNombreFranquicia(request);
    }
}
