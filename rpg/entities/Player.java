package rpg.entities;

import rpg.entities.enemy.Enemy;
import rpg.enums.Stats;

import java.util.HashMap;

public class Player{
    private String name;
    private HashMap<Stats, Integer> stats;

    // Constructor
    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        // Inicializamos las estadísticas del jugador
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.MAX_MP, 50);
        this.stats.put(Stats.MP, 50);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
    }

    // Método para obtener el nombre del jugador
    public String getName() {
        return name;
    }

    // Método para obtener las estadísticas del jugador
    public HashMap<Stats, Integer> getStats() {
        return stats;
    }

    // Método para verificar si el jugador está vivo
    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }

    // Método para que el jugador ataque a un enemigo
    public void attack(Enemy enemy) {
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        if (damage > 0) {
            enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
            System.out.println(this.name + " ataca a " + enemy.getName() + " por " + damage + " puntos de daño!");
        } else {
            System.out.println(this.name + " ataca a " + enemy.getName() + " pero no hace daño!");
        }
    }
}