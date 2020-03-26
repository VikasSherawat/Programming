package design.elevator;

import java.util.Scanner;

import design.elevator.implementation.LiftImpl;

public class LiftController {
    public void controller(){
        LiftImpl lift = new LiftImpl(0,10,5);
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        while(keepRunning) {
            System.out.println("1. Call Lift");
            System.out.println("2. Stop the lift");
            System.out.println("3. Reset the lift");
            System.out.println("4. Exit");
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    System.out.println("Enter floor number");
                    int floor = scanner.nextInt();
                    System.out.println("Enter the Direction");
                    String direction = scanner.next();
                    lift.call(floor,direction,false);
                    break;
                case 2:
                    lift.stop();
                    break;
                case 3:
                    lift.reset();
                case 4:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Enter a valid input please");
            }
        }
    }
}
