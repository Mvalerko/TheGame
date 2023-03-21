import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    Player linkor = new Player(
            1,
            "=L1nk0R=",
            7

    );
    Player error = new Player(
            2,
            "//OShiBka",
            6

    );

    Player venom = new Player(
            3,
            "ÌveNomì!",
            6

    );

    Player slot = new Player(
            3,
            "-SLOT-",
            5

    );

    @Test
    void findAllSearchWithSort() {
        Game repo = new Game();

        repo.register(1,linkor);
        repo.register(2,error);


        HashMap<Integer,Player> expected = repo.getItems();
        expected.put(1, linkor);
        expected.put(2, error);

        HashMap<Integer,Player> actual = repo.getItems();

        assertEquals(expected, actual);
    }


    @Test
    void fightNotRegisteredTwo() {
        Game repo = new Game();

        repo.register(1, linkor);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round(linkor, error);
        });
    }
    @Test
    void fightNotRegisteredOne() {
        Game repo = new Game();

        repo.register(2, error);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round(linkor, error);
        });
    }

    @Test
    void fightAllNotRegistered() {
        Game repo = new Game();

        repo.register(1, linkor);
        repo.register(4, slot);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round(venom, error);
        });
    }


    @Test
    void fightFirstPlayerWins() {
        Game repo = new Game();

        repo.register(1,linkor);
        repo.register(2,error);

        int expected = 1;

        int actual = repo.round(linkor, error);

        assertEquals(expected, actual);
    }


    @Test
    void fightSecondPlayerWins() {
        Game repo = new Game();

        repo.register(1, linkor);
        repo.register(2, error);
        repo.register(3, venom);
        repo.register(4, slot);

        int expected = 2;

        int actual = repo.round(slot, venom);

        assertEquals(expected, actual);
    }

    @Test
    void fightDraw() {
        Game repo = new Game();

        repo.register(1, linkor);
        repo.register(2, error);
        repo.register(3, venom);
        repo.register(4, slot);

        int expected = 0;

        int actual = repo.round(error, venom);

        assertEquals(expected, actual);
    }


}
