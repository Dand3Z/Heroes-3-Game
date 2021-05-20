package pl.dele;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EndOfTurnTest {

    @Test
    void shouldResetCounterAttackFlagAfterEndOfTurn(){
        Creature attacker = new Creature();
        Creature defender = new Creature();
        GameEngine engine = new GameEngine(List.of(attacker), List.of(defender));

        assertTrue(defender.canCounterAttack());
        attacker.attack(defender);
        assertFalse(defender.canCounterAttack());

        engine.pass();
        engine.pass();
        assertTrue(defender.canCounterAttack());
    }
}
