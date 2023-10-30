package Controll;

import Domains.Product;

import java.util.ArrayList;

public class ClientController implements Controller{
    //ca sa nu facem acum implementare de comenzi bagam mesaj cum ca suntem
    //inafara progrramului/se fac renovari/modificari la sistem si revenim in 2 saptamani

    private String datei;
    private ArrayList<Product> stuff;

    public ClientController(String datei, ArrayList<Product> stuff) {
        this.datei = datei;
        this.stuff = stuff;
    }

    public void create() {

    }


    public void update() {

    }


    public void find(int id) {

    }

    public void delete(int id) {

    }
}