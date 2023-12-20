package the_spring_src.FactoryPattern;

import the_spring_src.Domains.Client;

public class ClientFactory {

    static ClientFactory cf_instance;
    private int id=200000;

    private ClientFactory() {}

    public static ClientFactory getInstance(){
        if(cf_instance==null)
            cf_instance=new ClientFactory();
        return cf_instance;
    }

    public Client make_cl(String name, String address){
        Client client= new Client(id, name, address);
        id++;
        return client;
    }

}
