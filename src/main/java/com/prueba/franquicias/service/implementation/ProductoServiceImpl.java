package com.prueba.franquicias.service.implementation;

import com.prueba.franquicias.dto.ProductoDTO;
import com.prueba.franquicias.entity.ProductoEntity;
import com.prueba.franquicias.repository.FranquiciaRepository;
import com.prueba.franquicias.repository.ProductoRepository;
import com.prueba.franquicias.repository.SucursalRepository;
import com.prueba.franquicias.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    @Autowired private ProductoRepository productoRepository;
    @Autowired private SucursalRepository sucursalRepository;
    @Autowired private FranquiciaRepository franquiciaRepository;

    @Override
    @Transactional
    public Mono<ProductoEntity> agregarProducto(ProductoDTO request) {
        return sucursalRepository.findById(request.getSucuId())
                .switchIfEmpty(Mono.error(new RuntimeException("Sucursal no encontrada con ID: " + request.getSucuId())))
                .flatMap(sucursal -> productoRepository.save(
                        ProductoEntity.builder()
                                .nombre(request.getNombre())
                                .stock(request.getStock())
                                .sucuId(request.getSucuId())
                                .build()
                ));
    }

    @Override
    @Transactional
    public Mono<Void> eliminarProducto(UUID sucursalId, UUID productoId) {
        return productoRepository.findById(productoId)
                .switchIfEmpty(Mono.error(new RuntimeException("Producto no encontrado con ID: " + productoId)))
                .flatMap(producto -> {
                    if (!producto.getSucuId().equals(sucursalId)) {
                        return Mono.error(new RuntimeException("El producto no pertenece a la sucursal indicada"));
                    }
                    return productoRepository.delete(producto);
                });
    }

    @Override
    @Transactional
    public Mono<ProductoEntity> modificarStock(ProductoDTO request) {
        return productoRepository.findById(request.getProdId())
                .switchIfEmpty(Mono.error(new RuntimeException("Producto no encontrado con ID: " + request.getProdId())))
                .flatMap(producto -> {
                    producto.setStock(request.getStock());
                    return productoRepository.save(producto);
                });
    }

    @Override
    public Flux<ProductoDTO> obtenerProductosMaxStockPorSucursal(UUID franquiciaId) {
        return franquiciaRepository.findById(franquiciaId)
                .switchIfEmpty(Mono.error(new RuntimeException("Franquicia no encontrada con ID: " + franquiciaId)))
                .flatMapMany(franquicia -> sucursalRepository.findByFranqId(franquicia.getFranId()))
                .flatMap(sucursal -> productoRepository.findBySucuId(sucursal.getSucuId())
                        .sort(Comparator.comparingInt(ProductoEntity::getStock).reversed())
                        .next()
                        .map(prod -> ProductoDTO.builder()
                                .prodId(prod.getProdId())
                                .nombre(prod.getNombre())
                                .stock(prod.getStock())
                                .sucuId(sucursal.getSucuId())
                                .build())
                );
    }

    @Override
    @Transactional
    public Mono<ProductoEntity> actualizarNombreProducto(ProductoDTO request) {
        return productoRepository.findByProdId(request.getProdId())
                .switchIfEmpty(Mono.error(new RuntimeException("Producto no encontrado con ID: " + request.getProdId())))
                .flatMap(producto -> {
                    producto.setNombre(request.getNombre());
                    return productoRepository.save(producto);
                });
    }
}
