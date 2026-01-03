/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.alexmoreno.service;

import es.alexmoreno.domain.Pedido;
import es.alexmoreno.domain.Producto;
import es.alexmoreno.repository.PedidoRepository;
import es.alexmoreno.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;
    
    
    @Transactional
    public Pedido añadirPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    
    @Transactional
    public Pedido buscarPorId(long id){
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }
    
    
    @Transactional
    public void añadirProductoPedido(Producto producto,Pedido pedido){
        pedido.getProductos().add(producto);
        pedidoRepository.save(pedido);
    }
    
    @Transactional
    public void eliminarProductoPedido(Producto producto,Pedido pedido){
       pedido.getProductos().remove(producto);
       pedidoRepository.save(pedido);
    }
}
