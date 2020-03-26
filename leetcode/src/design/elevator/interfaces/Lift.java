package design.elevator.interfaces;

import design.elevator.enums.Direction;

public interface Lift {
    public void call(int floor, String direction, boolean isInside);

    public Direction getDirection();

    public void setDirection(Direction direction);

    public boolean isStationary();

    public int getCurrentFloor();

    public void stop();

    public void reset();

    public void move(int floor);
}
