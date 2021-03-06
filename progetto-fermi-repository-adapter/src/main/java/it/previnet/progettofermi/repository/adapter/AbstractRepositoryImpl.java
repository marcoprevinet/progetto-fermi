package it.previnet.progettofermi.repository.adapter;

import it.previnet.progettofermi.repository.port.AbstractRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractRepositoryImpl<T> implements AbstractRepository<T> {

    @Inject
    EntityManager entityManager;

    private final Class<T> entityType;

    public AbstractRepositoryImpl(){
        Class clazz= getClass();
        while(!clazz.getSuperclass().getName().equals(AbstractRepositoryImpl.class.getName())){
            clazz= clazz.getSuperclass();
        }
        entityType= (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T findByToken(Long token) {
        return getEntityManager().find(entityType, token);
    }

    @Override
    public T findReference(Long token) {
        return getEntityManager().getReference(entityType, token);
    }

    @Override
    public void persist(T entityToPersist) {
        getEntityManager().persist(entityToPersist);
    }

    @Override
    public void flush(){
        getEntityManager().flush();
    }

    @Override
    public void remove(T entityToDelete) {
        getEntityManager().remove(entityToDelete);
    }

    protected EntityManager getEntityManager() {
        // if you have to choose between more entity manager yoc can check info from uriInfo
        return entityManager;
    }
}
