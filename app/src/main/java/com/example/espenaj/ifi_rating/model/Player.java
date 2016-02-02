package com.example.espenaj.ifi_rating.model;

/**
 * Created by espenaj on 1/26/16.
 */
public class Player {
    private String name;
    private String id;
    private int elo;

    public Player(String name, String id, int elo) {
        this.name = name;
        this.id = id;
        this.elo = elo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getElo() {
        return elo;
    }
}
