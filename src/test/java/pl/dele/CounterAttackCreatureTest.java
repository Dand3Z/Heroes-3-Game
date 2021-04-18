package pl.dele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterAttackCreatureTest {

    private static final int NOT_IMPORTANT = 5;

    @Test
    void creatureShouldCounterAttack(){
        Creature attacker = new Creature("attacker", NOT_IMPORTANT,
                10,100,NOT_IMPORTANT);
        Creature defender = new Creature("defender", 20,
                NOT_IMPORTANT, 100,NOT_IMPORTANT);

        attacker.attack(defender);

        assertEquals(90, attacker.getCurrentHp());
    }

    @Test
    void creatureShouldCounterAttackOnlyOncePerTurn(){
        Creature attacker1 = new Creature("attacker", NOT_IMPORTANT,
                10,100,NOT_IMPORTANT);
        Creature attacker2 = new Creature("attacker2", NOT_IMPORTANT,
                10,100,NOT_IMPORTANT);
        Creature defender = new Creature("defender", 20,
                NOT_IMPORTANT, 100,NOT_IMPORTANT);

        attacker1.attack(defender);
        assertEquals(90, attacker1.getCurrentHp());

        attacker2.attack(defender);
        assertEquals(100, attacker2.getCurrentHp());
    }
}
