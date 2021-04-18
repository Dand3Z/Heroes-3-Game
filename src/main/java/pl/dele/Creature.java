package pl.dele;

public class Creature {

    // base statistics of creature
    private final CreatureStatistics stats;
    private int currentHp;

    Creature(){
        stats = new CreatureStatistics("DefName", 0,
                0, 10, 100);
    }

    Creature(String name, int attack, int armor, int maxHp, int moveRange) {
        stats = new CreatureStatistics(name, attack, armor, maxHp, moveRange);
    }

    int getCurrentHp() {
        return currentHp;
    }
}
