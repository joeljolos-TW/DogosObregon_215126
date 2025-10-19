package Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final String PERSISTENCE_UNIT="DogosObregonPU";
    private EntityManagerFactory emf;

    public JpaUtil() {
    }

    public EntityManager getConnection(){
        if(emf==null){
            emf= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf.createEntityManager();
    }
}
