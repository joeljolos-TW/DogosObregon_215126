package Service.impl;


import DAO.IHotDogDAO;
import DAO.Impl.HotDogDAO;
import Entities.HotDog;
import Service.IHotdogService;

import java.math.BigDecimal;
import java.util.List;

public class HotdogService implements IHotdogService {
    private IHotDogDAO iHotDogDAO;

    public HotdogService() {
        this.iHotDogDAO = new HotDogDAO();
    }

    @Override
    public void agregarHotDog(HotDog hotDog) {

        if(hotDog != null){
            iHotDogDAO.agregarHotDog(hotDog);
        }
    }

    @Override
    public void actualizarHotDog(HotDog hotDog) {
        if(hotDog != null){
            iHotDogDAO.actualizarHotDog(hotDog);
        }
    }

    @Override
    public void eliminarHotDog(HotDog hotDog) {
        if (hotDog != null) {
            iHotDogDAO.eliminarHotDog(hotDog);
        }
    }

    @Override
    public HotDog buscarPorId(int id) {
        if(id > 0){
            return iHotDogDAO.buscarPorId(id);
        }
        return null;
    }

    @Override
    public List<HotDog> listarHotDogs() {
        return iHotDogDAO.listarHotDogs();
    }

    @Override
    public List<HotDog> listarHotDogsPorPrecio() {
        return iHotDogDAO.listarHotDogsPorPrecio();
    }

    @Override
    public List<HotDog> listarHotDogsPorPrecio(BigDecimal precio) {
        return iHotDogDAO.listarHotDogsPorPrecio(precio);
    }

    @Override
    public List<HotDog> listarHotDogsPorNombreASC() {
        return iHotDogDAO.listarHotDogsPorNombreASC();
    }

    @Override
    public List<HotDog> listarHotDogsPorNombreDESC() {
        return iHotDogDAO.listarHotDogsPorNombreDESC();
    }
}
