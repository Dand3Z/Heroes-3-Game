package pl.dele;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

class CreatureTurnQueue {

    private final Collection<Creature> creatures;
    private final Queue<Creature> creaturesQueue;
    private Creature activeCreature;

    CreatureTurnQueue(Collection<Creature> creatureList) {
        creatures = creatureList;
        creaturesQueue = new LinkedList<>();
        initQueue();
    }

    private void initQueue() {
        creaturesQueue.addAll(creatures);
        // set first activeCreature
        next();
    }

    Creature getActiveCreature() {
        return activeCreature;
    }

    void next() {
        activeCreature = creaturesQueue.poll();
        if (activeCreature == null){
            initQueue();
        }
    }
}
