/*
EXTRA CREDIT INCLUDED
<eli james cis 200 8/24/2023 B @ 9:22 pm >
<project 1>
THE ASSIGNMENT: using 4 constants(all uppercase) and wrote a program to calculate how much everything would be added together compared to the saved amount(using%.2f for two decimal places) to see
if a trip could be afforded with the amount of things the individual would want calculated and subtracted from the saved amount
taking user input and setting it as variables and calling them later in the program for calculation as well
*/
import java.util.*;
import java.text.DecimalFormat;
public class Proj1 {
    public static void main(String[] args) {
        //creating constants(ALL CAPS)
        final double TICKETCOST = 948.00; // creating constant for ticket price
        final double CONCERTSHIRT = 49.00; // creating constant for tshirt price
        final double TICKETFEE = 29.99; //creating constant for ticket fee
        final double TAXRATE = 0.092; //creating constant for tax rate on every item sold

        //constant block
        System.out.printf("     Adult ticket cost: $%.2f\n", TICKETCOST); //printing and then calling the TICKETCOST constant
        System.out.printf("     Concert shirt cost: $%.2f\n", CONCERTSHIRT); //printing and then calling the CONCERTSHIRT constant
        System.out.printf("     Ticket fee: $%.2f\n", TICKETFEE); //printing and then calling the TICKETFEE constant
        System.out.printf("     Sales tax rate: %.2f%%\n", TAXRATE * 100); //printing and then calling the TAXRATE constant (getting it to print as a percentage with %.2f%%\n" also the * 100

        //user input and conversions(body)
        Scanner sl = new Scanner(System.in); //creating scanner for user input
        System.out.println();//spacer
        System.out.print("How many tickets are you purchasing? "); //printing question for user

        int purchasedTickets = Integer.parseInt(sl.nextLine()); //creating variable for purchased tickets and converting it into an int
        Scanner ss = new Scanner(System.in); //creating scanner for user input
        System.out.print("How many T-Shirts are you planning to purchase? "); //printing question for user
        int purchasedTshirts = Integer.parseInt(ss.nextLine()); //converting purchasedTshirts into an int

        Scanner s = new Scanner(System.in); //creating scanner for user input
        System.out.print("Enter in how much money (total) you have saved: $"); //printing question for user
        double savedMoney = Double.parseDouble(s.nextLine()); //converting savedMoney into a double
        System.out.println();//spacer
        double preTaxCost = (TICKETCOST * purchasedTickets) + (TICKETFEE * purchasedTickets) + (CONCERTSHIRT * purchasedTshirts); //creating variable preTaxCost and the calculations that would give the price of the items selected by the person before TAXRATE is applied

        DecimalFormat sa = new DecimalFormat("#,###.##"); // using decimal format to get the overall cost printed in a specific format
        System.out.println("Total cost before tax:$" + sa.format(preTaxCost)); //printing and calling the preTaxCost

        double totalTax = TAXRATE * (TICKETCOST * purchasedTickets) + TAXRATE * (TICKETFEE * purchasedTickets) + TAXRATE * (CONCERTSHIRT * purchasedTshirts); //creating variable totalTax and the calculations that gives you the total tax after everything is multiplied and added

        DecimalFormat tx = new DecimalFormat("#,###.##"); // using decimal format to get the overall cost printed in a specific format
        System.out.println("Total tax:$" + tx.format(totalTax)); //printing and then calling the totalTax variable

        double overallCost = totalTax + preTaxCost; // creating variable overallCost and the calculations that make the variable

        DecimalFormat df = new DecimalFormat("#,###.##"); // using decimal format to get the overall cost printed in a specific format
        System.out.println("Overall cost after tax:$" + df.format(overallCost)); //printing and then calling the overallCost variable
        System.out.println(); //spacer

        double amountLeftOver = savedMoney - overallCost; // creating variable amountLeftOver and the calculations that make the variable

        //if statement(s) for next series
        if (savedMoney >= overallCost) {
            DecimalFormat sd = new DecimalFormat("#,###.##"); // using decimal format to get the overall cost printed in a specific format
            System.out.println("Amount left after all costs:$" + sd.format(amountLeftOver)); //printing and calling amountLeftOver variable
            System.out.println("You have enough money! Have fun!"); //printing statement for the user
        }

        if (savedMoney < overallCost) {
            DecimalFormat sm = new DecimalFormat("#,###.##"); // using decimal format to get the overall cost printed in a specific format
            System.out.println("Amount left after all costs:$" + sm.format(amountLeftOver)); //printing and calling amountLeftOver variable
            System.out.println("You do not have enough money saved to afford all of that...sorry"); //printing statement for the user
            System.out.println(); //spacer
            Scanner sd = new Scanner(System.in); //creating scanner for user input
            System.out.print("Do you plan on getting the rest of the money from one of your parents?(yes or no):"); //printing question for user
            String parentsMoney = sd.nextLine(); // next line string
            if (parentsMoney.equals("yes")) {
                System.out.print("How much money are they going to give you?:$ "); //printing question for user
                double givenMoney = Double.parseDouble(s.nextLine()); // converting givenMoney into a double and next line
                System.out.println(); //spacer
                System.out.printf("Saved money: $%.2f\n", savedMoney); //printing and calling savedMoney variable
                DecimalFormat dp = new DecimalFormat("#,###.##"); // using decimal format to get the overall cost printed in a specific format
                System.out.println("Money parents gave you: $" + dp.format(givenMoney)); //printing and calling givenMoney variable
                double newTotal = savedMoney + givenMoney; // creating a variable named newTotal and the calculations that make the variable
                DecimalFormat ds = new DecimalFormat("#,###.##"); // using decimal format to get the overall cost printed in a specific format
                System.out.println("New total: $" + ds.format(newTotal)); //printing and calling newTotal variable
                DecimalFormat dd = new DecimalFormat("#,###.##"); // using decimal format to get the overall cost printed in a specific format
                double newCalculation = newTotal - overallCost; //creating a new variable newCalculation and the calculations that make it (declaring as a double as well)
                System.out.println("Amount Left over after calculations: $" + dd.format(newCalculation)); //printing and calling the newCalculation variable

                double threshold = .01; // threshold to account for floating point arithmetic used below in if statement

                if (newTotal >= overallCost || Math.abs(newCalculation) < threshold) {
                    System.out.println(); //spacer
                    System.out.println("You can afford to go now! Have fun!"); //printing statement for the user
                    }
                    else{
                    System.out.println("Sorry you still don't have enough to go...sorry"); //printing statement for the user
                }
            }
            if(parentsMoney.equals("no")){
                System.out.println(); // spacer
                System.out.println("Well then im sorry then you cant afford everything you want today..."); //printing statement for the user
            }
        }
    }
} //end of program