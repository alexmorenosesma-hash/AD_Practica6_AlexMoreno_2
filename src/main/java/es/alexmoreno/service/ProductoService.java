package es.alexmoreno.service;

import es.alexmoreno.repository.ProductoRepository;
import es.alexmoreno.domain.Producto;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    
    public List<Producto> listarTodos(){
        return productoRepository.findAll();
    }
    
    public Producto buscarPorId(long id){
        return productoRepository.findById(id).orElseThrow(()->new RuntimeException("El producto no existe"));
    }
    
    @Transactional
    public Producto añadirProducto(Producto producto){
        return productoRepository.save(producto);
    }
    
    @Transactional
    public Producto modificarPorId(long id, Producto producto){
        Producto original=buscarPorId(id);
        original.setNombre(producto.getNombre());
        original.setDescripcion(producto.getDescripcion());
        original.setPrecio(producto.getPrecio());
        original.setCantidad(producto.getCantidad());
        original.setCategoria(producto.getCategoria());
        return productoRepository.save(original);
    }
    
    @Transactional
    public void eliminarProducto(long id){
        productoRepository.deleteById(id);
    }
    
    
    
}
