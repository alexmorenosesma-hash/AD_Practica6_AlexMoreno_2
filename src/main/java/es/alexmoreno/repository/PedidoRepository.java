package es.alexmoreno.repository;

import es.alexmoreno.domain.Pedido;
import es.alexmoreno.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long>{
    
}
