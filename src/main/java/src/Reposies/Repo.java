package src.Reposies;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;
import java.util.ArrayList;
//import org.springframework.data.jpa.repository.JpaRepository;

//public interface Repo extends JpaRepository<T>{
public interface Repo<T>{
    public void add_to_repo(T c) throws SQLException;
    public void remove_from_repo(T c) throws SQLException;
    public ArrayList<T> get_repo();
    public ArrayList<T> get_from_db() throws SQLException;
    //private String covertToString(List<Object> liste);
    //private List<T> convertFromString(String string);
}
