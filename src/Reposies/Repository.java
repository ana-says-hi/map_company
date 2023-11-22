package Reposies;

import Domains.Client;

import java.util.ArrayList;
import java.util.List;

public interface Repository <T>{
    public void add_to_repo(T c);
    public void remove_from_repo(T c);
    public ArrayList<T> get_repo();
    //private String covertToString(List<Object> liste);
    //private List<T> convertFromString(String string);
}
