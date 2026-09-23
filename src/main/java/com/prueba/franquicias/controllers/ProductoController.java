package com.prueba.franquicias.controllers;

import com.prueba.franquicias.dto.ProductoDTO;
import com.prueba.franquicias.entity.ProductoEntity;
import com.prueba.franquicias.service.IProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, maxAge = 3600)
@RequestMapping("/producto")
public class ProductoController {

    @Autowired private IProductoService productoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductoEntity> agregarProducto(@Valid @RequestBody ProductoDTO request) {
        return productoService.agregarProducto(request);
    }

    @DeleteMapping("/{productoId}/{sucursalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> eliminarProducto(@PathVariable UUID sucursalId, @PathVariable UUID productoId) {
        return productoService.eliminarProducto(sucursalId, productoId);
    }

    @PatchMapping("/{productoId}/stock")
    public Mono<ProductoEntity> modificarStock(@Valid @RequestBody ProductoDTO request) {
        return productoService.modificarStock(request);
    }

    @GetMapping("/{franquiciaId}/productos/max-stock")
    public Flux<ProductoDTO> obtenerProductosMaxStock(@PathVariable UUID franquiciaId) {
        return productoService.obtenerProductosMaxStockPorSucursal(franquiciaId);
    }

    @PatchMapping("/{productoId}/nombre")
    public Mono<ProductoEntity> actualizarNombreProducto(@RequestBody ProductoDTO request) {
        return productoService.actualizarNombreProducto(request);
    }
}
