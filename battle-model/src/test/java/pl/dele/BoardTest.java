package pl.dele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private Creature creature;

    @BeforeEach
    void init(){
        board = new Board();
        creature = new Creature();
    }

    @Test
    void shouldAddCreature(){

        board.add(new Point(0,0), creature);

        Creature creatureFromBoard = board.get(0,0);

        assertEquals(creature, creatureFromBoard);
    }

    @Test
    void shouldReturnNullWhenFiledIsEmpty(){

        Creature creatureFromBoard = board.get(0,0);

        assertNull(creatureFromBoard);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenYouTryAddCreatureToNotEmptyField(){
        board.add(new Point(0,0), creature);

        // try to add another creature to 0,0 field. Should throw exception -> old point is still here
        Creature creature2 = new Creature();
        assertThrows(IllegalArgumentException.class, () -> board.add(new Point(0,0), creature2));

        Creature creatureFromBoard = board.get(0,0);

        assertEquals(creature, creatureFromBoard);
    }

    @Test
    void shouldReturnCorrectLocationOfCreature(){
        board.add(new Point(6,6), creature);
        Point result = board.get(creature);

        assertEquals(new Point(6,6), result);
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenCreatureIsNotValueOfMap(){
        assertThrows(NoSuchElementException.class, () -> board.get(new Creature
                ("name",1,2,3,4)));
    }
}