package pl.dele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardMovingTest {

    private Board board;
    private Creature creature;

    @BeforeEach
    void init(){
        board = new Board();
        creature = new Creature();
        board.add(new Point(0,0), creature);
    }

    @Test
    void shouldCreatureMoveToAnotherPoint(){
        board.move(new Point(2,2), new Point(0,0));
        // create move to new point
        Creature creatureFromBoard = board.get(2,2);
        assertEquals(creature, creatureFromBoard);
        // creature is no longer in source point
        creatureFromBoard = board.get(0,0);
        assertNull(creatureFromBoard);
    }

    @Test
    void shouldThrowNullPointerExceptionWhenSrcPointIsNull(){
        assertThrows(NullPointerException.class,
                () -> board.move(new Point(2,2), new Point(1,0)));
    }

    @Test
    void shouldThrowIllegalExceptionWhenCreatureIsTryingToMoveToTakeField(){
        Creature c2 = new Creature();
        board.add(new Point(2,2), c2);
        assertThrows(IllegalArgumentException.class,
                () -> board.move(new Point(2,2), new Point(0,0)));

        assertEquals(board.get(0,0), creature);
        assertEquals(board.get(2,2), c2);
    }

    @Test
    void canMoveWhenCreatureHasEnoughMovePoint(){

        creature = new Creature("x",1,1,10,1);
        board.add(new Point(5,5), creature);
        assertTrue(board.canMove(creature, 6,5));
        assertTrue(board.canMove(creature, 5,6));
        assertTrue(board.canMove(creature, 4,5));
        assertTrue(board.canMove(creature, 5,4));
    }

    @Test
    void canMoveWhenCreatureHasNotEnoughMovePoint(){

        creature = new Creature("x",1,1,10,1);
        board.add(new Point(5,5), creature);
        assertFalse(board.canMove(creature, 6,6));
        assertFalse(board.canMove(creature, 4,4));
        assertFalse(board.canMove(creature, 4,6));
        assertFalse(board.canMove(creature, 6,4));
    }

    @Test
    void cannotMoveWhenCreatureHasNotEnoughMovePoint(){
        creature = new Creature("x",1,1,10,1);
        board.add(new Point(5,5),creature);

        assertFalse(board.canMove(creature, 6,6));
    }

    @Test
    void cannotMoveWhenFieldIsTaken(){
        Creature creature = new Creature("x",1,1,10,10);
        board.add(new Point(5,5),creature);

        assertFalse(board.canMove(creature, 0,0));
    }
}
