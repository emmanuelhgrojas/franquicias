package com.prueba.franquicias.service;

import com.prueba.franquicias.dto.ProductoDTO;
import com.prueba.franquicias.entity.ProductoEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface IProductoService {
    Mono<ProductoEntity> agregarProducto(ProductoDTO request);
    Mono<Void> eliminarProducto(UUID sucursalId, UUID productoId);
    Mono<ProductoEntity> modificarStock(ProductoDTO request);
    Flux<ProductoDTO> obtenerProductosMaxStockPorSucursal(UUID franquiciaId);
    Mono<ProductoEntity> actualizarNombreProducto(ProductoDTO request);
}
