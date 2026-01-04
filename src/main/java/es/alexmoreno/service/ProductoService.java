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
    
    //Para mostrar todos los productos
    public List<Producto> listarTodos(){
        return productoRepository.findAll();
    }
    
    //Para buscar un producto concreto por su ID
    public Producto buscarPorId(long id){
        return productoRepository.findById(id).orElseThrow(()->new RuntimeException("El producto no existe"));
    }
    
    //Para añadir un producto
    @Transactional
    public Producto añadirProducto(Producto producto){
        return productoRepository.save(producto);
    }
    
    //Para modificar los atributos de un producto concreto mediante su id
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
    
    //Para eliminar un producto concreto mediante su id
    @Transactional
    public void eliminarProducto(long id){
        productoRepository.deleteById(id);
    }
    
    
    
}
