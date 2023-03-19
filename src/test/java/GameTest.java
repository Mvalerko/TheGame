import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    @Test
    void findAllSearchWithSort() {
        Game repo = new Game();

        repo.register(linkor);
        repo.register(error);


        List<Player> expected = new ArrayList<>();
        expected.add(linkor);
        expected.add(error);

        List<Player> actual = repo.getItems();

        Assertions.assertIterableEquals(actual, expected);
    }

    @Test
    void fightNotRegistered() {
        Game repo = new Game();

        repo.register(linkor);

        Assertions.assertThrows(NotRegisteredException.class, () -> {repo.round(linkor,error);
        });

    }

    @Test
    void fightAllRegistered() {
        Game repo = new Game();

        repo.register(linkor);
        repo.register(error);

        repo.round(linkor,error);
    }
}
