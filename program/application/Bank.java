package application;

public class Bank {
double bankOffer;


    public double calculateBankOffer(Briefcase briefcase, int roundCount){
        double sumBriefcases = briefcase.getSumBriefcases();
      bankOffer = (sumBriefcases/(double)(briefcase.getAmountRemainingBriefcases())) * roundCount / 10;
      return bankOffer;

    }


   // First, calculate the total value of the remaining suitcases, including the one picked by the player.
  //  Then divide this total value by the number
  //  of remaining suitcases to get an expected value. Lastly, multiply the expected value by the current
  //  round and then divide it by 10.
}
