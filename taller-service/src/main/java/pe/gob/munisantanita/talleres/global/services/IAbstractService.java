package pe.gob.munisantanita.talleres.global.services;



import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;

import java.util.List;

public interface IAbstractService<T, ID> {
    T save(T object) throws ResourceFieldsException;
    T update(T object) throws ResourceFieldsException;
    void deleteById(ID id);
    T findById(ID id) throws ResourceFieldsException;
    List<T> findAll();
}
