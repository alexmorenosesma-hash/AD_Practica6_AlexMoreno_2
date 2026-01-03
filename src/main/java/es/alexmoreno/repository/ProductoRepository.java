
package es.alexmoreno.repository;

import es.alexmoreno.domain.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long>{    
    Optional<Producto> findByNombre(String nombre);
    List<Producto> findByPrecio(double precio);
    List<Producto> findByCantidad(int cantidad);
    List<Producto> findByCategoria(String categoria);
    Page<Producto> findAll(Pageable pageable);
}
