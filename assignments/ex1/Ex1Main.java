package assignments.ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();


//                System.out.println("Num 1 is: " + num1 + " is number: true ");
//                if (!num1.equals("quit")) {
//
//                    System.out.println(Ex1.number2Int(num1));
//                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
//                    num2 = sc.next();
                    if (num2.equals(quit)) break;

                    System.out.println();


                    // Display the decimal conversion results

                    System.out.println(" Num #2 is: " + num2 + " is number: true ");


                    // add your code here

                    /////////////////////
                }
        System.out.println(" quitting now...");
        }

    }


