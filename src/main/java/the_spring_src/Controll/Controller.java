package the_spring_src.Controll;

import org.springframework.http.ResponseEntity;

public interface Controller<T>{
    /**
     * CRUD + find smth
     */
  //  public void create(kwag*  args**);  Object... x
//    public void update();
    // TODO get instance get stuff
    public ResponseEntity<T> find_by_id(int id);
    public ResponseEntity<Void> delete(int id);

}
