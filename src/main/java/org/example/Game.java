package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Game {
    List<Player> playersList = new ArrayList<>();

    public void register(Player item) {

        playersList.add(item);
    }

    public int round(String playerName1, String playerName2) {

        Player optOne;
        Player optTwo;

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("При попытке провести сражение возникла ошибка." +
                    "Кто-то из игроков не зарегестрирован на турнире. Операция не выполнена.");
        } else {

            optOne = findByName(playerName1);

        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("При попытке провести сражение возникла ошибка." +
                    "Кто-то из игроков не зарегестрирован на турнире. Операция не выполнена.");
        } else {

            optTwo = findByName(playerName2);

        }

        if (optOne.getStrength() < optTwo.getStrength()) {
            return 2;
        } else if (optOne.getStrength() > optTwo.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }


    public Player findByName(String nameOpt) {

        for (Player product : playersList) {
            if (matchesName(product, nameOpt)) {
                return product;
            }
        }
        return null;
    }

    public boolean matchesName(Player product, String search) {
        if (product.getName().equals(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

    public List<Player> getItems() {
        return playersList;
    }

}
