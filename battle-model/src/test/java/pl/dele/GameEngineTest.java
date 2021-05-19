package pl.dele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameEngineTest {

    private final static int NOT_IMPORTANT = 5;
    private Creature attacker;
    private Creature attacker2;
    private Creature defender;
    private GameEngine gameEngine;

    @BeforeEach
    void init(){
        attacker = new Creature("attacker", 15, 5,
                100, NOT_IMPORTANT);

        attacker2 = new Creature("attacker2", 15, 5,
                100, NOT_IMPORTANT);

        defender = new Creature("defender", 10, 5,
                100, NOT_IMPORTANT);

        List<Creature> attackers = new ArrayList<>();
        List<Creature> defenders = new ArrayList<>();
        attackers.add(attacker);
        attackers.add(attacker2);
        defenders.add(defender);

        gameEngine = new GameEngine(attackers, defenders);
    }

    @Test
    void creatureShouldCounterAttackEveryTurn(){
        // set position
        gameEngine.move(new Point(3,3)); // attacker position
        gameEngine.move(new Point(4,4)); // attacker2 position
        gameEngine.move(new Point(5,5)); // defender position

        // first attacker1 attack
        gameEngine.attack(5,5);
        assertEquals(90, defender.getCurrentHp());
        assertEquals(95, attacker.getCurrentHp());

        // first attacker2 attack
        gameEngine.attack(5,5);
        assertEquals(80, defender.getCurrentHp());
        assertEquals(100, attacker2.getCurrentHp());

        // defender passes
        gameEngine.pass();

        // second attacker attack
        gameEngine.attack(5,5);
        assertEquals(70, defender.getCurrentHp());
        assertEquals(90, attacker.getCurrentHp());
    }
}
