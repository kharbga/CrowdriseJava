
package Idao;

import java.util.Date;
import java.util.List;

public interface IDAO<T> {

    void add(T t);

    void update(T t);

    void removeById(int id);

    List<T> findAll();

    T findById(int id);
    
    List<T> findByTitre(String titre);
    
    List<T> findByCriteria(String titre,Date deadLine,String categ);

}
