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

        repo.register(linkor.getName(),linkor);
        repo.register(error.getName(),error);


        HashMap<String,Player> expected = repo.getItems();
        expected.put(linkor.getName(), linkor);
        expected.put(linkor.getName(), error);

        HashMap<String,Player> actual = repo.getItems();

        assertEquals(expected, actual);
    }


    @Test
    void fightNotRegisteredTwo() {
        Game repo = new Game();

        repo.register(linkor.getName(), linkor);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round(linkor.getName(), error.getName());
        });
    }

<<<<<<< HEAD
=======

>>>>>>> e085968f11b5ce6d94c33cb27cee957d3f58ee85
    @Test
    void fightNotRegisteredOne() {
        Game repo = new Game();

        repo.register(error.getName(), error);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round(linkor.getName(), error.getName());
        });
    }

    @Test
    void fightAllNotRegistered() {
        Game repo = new Game();

        repo.register(linkor.getName(), linkor);
        repo.register(slot.getName(), slot);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round(venom.getName(), error.getName());
        });
    }

    @Test
    void fightFirstPlayerWins() {
        Game repo = new Game();

        repo.register(linkor.getName(),linkor);
        repo.register(error.getName(),error);

        int expected = 1;

        int actual = repo.round(linkor.getName(), error.getName());

        assertEquals(expected, actual);
    }


    @Test
    void fightSecondPlayerWins() {
        Game repo = new Game();

        repo.register(linkor.getName(), linkor);
        repo.register(error.getName(), error);
        repo.register(venom.getName(), venom);
        repo.register(slot.getName(), slot);

        int expected = 2;

        int actual = repo.round(slot.getName(), venom.getName());

        assertEquals(expected, actual);
    }

    @Test
    void fightDraw() {
        Game repo = new Game();

        repo.register(linkor.getName(), linkor);
        repo.register(error.getName(), error);
        repo.register(venom.getName(), venom);
        repo.register(slot.getName(), slot);

        int expected = 0;

        int actual = repo.round(error.getName(), venom.getName());

        assertEquals(expected, actual);
    }

}
