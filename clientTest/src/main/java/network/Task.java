package network;

import data.Route;

import java.io.Serializable;

public class Task implements Serializable {
    public String[] describe;
    public Route route;

    public Task(String[] describe) {
        this.describe = describe;
    }

    public Task() {
    }

    public Task(String[] describe, Route Route) {
        this.describe = describe;
        this.route = Route;
    }
}