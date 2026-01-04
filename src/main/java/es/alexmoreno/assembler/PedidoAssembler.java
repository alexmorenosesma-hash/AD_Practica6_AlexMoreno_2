/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.alexmoreno.assembler;

import es.alexmoreno.domain.Pedido;
import es.alexmoreno.domain.Producto;
import es.alexmoreno.dto.PedidoDTO;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class PedidoAssembler {
    //Combierte un objeto de tipo PedidoDTO en un objeto de tipo Pedido  
    public Pedido toEntity(PedidoDTO pedidoDTO){
     Pedido pedido=new Pedido();
     pedido.setIdPedido(pedidoDTO.getIdPedido());
     pedido.setFecha(LocalDate.parse(pedidoDTO.getFecha()));
     pedido.setCliente(pedidoDTO.getCliente());
     pedido.setEstado(pedidoDTO.getEstado());
     pedido.setTotal(pedidoDTO.getTotal());
     pedido.setProductos(pedidoDTO.getProductos());
     return pedido;
    }
    //Combierte un objeto de tipo Pedido en su versión DTO
    public PedidoDTO toDTO(Pedido pedido){
     PedidoDTO pedidoDTO=new PedidoDTO();
     pedidoDTO.setIdPedido(pedido.getIdPedido());
     pedidoDTO.setFecha(pedido.getFecha().toString());
     pedidoDTO.setCliente(pedido.getCliente());
     pedidoDTO.setEstado(pedido.getEstado());
     pedidoDTO.setTotal(pedido.getTotal());
     pedidoDTO.setProductos(pedido.getProductos());
     return pedidoDTO;
    }
    
}
