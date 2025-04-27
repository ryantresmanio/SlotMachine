import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        //DECLARE VARIABLES
        int balance = 50;
        int bet;
        int payout;
        String[] row;

        //GREET
        System.out.println("\n---------------------------");
        System.out.println("Welcome to My Slut Machine!");
        System.out.println("Symbols: 🍌 🥒 🍆 💦 🌭 🍑");
        System.out.println("---------------------------");

        //PLAY IF BALANCE  . 0
        while (balance > 0) {
            System.out.println("\nCurrent Balance: $" + balance);
            //ENTER AMOUNT BET
            System.out.print("Enter bet: ");
            bet = scan.nextInt();
            scan.nextLine();

            //VERIFY IF BALANCE > BET

            //    VERIFY IF BET > 0
            //    SUBTRACT BET FROM THE BALANCE

            if (bet > balance) {
                System.out.println("Insufficient Balance!");
                continue;
            } else if (bet <= 0) {
                System.out.println("Invalid");
                continue;
            } else {
                balance -= bet;
                //System.out.println("Current Balance: " + balance);
            }

            System.out.println("Spinning... ");
            row = spinRow();
            printRow(row);

            if (row[0].equals(row[1]) && (row[1].equals(row[2]))){
                System.out.println("🎊🎊 YOU WIN $" + bet*3);
                balance = balance + (bet*3);
            }
            //System.out.println(Arrays.toString(row));
            //row = spinRow();

            System.out.print("Do you want to play again? (Y/N) ");
            String playAgain = scan.nextLine().toUpperCase();

            if (playAgain.equals("Y")){
                continue;
            }
            else if (playAgain.equals("N")){
                break;
            }
            else {
                System.out.println("Invalid");
                break;
            }
        }

        if (balance == 0) {
            System.out.println("O balance left");
        }

        System.out.println("Thank You for playing my silly game");
        System.out.println("Your Balance; " + balance);
        scan.close();
    }

    static String[] spinRow() {
        String[] symbols = {"🍌", "🥒", "🍆", "💦", "🌭", "🍑"};
        String[] row = new String[3];
        Random random = new Random();


        for (int i = 0; i < 3; i++) {
            //assign to row
            row[i] = symbols[random.nextInt(symbols.length)];
        }

        //System.out.println(row[0] + row[1] + row[2]);
        return row;
    }

    static void printRow(String[] row) {
        System.out.println("\n " + String.join(" | ", row));


    }

}
