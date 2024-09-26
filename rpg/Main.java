package rpg;

import rpg.entities.enemy.Enemy;
import rpg.entities.Game;
import rpg.entities.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Héroe");
        Enemy enemy = new Enemy("Monstruo");

        Game game = new Game(player, enemy);
        game.startGame();
    }
}
