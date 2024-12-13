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

            if (num2.equals(quit)) break;

            boolean isNum1Valid = Ex1.isNumber(num1);
            if (!isNum1Valid){
                break;
            }
            int num1NumberValue = Ex1.number2Int(num1);
            System.out.println("number#1 = " + num1 + "is number: " + isNum1Valid + ", value: " + num1NumberValue);

            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();

            if (num2.equals(quit)) break;

            boolean isNum2Valid = Ex1.isNumber(num2);
            if (!isNum1Valid){
                break;
            }
            int num2Value = Ex1.number2Int(num2);
            System.out.println("num2 = " + num2 + " is number: " + isNum2Valid + ", value: " + num2Value);

            if (!isNum1Valid || !isNum2Valid) {
                System.out.println("Invalid input detected. Please enter valid numbers.");
            }
            System.out.println("Enter a base for output (a number [2,16]): ");
            int outputBase = sc.nextInt();

            if (outputBase < 2 || outputBase > 16) {
                System.out.println("Invalid base. Please enter a base between 2 and 16.");
            }
            String sum = Ex1.int2Number(num1NumberValue + num2Value, outputBase);
            String productResult = Ex1.multiplyAndConvert(num1, num2, outputBase);
            System.out.println(num1 + " + " + num2 + " = " + sum + "b" + outputBase);
            System.out.println(num1 + " * " + num2 + " = " + productResult + "b" + outputBase);

            String[] numbers = {num1, num2, sum + "b" + outputBase, productResult
///
                    + "b" + outputBase};
            int maxIndex = Ex1.maxIndex(numbers);

            System.out.println("Max number over " + java.util.Arrays.toString(numbers) + " is: " + numbers[maxIndex]);


                }
        System.out.println(" quitting now...");
        }

    }


