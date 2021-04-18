package pl.dele;

import java.security.InvalidParameterException;

public class Creature {

    // base statistics of creature
    private final CreatureStatistics stats;
    private int currentHp;

    Creature(){
        this("DefName", 0, 0, 10, 100);
    }

    Creature(String name, int attack, int armor, int maxHp, int moveRange) {
        stats = new CreatureStatistics(name, attack, armor, maxHp, moveRange);
        currentHp = stats.getMaxHp();
    }

    int getCurrentHp() {
        return currentHp;
    }

    void attack(Creature defender) {
        if (isAlive()){
            if (defender == null) throw new InvalidParameterException();
            var attackValue = this.stats.getAttack() - defender.stats.getArmor();

            if (attackValue > 0) defender.currentHp -= attackValue;
        }
    }

    private boolean isAlive(){
        return currentHp > 0;
    }
}
