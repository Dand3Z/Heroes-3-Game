package pl.dele;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class CreatureTurnQueue {


    private final Collection<Creature> creatures;
    private final Queue<Creature> creaturesQueue;
    private Creature activeCreature;

    public CreatureTurnQueue(Collection<Creature> creatureList) {
        creatures = creatureList;
        creaturesQueue = new LinkedList<>();
        creaturesQueue.addAll(creatures);
        // set first activeCreature
        next();
    }

    Creature getActiveCreature() {
        return activeCreature;
    }

    void next() {
        activeCreature = creaturesQueue.poll();
    }
}
