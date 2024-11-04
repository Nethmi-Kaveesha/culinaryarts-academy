package lk.ijse.dao;

public interface CrudDAO<T> extends SuperDAO{
    public boolean save(T object);
    public boolean update(T object);
    public boolean delete(T object);
}
