package Reposies;

import Domains.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class FeedbackRepo implements Repository<Feedback>{

    private ArrayList<Feedback> f_repo=new ArrayList<>();

    public void add_to_repo(Feedback f){
        f_repo.add(f);
    }

    public void remove_from_repo(Feedback f){
        f_repo.remove(f);
    }

    public ArrayList<Feedback> get_repo() {
        return f_repo;
    }

    @Override
    public ArrayList<Feedback> get_from_db() throws SQLException {
        return null;
    }

}
