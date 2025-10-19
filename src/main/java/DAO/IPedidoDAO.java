package DAO;

import Entities.MetodoPago;
import Entities.Pedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IPedidoDAO {
    void agregarPedido(Pedido pedido);
    void actualizarPedido(Pedido pedido);
    void eliminarPedido(Pedido pedido);

    Pedido buscarPorId(int id);

    List<Pedido> listarPedidos();
    List<Pedido> listarPedidosPorMetodoDePago(String metodoPago);
    List<Pedido> listarPedidosPorFecha(LocalDate fecha);
    List<Pedido> listarPedidosPorFechaASC(LocalDate fecha);
    List<Pedido> listarPedidosPorFechaDESC(LocalDate fecha);
}
