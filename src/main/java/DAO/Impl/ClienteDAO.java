package DAO.Impl;

import Config.JpaUtil;
import DAO.IClienteDAO;
import Entities.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteDAO implements IClienteDAO {

    private EntityManager em;
    private final JpaUtil config;

    public ClienteDAO() {
        config = new JpaUtil();
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        em = config.getConnection();
        Long count = em.createQuery("SELECT COUNT(c) FROM Cliente c WHERE c.id = :id",
                Long.class)
                .setParameter("id",cliente.getId())
                .getSingleResult();
        try{
            em.getTransaction().begin();
            if(count>0){
                em.persist(cliente);
            }
            em.getTransaction().commit();
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }

        }finally {
            em.close();
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        em = config.getConnection();

        try{
            em.getTransaction().begin();
            if(cliente!=null){
                em.merge(cliente);
            }
            em.getTransaction().commit();
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }

        }finally {
            em.close();
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        em = config.getConnection();

        try{
            em.getTransaction().begin();
            if(cliente!=null){
                em.remove(cliente);
            }
            em.getTransaction().commit();
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }

        }finally {
            em.close();
        }
    }

    @Override
    public List<Cliente> listarClientes() {
        em=config.getConnection();

        return em.createNamedQuery("Cliente.showAll",Cliente.class).setMaxResults(100).getResultList();
    }

    @Override
    public List<Cliente> listarClientesPorApellido() {
        em=config.getConnection();

        return em.createNamedQuery("Cliente.showByLastName",Cliente.class).setMaxResults(100).getResultList();
    }
}
