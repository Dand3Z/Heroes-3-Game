package pl.dele;

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

    @Test
    void shouldReturnCorrectLocationOfCreature(){
        board.add(new Point(6,6), creature);
        Point result = board.get(creature);

        assertEquals(new Point(6,6), result);
    }

    // == Moving ==
    @Test
    void shouldCreatureMoveToAnotherPoint(){
        board.add(new Point(0,0), creature);
        board.move(new Point(2,2), new Point(0,0));

        // create move to new point
        Creature creatureFromBoard = board.get(2,2);
        assertEquals(creature, creatureFromBoard);
        // create is no longer in source point
        creatureFromBoard = board.get(0,0);
        assertNull(creatureFromBoard);
    }

    @Test
    void shouldThrowNullPointerExceptionWhenSrcPointIsNull(){
        assertThrows(NullPointerException.class,
                () -> board.move(new Point(2,2), new Point(0,0)));

    }

    @Test
    void shouldThrowIllegalExceptionWhenDstPointIsNotNull(){
        board.add(new Point(0,0), creature);
        Creature c2 = new Creature();
        board.add(new Point(2,2), c2);
        assertThrows(IllegalArgumentException.class,
                () -> board.move(new Point(2,2), new Point(0,0)));

        assertEquals(board.get(0,0), creature);
        assertEquals(board.get(2,2), c2);

    }
}