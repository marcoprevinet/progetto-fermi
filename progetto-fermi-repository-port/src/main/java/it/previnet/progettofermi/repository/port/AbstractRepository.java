package it.previnet.progettofermi.repository.port;

public interface AbstractRepository<T> {
    T findByToken(Integer token);

    void persist(T entityToPersist);

    void flush();

    void remove(T entityToDelete);

    T findReference(Integer token);
}
