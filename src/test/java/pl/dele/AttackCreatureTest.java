package pl.dele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AttackCreatureTest {

    public static final int NOT_IMPORTANT = 5;

    @Test
    void creatureShouldLost10HPWhenAttackerHas20AttackAndDefenderHas10Armor(){
        Creature attacker = new Creature("attacker", 20,
                NOT_IMPORTANT,100,NOT_IMPORTANT);
        Creature defender = new Creature("defender", NOT_IMPORTANT,
                                10, 100,NOT_IMPORTANT);

        attacker.attack(defender);

        assertEquals(90, defender.getCurrentHp());
    }

    @Test
    void creatureShouldNotSelfHealWhenAttackerHasLowerAttackThanDefenderArmor(){
        Creature attacker = new Creature("attacker", 10,
                NOT_IMPORTANT,100,NOT_IMPORTANT);
        Creature defender = new Creature("defender", NOT_IMPORTANT,
                20, 100,NOT_IMPORTANT);

        attacker.attack(defender);

        assertEquals(100, defender.getCurrentHp());
    }

    @Test
    void shouldThrowInvalidParameterExceptionWhenDefenderIsNull(){
        Creature attacker = new Creature("attacker", 10,
                NOT_IMPORTANT,100,NOT_IMPORTANT);
        Creature defender = null;

        assertThrows(IllegalArgumentException.class , () -> attacker.attack(defender));
    }
}