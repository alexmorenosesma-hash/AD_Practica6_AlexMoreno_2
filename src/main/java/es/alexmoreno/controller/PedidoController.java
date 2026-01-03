/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.alexmoreno.controller;

import es.alexmoreno.domain.Pedido;
import es.alexmoreno.domain.Producto;
import es.alexmoreno.service.PedidoService;
import es.alexmoreno.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;
    
    @Autowired
    ProductoService productoService;
    
    
    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido){
        return pedidoService.añadirPedido(pedido);
    }
    
    @PostMapping("/{id}/producto/{idProducto}")
    public void añadirProductoPedido(@PathVariable long id, @PathVariable long idProducto){
        Pedido pedido=pedidoService.buscarPorId(id);
        Producto producto=productoService.buscarPorId(idProducto);
        pedidoService.añadirProductoPedido(producto, pedido);
        
    }
    
    @DeleteMapping("/{id}/producto/{idProducto}")
    public void eliminarProductoPedido(@PathVariable long id, @PathVariable long idProducto){
        Pedido pedido=pedidoService.buscarPorId(id);
        Producto producto=productoService.buscarPorId(idProducto);
        pedidoService.eliminarProductoPedido(producto, pedido);
    }
    
}    

