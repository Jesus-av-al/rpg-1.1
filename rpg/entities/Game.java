package rpg.entities;

import rpg.entities.enemy.Enemy;

public class Game {
    private Player player;
    private Enemy enemy;

    public Game(Player player, Enemy enemy) {
        this.player = new Player("Héroe");
        this.enemy = new Enemy("Goblin");
    }

    public void startGame() {
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }

        if (player.isAlive()) {
            System.out.println("¡Has derrotado al enemigo!");
        } else {
            System.out.println("Game over. Fuiste derrotado por el enemigo.");
        }
    }
}