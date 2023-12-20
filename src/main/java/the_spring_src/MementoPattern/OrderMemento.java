package the_spring_src.MementoPattern;

import the_spring_src.Domains.Status;

public class OrderMemento {
    private String status;//=getState().toString();

    public OrderMemento(String state) {
        this.status = state;
    }

    public OrderMemento(Status status) {
        this.status = status.toString();
    }

    public String getState() {
        return status;
    }

}
