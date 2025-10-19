package Service;

import Entities.HotDog;

import java.math.BigDecimal;
import java.util.List;

public interface IHotdogService {
    void agregarHotDog(HotDog hotDog);
    void actualizarHotDog(HotDog hotDog);
    void eliminarHotDog(HotDog hotDog);

    HotDog buscarPorId(int id);

    List<HotDog> listarHotDogs();
    List<HotDog> listarHotDogsPorPrecio();
    List<HotDog> listarHotDogsPorPrecio(BigDecimal precio);
    List<HotDog> listarHotDogsPorNombreASC();
    List<HotDog> listarHotDogsPorNombreDESC();
}
