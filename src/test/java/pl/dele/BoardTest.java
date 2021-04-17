package pl.dele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Test
    void shouldAddCreature(){
        // create board
        Board board = new Board();
        // create creature
        Creature creature = new Creature();
        // add create on point 0,0
        board.add(new Point(0,0), creature);

        // get creature from board
        Creature creatureFromBoard = board.get(new Point(0,,0));

        // compare creatures
        assertEquals(creature, creatureFromBoard);
    }
}