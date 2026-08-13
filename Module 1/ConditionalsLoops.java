// Implement a program to demonstrate the use of if-else, switch, and for loops.

import java.util.Scanner;
public class ConditionalsLoops {
    public static void main(String[] args) {
        // if-else example
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int x = sc.nextInt();
        if (x > 0) {
            System.out.println(x + " is positive");
        } else {
            System.out.println(x + " is not positive");
        }

        // switch example
        System.out.print("Enter a day number (1-7): ");
        int day = sc.nextInt();
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // for loop example
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i);
        }
    }
}