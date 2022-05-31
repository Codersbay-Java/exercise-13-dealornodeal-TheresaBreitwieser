package application;

import java.util.*;

import static application.Main.scanner;

public class Game {
    private int roundCount;
    Briefcase myBriefcase;

    int[] numberOfCases = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
    double[] values={0.01, 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000,
            75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};

    public Game() {
        this.roundCount = 1;
        newGame();
    }

    public void newGame() {
        System.out.println("$$$$---Deal or no Deal?---$$$$");
        myBriefcase = new Briefcase();
        if(isGameModusDebug()){
            myBriefcase.setBriefcases(numberOfCases, values);
        } else {
            Random rand = new Random();
            for (int i = 0; i < values.length; i++) {
                int randomIndexToSwap = rand.nextInt(values.length);
                double temp = values[randomIndexToSwap];
                values[randomIndexToSwap] = values[i];
                values[i] = temp;
            }
            myBriefcase.setBriefcases(numberOfCases, values);
        }


    }


    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount() {
        this.roundCount++;
    }

    public boolean isGameModusDebug() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play in debug mode press d");
        if(scanner.nextLine().equalsIgnoreCase("d"))
        return true;
        else return false;
    }

    public double getBankOffer(){
        Bank bank = new Bank();
        return bank.calculateBankOffer(myBriefcase, roundCount);
    }

    public boolean deal() {
        System.out.println("The Bank offers you :"+ getBankOffer() + " ." + "If you want to accept the offer type yes.");
        String response = scanner.nextLine();
        if(response.equalsIgnoreCase("yes")){
            System.out.println("Congratulations, you have won: " + getBankOffer());
            return true;
        }else return false;
    }

}
