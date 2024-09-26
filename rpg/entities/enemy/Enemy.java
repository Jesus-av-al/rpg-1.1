package rpg.entities.enemy;

import rpg.entities.Player;
import rpg.enums.Stats;

import java.util.HashMap;

public class Enemy {
    private String name;
    private HashMap<Stats, Integer> stats;

    // Constructor
    public Enemy(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        // Inicializamos las estadísticas del enemigo
        this.stats.put(Stats.MAX_HP, 50);
        this.stats.put(Stats.HP, 50);
        this.stats.put(Stats.ATTACK, 5);
        this.stats.put(Stats.DEFENSE, 2);
    }

    // Método para obtener el nombre del enemigo
    public String getName() {
        return name;
    }

    // Método para obtener las estadísticas del enemigo
    public HashMap<Stats, Integer> getStats() {
        return stats;
    }

    // Método para verificar si el enemigo está vivo
    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }

    // Método para que el enemigo ataque al jugador
    public void attack(Player player) {
        int damage = this.stats.get(Stats.ATTACK) - player.getStats().get(Stats.DEFENSE);
        if (damage > 0) {
            player.getStats().put(Stats.HP, player.getStats().get(Stats.HP) - damage);
            System.out.println(this.name + " ataca a " + player.getName() + " por " + damage + " puntos de daño!");
        } else {
            System.out.println(this.name + " ataca a " + player.getName() + " pero no hace daño!");
        }
    }
}