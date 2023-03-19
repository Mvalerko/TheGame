package org.example;

public class Player{
    protected int id;
    protected String name;
    protected int strength;

    public int getId() {
        return id;
    }

    public void setId(int idOpt) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameOpt) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strengthOpt) {
        this.strength = strength;
    }

    public Player(int idOpt, String nametOpt, int strengthOpt) {
        this.id = idOpt;
        this.name = nametOpt;
        this.strength = strengthOpt;
    }

    /*@Override
    public int compareTo(Player o) {
        if (this.strength < o.strength) {
            return -1;
        } else if (this.strength > o.strength) {
            return 1;
        } else {
            return 0;
        }
    }

     */
}
