package es.alexmoreno.dto;

import es.alexmoreno.domain.Producto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

public class PedidoDTO {

    private long idPedido;
    private String fecha;
    private String cliente;
    //Estado es un posible enum
    private String estado;
    private double total;
    //La relacion es many to many porque los pedidos pueden tener varios pedidos y los productos pueden estar en varios pedidos
    @ManyToMany
    @JoinTable (name = "pedido_producto",
                joinColumns = @JoinColumn(name = "idPedido"),
                inverseJoinColumns = @JoinColumn(name = "idPedido"))
    private List<Producto> productos;
    
    public PedidoDTO(){
        
    }
    public PedidoDTO (String fecha, String cliente, String estado, double total, List<Producto> productos) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.estado = estado;
        this.total = total;
        this.productos = productos;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Id pedido:"+idPedido
                +"\nFecha:"+fecha
                +"\nCliente:"+cliente
                +"\nEstado:"+estado
                +"\nPrecio total:"+total
                +"\nProdutos:"+productos;
    }
    
}
