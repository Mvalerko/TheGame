package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playersList = new ArrayList<>();

    public void register(Player item) {

        playersList.add(item);
    }

    public int round(Player optOne, Player optTwo) {

        if (findById(optOne.getId()) == null | findById(optTwo.getId()) == null) {
            throw new NotRegisteredException("При попытке провести сражение возникла ошибка. Кто то из игроков не зарегестрирован на турнире" +
                    " Операция не выполнена.");
        } else {
            if (optOne.getStrength() < optTwo.getStrength()) {
                return 2;
            } else if ( optOne.getStrength() > optTwo.getStrength()) {
                return 1;
            } else {
                return 0;
            }
            //System.out.println("Все хорошо");
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

    public List<Player> getItems() {
        return playersList;
    }

}
