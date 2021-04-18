package pl.dele;

public class CreatureStatistics {

    final private String name;
    final private int attack;
    final private int armor;
    final private int maxHp;
    final private int moveRange;

    CreatureStatistics(String name, int attack, int armor, int maxHp, int moveRange) {
        this.name = name;
        this.attack = attack;
        this.armor = armor;
        this.maxHp = maxHp;
        this.moveRange = moveRange;
    }

    String getName() {
        return name;
    }

    int getAttack() {
        return attack;
    }

    int getArmor() {
        return armor;
    }

    int getMaxHp() {
        return maxHp;
    }

    int getMoveRange() {
        return moveRange;
    }
}
