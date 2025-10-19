package DAO.Impl;

import Config.JpaUtil;
import DAO.IHotDogDAO;
import Entities.HotDog;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class HotDogDAO implements IHotDogDAO {

    private EntityManager em;
    private JpaUtil config;

    public HotDogDAO() {
        this.config = new JpaUtil();
    }

    @Override
    public void agregarHotDog(HotDog hotDog) {
        em= config.getConnection();

        Long count = em.createQuery("SELECT COUNT(h) FROM HotDog h WHERE h.nombre = :nombre", Long.class)
                .setParameter("nombre", hotDog.getNombre())
                .getSingleResult();
        try{
            em.getTransaction().begin();
            if(count==0) {
                em.persist(hotDog);
            }else {
                System.out.println("Ya existe un HotDog con ese nombre: " + hotDog.getNombre());
            }

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
    public void actualizarHotDog(HotDog hotDog) {
        em=config.getConnection();
        try{
            em.getTransaction().begin();
            em.merge(hotDog);
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
    public void eliminarHotDog(HotDog hotDog) {
        em= config.getConnection();
        try{
            em.getTransaction().begin();
            if(em.find(HotDog.class, hotDog.getId()) != null){
                em.remove(hotDog);
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
    public HotDog buscarPorId(int id) {
        em= config.getConnection();
        try{
            em.getTransaction().begin();
            HotDog dogo = em.find(HotDog.class, id);
            em.getTransaction().commit();
            return dogo;
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
    public List<HotDog> listarHotDogs() {
        em=config.getConnection();

        List<HotDog>dogos=em.createNamedQuery("HotDog.showAll", HotDog.class)
                .setMaxResults(100)
                .getResultList();
        return dogos;
    }

    @Override
    public List<HotDog> listarHotDogsPorPrecio() {

        List<HotDog>dogos=em.createNamedQuery("HotDog.findByPrices", HotDog.class)
                .setMaxResults(100)
                .getResultList();
        return dogos;
    }

    @Override
    public List<HotDog> listarHotDogsPorPrecio(BigDecimal precio) {

        List<HotDog>dogos=em.createNamedQuery("HotDog.findByPrice", HotDog.class)
                .setParameter("precio",precio)
                .setMaxResults(100)
                .getResultList();
        return dogos;
    }

    @Override
    public List<HotDog> listarHotDogsPorNombreASC() {

        List<HotDog>dogos=em.createNamedQuery("HotDog.showByNameASC", HotDog.class)
                .setMaxResults(100)
                .getResultList();
        return dogos;
    }

    @Override
    public List<HotDog> listarHotDogsPorNombreDESC() {
        em=config.getConnection();
        List<HotDog>dogos=em.createNamedQuery("HotDog.showByNameDESC", HotDog.class)
                .setMaxResults(100)
                .getResultList();
        em.close();
        return dogos;

    }
}
