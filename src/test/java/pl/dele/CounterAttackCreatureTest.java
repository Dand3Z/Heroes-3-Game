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
}
