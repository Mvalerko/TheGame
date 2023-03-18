package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playersList = new ArrayList<>();

    public void register(Player item){

        playersList.add(item);
    }

    public List<Player> getItems() {
        return playersList;
    }


}
