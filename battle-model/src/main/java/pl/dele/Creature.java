package pl.dele;

import java.security.InvalidParameterException;

public class Creature {

    // base statistics of creature
    private final CreatureStatistics stats;
    private int currentHp;
    // one counter attack per turn
    private boolean counterAttackInThisTurn;

    public Creature(){
        this("DefName", 0, 0, 10, 100);
    }

    Creature(String name, int attack, int armor, int maxHp, int moveRange) {
        stats = new CreatureStatistics(name, attack, armor, maxHp, moveRange);
        currentHp = stats.getMaxHp();
    }

    int getCurrentHp() { return currentHp; }

    void attack(Creature defender) {
        if (isAlive()){
            int damageToDeal = calculateDamage(defender);
            dealDamage(defender, damageToDeal);

            // one counter attack per turn - check it here
            // add defender.isAlive() check later
            if (!defender.counterAttackInThisTurn && defender.isAlive()){
                int damageToDealInCounterAttack = defender.calculateDamage(this);
                dealDamage(this, damageToDealInCounterAttack);
                defender.counterAttackInThisTurn = true;
            }
        }
    }

    void resetCounterAttack() {counterAttackInThisTurn = false; }

    private void dealDamage(Creature defender, int damageToDeal) {
        defender.currentHp -= damageToDeal;
    }

    private int calculateDamage(Creature defender) {
        if (defender == null) throw new InvalidParameterException();
        var damageToDeal = this.stats.getAttack() - defender.stats.getArmor();
        if (damageToDeal < 0) damageToDeal = 0;
        return damageToDeal;
    }

    private boolean isAlive(){
        return currentHp > 0;
    }

    public String getName() { return stats.getName(); }
}
