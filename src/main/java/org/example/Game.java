package org.example;

import java.util.HashMap;
import java.util.Map;

public class Game {
    //List<Player> playersList = new ArrayList<>();
    HashMap<Integer, Player> playersList = new HashMap<>();

    public void register(int idOpt, Player item) {

        playersList.put(idOpt, item);
    }

    public int round(Player optOne, Player optTwo) {

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

        for (Map.Entry<Integer, Player> entry : playersList.entrySet()) {
            Integer k = entry.getKey();
            Player v = entry.getValue();
            if (matchesId(v, idOpt)) {
                return v;
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
    
    public HashMap<Integer, Player> getItems() {
        return playersList;
    }

}
