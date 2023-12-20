package src.Controll;

import org.springframework.http.ResponseEntity;
import src.Domains.Product;

public interface Controller<T>{
    /**
     * CRUD + find smth
     */
  //  public void create(kwag*  args**);  Object... x
//    public void update();
    // TODO get instance get stuff
    public ResponseEntity<Product> find_by_id(int id);
    public ResponseEntity<Void> delete(int id);

}
