package DAO.Impl;

import Config.JpaUtil;
import DAO.IPedidoDAO;
import Entities.Pedido;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class PedidoDAO implements IPedidoDAO {

    private EntityManager em;
    private JpaUtil config;

    public PedidoDAO() {
        this.config = new JpaUtil();
    }

    @Override
    public void agregarPedido(Pedido pedido) {
        em= config.getConnection();

        try{
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();

            System.out.println("insersion exitosa");
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }finally {
            em.close();
        }
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        em= config.getConnection();

        try{
            em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();

            System.out.println("insersion exitosa");
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }finally {
            em.close();
        }
    }

    @Override
    public void eliminarPedido(Pedido pedido) {
        em= config.getConnection();

        try{
            em.getTransaction().begin();
            em.remove(pedido);
            em.getTransaction().commit();

            System.out.println("insersion exitosa");
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }finally {
            em.close();
        }
    }

    @Override
    public Pedido buscarPorId(int id) {
        em=config.getConnection();

        try{
            em.getTransaction().begin();
            Pedido pedido =em.find(Pedido.class,id);
            em.getTransaction().commit();
            return pedido;
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return null;
        }finally {
            em.close();
        }
    }

    @Override
    public List<Pedido> listarPedidos() {
        em=config.getConnection();

        List<Pedido> pedidos=em.createNamedQuery("Pedido.showAll", Pedido.class)
                .setMaxResults(100)
                .getResultList();
        return pedidos;
    }

    @Override
    public List<Pedido> listarPedidosPorMetodoDePago(String metodoPago) {
        em=config.getConnection();

        List<Pedido> pedidos=em.createNamedQuery("Pedido.showByPayMethod", Pedido.class)
                .setMaxResults(100)
                .getResultList();
        return pedidos;
    }

    @Override
    public List<Pedido> listarPedidosPorFecha(LocalDate fecha) {

        em=config.getConnection();

        List<Pedido> pedidos=em.createNamedQuery("Pedido.showByDate", Pedido.class)
                .setMaxResults(100)
                .getResultList();
        return pedidos;
    }

    @Override
    public List<Pedido> listarPedidosPorFechaASC(LocalDate fecha) {
        em=config.getConnection();

        List<Pedido> pedidos=em.createNamedQuery("Pedido.showByDateASC", Pedido.class)
                .setMaxResults(100)
                .getResultList();
        return pedidos;
    }

    @Override
    public List<Pedido> listarPedidosPorFechaDESC(LocalDate fecha) {
        em=config.getConnection();

        List<Pedido> pedidos=em.createNamedQuery("Pedido.showByDateDESC", Pedido.class)
                .setMaxResults(100)
                .getResultList();
        return pedidos;
    }
}
