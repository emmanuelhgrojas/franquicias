package com.prueba.franquicias.controllers;

import com.prueba.franquicias.dto.SucursalDTO;
import com.prueba.franquicias.entity.SucursalEntity;
import com.prueba.franquicias.service.ISucursalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, maxAge = 3600)
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired private ISucursalService iSucursalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<SucursalEntity> agregarSucursal(@Valid @RequestBody SucursalDTO request) {
        return iSucursalService.agregarSucursal(request);
    }

    @PatchMapping("/{sucursalId}/nombre")
    public Mono<SucursalEntity> actualizarNombreSucursal(@Valid @RequestBody SucursalDTO request) {
        return iSucursalService.actualizarNombreSucursal(request);
    }
}
