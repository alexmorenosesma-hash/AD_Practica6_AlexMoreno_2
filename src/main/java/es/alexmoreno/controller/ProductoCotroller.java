package es.alexmoreno.controller;

import es.alexmoreno.domain.Producto;
import es.alexmoreno.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins ="*")
public class ProductoCotroller {
    @Autowired
    ProductoService productoService;
    
    //Muestra todos los productos mediante una petición http
    @GetMapping
    public List<Producto> listar(){
        return productoService.listarTodos();
    }
    
    //Busca un producto concreto por medio de la id indicada en el endpoint por medio de una petición http
    @GetMapping("/{id}")
    public Producto buscarId(@PathVariable long id){
        Producto producto=productoService.buscarPorId(id);
        return producto;
    }
    
    //Crea un producto concreto por medio de una petición http
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){
        return productoService.añadirProducto(producto);
    }
    //Modifica un producto concreto por medio de la id indicada en el endpoint por medio de una petición http
    //Tambien el producto es enviado por medio el body siendo un json.
    @PutMapping("/{id}")
    public Producto modificarProducto(@PathVariable long id, @RequestBody Producto producto){
        return productoService.modificarPorId(id, producto);
    }
    //Elimina un producto concreto por medio de la id indicada en el endpoint por medio de una petición http
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable long id){
        productoService.eliminarProducto(id);
    }
}
