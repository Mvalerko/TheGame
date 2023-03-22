package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Game {
    private Player optOne;
    private Player optTwo;
    List<Player> playersList = new ArrayList<>();

    public void register(Player item) {

        playersList.add(item);
    }

    public int round(String playerName1, String playerName2) {

        if (findByName(playerName1) == null | findByName(playerName2) == null) {
            throw new NotRegisteredException("При попытке провести сражение возникла ошибка." +
                    "Кто-то из игроков не зарегестрирован на турнире. Операция не выполнена.");
        } else {

            this.optOne = findByName(playerName1);
            this.optTwo = findByName(playerName2);
        }

        if (findById(optOne.getId()) == null | findById(optTwo.getId()) == null) {
            throw new NotRegisteredException("При попытке провести сражение возникла ошибка." +
                    "Кто-то из игроков не зарегестрирован на турнире. Операция не выполнена.");
        } else {
            if (optOne.getStrength() < optTwo.getStrength()) {
                return 2;
            } else if (optOne.getStrength() > optTwo.getStrength()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public Player findById(int idOpt) {

        for (Player product : playersList) {
            if (matchesId(product, idOpt)) {
                return product;
            }
        }
        return null;
    }

    public boolean matchesId(Player product, int search) {
        if (product.getId() == search) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
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
        if (product.getName().equals(search)){
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
