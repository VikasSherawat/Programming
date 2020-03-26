package design.elevator.implementation;

import design.elevator.enums.Direction;
import design.elevator.interfaces.Lift;

public class LiftImpl implements Lift {
    private int currentFloor = 0;
    private int lowestFloor = 0;
    private int highestFloor = 0;
    private int capacity;
    private Direction direction;
    private boolean[] up;
    private boolean[] down;

    public LiftImpl(int lowestFloor, int highestFloor, int capacity) {
        this.lowestFloor = lowestFloor;
        this.highestFloor = highestFloor;
        this.capacity = capacity;
        this.direction = Direction.IDLE;
        this.currentFloor = lowestFloor;
        this.up = new boolean[highestFloor+1];
        this.down = new boolean[highestFloor+1];

        System.out.println("Initializing lift...");
        this.printState();
    }


    @Override
    public void call(int floor, String dir, boolean isCalledFromInside) {
        Direction direction = Direction.valueOf(dir);

        if(this.currentFloor==this.lowestFloor && Direction.DOWN == direction){
            System.out.println("Can't go down, you are at the lowest floor ");
            return;
        }

        if(this.currentFloor==this.highestFloor && Direction.UP == direction){
            System.out.println("Can't go up, you are at the highest floor ");
            return;
        }
        System.out.println("Button for Floor "+floor+" in Direction "+direction+" is pressed");
        if(Direction.UP == direction){
            up[floor]=true;
        }else{
            down[floor]=true;
        }
        while(true){
            int nextFloor = getNextFloor();
            if(nextFloor<0) {
                this.stop();
                break;
            }
            this.move(floor);
        }
    }

    private int getNextFloor() {
        switch (this.getDirection()){
            case UP:
                for(int i = this.currentFloor;i<this.highestFloor;i++){
                    if(up[i]) {
                        this.setDirection(Direction.UP);
                        up[i] = false;
                        return i;
                    }
                }
                break;
            case DOWN:
                for(int i = this.currentFloor;i>=this.lowestFloor;i--){
                    if(down[i]) {
                        this.setDirection(Direction.DOWN);
                        down[i]=false;
                        return i;
                    }
                }
                break;
            default:
                // if lift is stationary, get to the floor, who requested first
                // for this case, we will look at people who wants to go down and then up
                for(int i = this.highestFloor;i>=this.lowestFloor;i--){
                    if(down[i]) {
                        this.setDirection(Direction.DOWN);
                        down[i]=false;
                        return i;
                    }
                }

                for(int i = this.lowestFloor;i<=this.highestFloor;i++){
                    if(up[i]) {
                        this.setDirection(Direction.UP);
                        up[i] = false;
                        return i;
                    }
                }
        }
        return -1;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean isStationary() {
        return this.direction == Direction.IDLE;
    }

    @Override
    public int getCurrentFloor() {
        return this.currentFloor;
    }

    @Override
    public void stop() {
        this.setDirection(Direction.IDLE);
        System.out.println("Stopping at Floor "+this.currentFloor);
    }

    @Override
    public void reset() {
        this.move(this.lowestFloor);
        this.stop();
    }

    @Override
    public void move(int floor) {
        System.out.println("Lift going to Floor " + floor);
        try {
            Thread.sleep(1000);
            System.out.println("Door Opening....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.currentFloor = floor;
    }

    public void printState() {
        System.out.println("The lift is at floor " + this.currentFloor + " and the direction is " + this.getDirection());
    }
}
