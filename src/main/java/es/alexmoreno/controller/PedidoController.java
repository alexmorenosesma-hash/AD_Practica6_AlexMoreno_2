/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.alexmoreno.controller;

import es.alexmoreno.assembler.PedidoAssembler;
import es.alexmoreno.domain.Pedido;
import es.alexmoreno.domain.Producto;
import es.alexmoreno.dto.PedidoDTO;
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
    
    @Autowired
    PedidoAssembler pedidoAssembler;
    
    
    //Para crear mediante una petición http un pedido
    @PostMapping
    public PedidoDTO crearPedido(@RequestBody PedidoDTO pedidoDto){
        Pedido pedido=pedidoAssembler.toEntity(pedidoDto);
        pedido=pedidoService.añadirPedido(pedido);
        return pedidoAssembler.toDTO(pedido);
    }
    
    //Para añadir un producto a un pedido mediante una petición http
    @PostMapping("/{id}/producto/{idProducto}")
    public void añadirProductoPedido(@PathVariable long id, @PathVariable long idProducto){
        Pedido pedido=pedidoService.buscarPorId(id);
        Producto producto=productoService.buscarPorId(idProducto);
        pedidoService.añadirProductoPedido(producto, pedido);        
    }
    
    //Para eliminar un producto a un pedido mediante una petición http
    @DeleteMapping("/{id}/producto/{idProducto}")
    public void eliminarProductoPedido(@PathVariable long id, @PathVariable long idProducto){
        Pedido pedido=pedidoService.buscarPorId(id);
        Producto producto=productoService.buscarPorId(idProducto);
        pedidoService.eliminarProductoPedido(producto, pedido);
    }
    
}    

