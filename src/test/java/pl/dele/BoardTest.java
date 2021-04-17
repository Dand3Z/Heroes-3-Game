package pl.dele;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private Creature creature;

    @BeforeEach
    void init(){
        // create board
        board = new Board();
        // create creature
        creature = new Creature();
    }

    @Test
    void shouldAddCreature(){

        // add create on point 0,0
        board.add(new Point(0,0), creature);

        // get creature from board
        Creature creatureFromBoard = board.get(0,0);

        // compare creatures
        assertEquals(creature, creatureFromBoard);
    }

    @Test
    void shouldReturnNullWhenFiledIsEmpty(){

        Creature creatureFromBoard = board.get(0,0);

        assertNull(creatureFromBoard);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenYouTryAddCreatureToNotEmptyField(){
        // add create to 0,0 field
        board.add(new Point(0,0), creature);

        // try to add another creature to 0,0 field. Should throw exception -> old point is still here
        Creature creature2 = new Creature();
        assertThrows(IllegalArgumentException.class, () -> board.add(new Point(0,0), creature2));

        // get creature from board
        Creature creatureFromBoard = board.get(0,0);

        // compare creatures
        assertEquals(creature, creatureFromBoard);
    }
}