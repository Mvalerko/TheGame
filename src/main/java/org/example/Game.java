package org.example;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
>>>>>>> e085968f11b5ce6d94c33cb27cee957d3f58ee85

public class Game {
    private Player optOne;
    private Player optTwo;
<<<<<<< HEAD
    HashMap<String, Player> playersList = new HashMap<>();
=======
    List<Player> playersList = new ArrayList<>();
>>>>>>> e085968f11b5ce6d94c33cb27cee957d3f58ee85

    public void register(String name, Player item) {

        playersList.put(name, item);
    }
    public int round(String playerName1, String playerName2) {

<<<<<<< HEAD
        if (matchesName(playerName1) == false | matchesName(playerName2) == false) {
=======
    public int round(String playerName1, String playerName2) {

        if (findByName(playerName1) == null | findByName(playerName2) == null) {
>>>>>>> e085968f11b5ce6d94c33cb27cee957d3f58ee85
            throw new NotRegisteredException("При попытке провести сражение возникла ошибка." +
                    "Кто-то из игроков не зарегестрирован на турнире. Операция не выполнена.");
        } else {

<<<<<<< HEAD
            this.optOne = playersList.get(playerName1);
            this.optTwo = playersList.get(playerName2);

=======
            this.optOne = findByName(playerName1);
            this.optTwo = findByName(playerName2);
        }

        if (optOne.getStrength() < optTwo.getStrength()) {
            return 2;
        } else if (optOne.getStrength() > optTwo.getStrength()) {
            return 1;
        } else {
            return 0;
>>>>>>> e085968f11b5ce6d94c33cb27cee957d3f58ee85
        }
        if (optOne.getStrength() < optTwo.getStrength()) {
            return 2;
        } else if (optOne.getStrength() > optTwo.getStrength()) {
            return 1;
        } else {
            return 0;
        }

    }

<<<<<<< HEAD
    public boolean matchesName(String nameOpt) {
        if (playersList.containsKey(nameOpt)) {
=======

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
>>>>>>> e085968f11b5ce6d94c33cb27cee957d3f58ee85
            return true;
        } else {
            return false;
        }
    }
    public HashMap<String, Player> getItems() {
        return playersList;
    }
}
