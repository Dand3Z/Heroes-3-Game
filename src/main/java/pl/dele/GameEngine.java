package pl.dele;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private final Board board;
    private final CreatureTurnQueue queue;

    // init game
    public GameEngine(List<Creature> creatures1, List<Creature> creatures2){
        board = new Board();
        putCreatureToBoard(creatures1, creatures2);
        // create new list with creatures1 and creatures2
        List<Creature> twoSidesCreatures = new ArrayList<>();
        twoSidesCreatures.addAll(creatures1);
        twoSidesCreatures.addAll(creatures2);
        queue = new CreatureTurnQueue(twoSidesCreatures);
    }

    // engine knows active creature
    public void move(Point targetPoint){
        board.move(targetPoint, queue.getActiveCreature());
    }

    public void pass(){
        queue.next();
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
}
