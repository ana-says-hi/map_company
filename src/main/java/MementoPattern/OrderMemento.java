package MementoPattern;

import Domains.Status;

public class OrderMemento {
    private String status;//=getState().toString();

    public OrderMemento(String state) {
        this.status = state.toString();
    }

    public OrderMemento(Status status) {
    }

    public String getState() {
        return status;
    }

}
