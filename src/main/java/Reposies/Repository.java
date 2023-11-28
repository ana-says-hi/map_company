package Reposies;

import Domains.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Repository <T>{
    public void add_to_repo(T c);
    public void remove_from_repo(T c) throws SQLException;
    public ArrayList<T> get_repo();
    public ArrayList<T> get_from_db() throws SQLException;
    //private String covertToString(List<Object> liste);
    //private List<T> convertFromString(String string);
}
