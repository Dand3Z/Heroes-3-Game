package pl.dele;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    public static final String CURRENT_CREATURE_CHANGED = "CURRENT_CREATURE_CHANGED";
    public static final String CREATURE_MOVED = "CREATURE_MOVED";

    private final Board board;
    private final CreatureTurnQueue queue;
    private final PropertyChangeSupport observerSupport;

    // init game
    public GameEngine(List<Creature> creatures1, List<Creature> creatures2){
        board = new Board();
        putCreatureToBoard(creatures1, creatures2);
        // create new list with creatures1 and creatures2
        List<Creature> twoSidesCreatures = new ArrayList<>();
        twoSidesCreatures.addAll(creatures1);
        twoSidesCreatures.addAll(creatures2);
        queue = new CreatureTurnQueue(twoSidesCreatures);

        // game engine adds observers
        twoSidesCreatures.forEach(c -> queue.addObserver(c));
        observerSupport = new PropertyChangeSupport(this);
    }

    // == Observer Pattern ==
    public void addObserver(String eventType ,PropertyChangeListener obs){
        observerSupport.addPropertyChangeListener(eventType ,obs);
    }

    public void removeObserver(PropertyChangeListener obs){
        observerSupport.removePropertyChangeListener(obs);
    }

    public void notifyObservers(PropertyChangeEvent event){
        observerSupport.firePropertyChange(event);
    }

    // engine knows active creature
    public void move(Point targetPoint){
        Point sourcePoint = board.get(getActiveCreature());
        board.move(targetPoint, queue.getActiveCreature());
        notifyObservers(new PropertyChangeEvent(this, CREATURE_MOVED, sourcePoint, targetPoint));//////
    }

    public void pass(){
        Creature oldActiveCreature = queue.getActiveCreature();
        queue.next();
        Creature newActiveCreature = queue.getActiveCreature();
        notifyObservers(new PropertyChangeEvent(this, CURRENT_CREATURE_CHANGED, oldActiveCreature, newActiveCreature));
    }

    /**
     * Client clicks field on board. Every field has x and y params
     * @param x
     * @param y
     */
    // error when we click empty field
    public void attack(int x, int y){
        queue.getActiveCreature().attack(board.get(x,y));
    }

    private void putCreatureToBoard(List<Creature> creatures1, List<Creature> creatures2) {
        putCreaturesFromOneSideOfBoard(creatures1,0);
        putCreaturesFromOneSideOfBoard(creatures2,board.WIDTH-1);
    }

    private void putCreaturesFromOneSideOfBoard(List<Creature> creatures1, int x) {
        for (int i = 0; i < creatures1.size(); ++i){
            board.add(new Point(x,i * 2), creatures1.get(i));
        }
    }

    public Creature get(int x, int y) {
        return board.get(x,y);
    }

    public Creature getActiveCreature() {
        return queue.getActiveCreature();
    }

    public boolean canMove(int x, int y) {
        return board.canMove(getActiveCreature(), x, y);
    }
}
