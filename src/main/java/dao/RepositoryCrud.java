package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface RepositoryCrud<T>  {
	Optional<T> save(T object) throws SQLException;
	Optional<T> findByOne(Long id) throws SQLException;
	List<T> findAll() throws SQLException;
	void delete(Long id) throws SQLException;
}
