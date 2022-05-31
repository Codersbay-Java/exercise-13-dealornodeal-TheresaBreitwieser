package application;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Briefcase {
  private Map<Integer, Double> briefcases;
 double[] chosenBriefcase = new double[2];


    public Briefcase() {
        briefcases = new TreeMap<>();
    }

    public Map<Integer, Double> getBriefcases() {
        return briefcases;
    }

    public void setBriefcases(int[] numberOfCases, double[] values) {
        for (int i = 0; i < numberOfCases.length; i++) {
            briefcases.put(numberOfCases[i], values[i]);
        }
    }


    public void chooseFirstBriefcase() {
        System.out.println(briefcases.keySet());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose first briefcase to select your price money");
        int briefcaseSelected = scanner.nextInt();
        while(!briefcases.containsKey(briefcaseSelected)){
            System.out.println("Briefcasenumber not available, please try again");
            briefcaseSelected = scanner.nextInt();
        }
        System.out.println("You have chosen:" + " " + briefcaseSelected);
        chosenBriefcase[0] = briefcaseSelected;
        chosenBriefcase[1] = briefcases.get(briefcaseSelected);
        briefcases.remove(briefcaseSelected);

    }

    public void chooseBriefcase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a briefcase");
        try {
            int briefcaseSelected = scanner.nextInt();
            while(!briefcases.containsKey(briefcaseSelected)){
                System.out.println("Briefcasenumber not available, please try again");
                briefcaseSelected = scanner.nextInt();

            }
            System.out.println("You have chosen" +" " + briefcaseSelected);
            removeBriefcase(briefcaseSelected);
        }
        catch(Exception e){
            System.out.println("Not a valid input. Please try again");
        }

    }


    public void removeBriefcase(int briefCaseNumber) {
        System.out.println("Case: " + briefCaseNumber + " was eliminated");
        System.out.println("Briefcase contains: " + briefcases.get(briefCaseNumber) + "$");
        briefcases.remove(briefCaseNumber);
    }

    public double getSumBriefcases() {
        double sum=briefcases.values().stream().mapToDouble(Double::doubleValue).sum();
        sum = sum + chosenBriefcase[1];
        return sum;
    }

    public int getAmountRemainingBriefcases(){
        return briefcases.size();
    }


    @Override
    public String toString() {
        return "Briefcases" +
                "" + briefcases.keySet() +
                "";
    }
}
