package org.example;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Player optOne;
    private Player optTwo;
    HashMap<String, Player> playersList = new HashMap<>();

    public void register(String name, Player item) {

        playersList.put(name, item);
    }
    public int round(String playerName1, String playerName2) {

        if (matchesName(playerName1) == false | matchesName(playerName2) == false) {
            throw new NotRegisteredException("При попытке провести сражение возникла ошибка." +
                    "Кто-то из игроков не зарегестрирован на турнире. Операция не выполнена.");
        } else {

            this.optOne = playersList.get(playerName1);
            this.optTwo = playersList.get(playerName2);

        }
        if (optOne.getStrength() < optTwo.getStrength()) {
            return 2;
        } else if (optOne.getStrength() > optTwo.getStrength()) {
            return 1;
        } else {
            return 0;
        }

    }

    public boolean matchesName(String nameOpt) {
        if (playersList.containsKey(nameOpt)) {
            return true;
        } else {
            return false;
        }
    }
    public HashMap<String, Player> getItems() {
        return playersList;
    }
}
