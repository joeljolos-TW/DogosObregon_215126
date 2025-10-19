package Service.impl;

import DAO.IPedidoDAO;
import DAO.Impl.PedidoDAO;
import Entities.Pedido;
import Service.IPedidoService;

import java.time.LocalDate;
import java.util.List;

public class PedidoService implements IPedidoService {

    private IPedidoDAO iPedidoDAO;

    public PedidoService() {
        this.iPedidoDAO = new PedidoDAO();
    }

    @Override
    public void agregarPedido(Pedido pedido) {
        if(pedido!=null
                && (pedido.getFecha().isBefore(LocalDate.now().atStartOfDay())
                    || pedido.getFecha().equals(LocalDate.now()))) {
            iPedidoDAO.agregarPedido(pedido);
        }
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        if(pedido!=null
                && (pedido.getFecha().isBefore(LocalDate.now().atStartOfDay())
                || pedido.getFecha().equals(LocalDate.now()))) {
            iPedidoDAO.actualizarPedido(pedido);
        }
    }

    @Override
    public void eliminarPedido(Pedido pedido) {
        if(pedido!=null
                && (pedido.getFecha().isBefore(LocalDate.now().atStartOfDay())
                || pedido.getFecha().equals(LocalDate.now()))) {
            iPedidoDAO.eliminarPedido(pedido);
        }
    }

    @Override
    public Pedido buscarPorId(int id) {
        if(id>0){
            return iPedidoDAO.buscarPorId(id);
        }else{
            System.out.println("no se a encontrado el pedido");
            return null;
        }
    }

    @Override
    public List<Pedido> listarPedidos() {
        return iPedidoDAO.listarPedidos();
    }

    @Override
    public List<Pedido> listarPedidosPorMetodoDePago(String metodoPago) {
        return iPedidoDAO.listarPedidosPorMetodoDePago(metodoPago);
    }

    @Override
    public List<Pedido> listarPedidosPorFecha(LocalDate fecha) {
        return iPedidoDAO.listarPedidosPorFecha(fecha);
    }

    @Override
    public List<Pedido> listarPedidosPorFechaASC(LocalDate fecha) {
        return iPedidoDAO.listarPedidosPorFechaASC(fecha);
    }

    @Override
    public List<Pedido> listarPedidosPorFechaDESC(LocalDate fecha) {
        return iPedidoDAO.listarPedidosPorFechaDESC(fecha);
    }
}
