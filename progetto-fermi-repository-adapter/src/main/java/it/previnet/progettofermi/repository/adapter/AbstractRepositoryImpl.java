package it.previnet.progettofermi.repository.adapter;

import it.previnet.progettofermi.repository.port.AbstractRepository;
import org.hibernate.Session;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
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
    public T findByToken(Integer token) {
        return getEntityManager().find(entityType, token);
    }

    @Override
    public T findReference(Integer token) {
        return getEntityManager().getReference(entityType, token);
    }

    @Override
    @Transactional
    public void persist(T entityToPersist) {
        getEntityManager().persist(entityToPersist);
    }

    @Override
    @Transactional
    public void flush(){
        getEntityManager().flush();
    }

    @Override
    @Transactional
    public void remove(T entityToDelete) {
        getEntityManager().remove(entityToDelete);
    }

    protected EntityManager getEntityManager() {
        // if you have to choose between more entity manager yoc can check info from uriInfo
        return entityManager;
    }

    @Override
    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
