package pl.dele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreatureTurnQueueTest {

    private Creature a;
    private Creature b;
    private Creature c;
    private Collection<Creature> creatureList;

    @BeforeEach
    void init(){
        a = new Creature();
        b = new Creature();
        c = new Creature();
        creatureList = new ArrayList<>();
        creatureList.add(a);
        creatureList.add(b);
        creatureList.add(c);
    }

    @Test
    void shouldChangeActiveCreature(){
        CreatureTurnQueue creatureTurnQueue = new CreatureTurnQueue(creatureList);

        assertEquals(a, creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();

        assertEquals(b, creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();

        assertEquals(c, creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();

        assertEquals(a, creatureTurnQueue.getActiveCreature());
    }

    @Test
    void shouldMergeTwoListMakeValidQueueAndChangeActiveCreature(){
        Creature d = new Creature();
        Creature e = new Creature();
        Collection<Creature> creatureList2 = new ArrayList<>();

        creatureList2.add(d);
        creatureList2.add(e);
        Collection<Creature> twoMergedList = new ArrayList<>();

        twoMergedList.addAll(creatureList);
        twoMergedList.addAll(creatureList2);

        CreatureTurnQueue creatureTurnQueue = new CreatureTurnQueue(twoMergedList);

        // test
        assertEquals(a, creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();
        assertEquals(b, creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();
        assertEquals(c, creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();
        assertEquals(d, creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();
        assertEquals(e, creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();
        assertEquals(a, creatureTurnQueue.getActiveCreature());
        creatureTurnQueue.next();

    }

}