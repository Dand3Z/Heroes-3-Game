package pl.dele;

import java.util.*;

class CreatureTurnQueue {

    private final Collection<Creature> creatures;
    private final Queue<Creature> creaturesQueue;
    private Creature activeCreature;
    private Set<Creature> observers;

    CreatureTurnQueue(Collection<Creature> creatureList) {
        creatures = creatureList;
        creaturesQueue = new LinkedList<>();
        observers = new HashSet<>();
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
            notifyObserver();
        }
    }

    // == Observer Pattern ==
    void addObserver(Creature observer){
        observers.add(observer);
    }

    void removeObserver(Creature observer){
        observers.remove(observer);
    }

    void notifyObserver(){
        observers.forEach(o -> o.update());
    }
}
