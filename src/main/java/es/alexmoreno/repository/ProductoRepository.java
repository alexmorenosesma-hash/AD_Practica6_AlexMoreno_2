
package es.alexmoreno.repository;

import es.alexmoreno.domain.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long>{  
    //Para poder buscar por nombre
    Optional<Producto> findByNombre(String nombre);
    //Para obtener una lista de productos con el mismo precio
    List<Producto> findByPrecio(double precio);
    //Para obtener una lista de productos con la misma cantidad
    List<Producto> findByCantidad(int cantidad);
    //Para obtener una lista de productos con la misma categoria
    List<Producto> findByCategoria(String categoria);
    //Para obtener todos los productos (solo se usa este)
    Page<Producto> findAll(Pageable pageable);
}
