package it.previnet.progettofermi.repository.port;

import org.hibernate.Session;

public interface AbstractRepository<T> {
    T findByToken(Integer token);

    void persist(T entityToPersist);

    void flush();

    void remove(T entityToDelete);

    T findReference(Long token);

    Session getSession();

}
