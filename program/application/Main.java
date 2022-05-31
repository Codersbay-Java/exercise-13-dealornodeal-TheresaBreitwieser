package application;


import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        boolean dealAccepted = false;

        game.myBriefcase.chooseFirstBriefcase();
        System.out.println(game.myBriefcase);
        int caseCounter=6;

        while(game.getRoundCount() <= 9 && !dealAccepted) {
            System.out.println("***** Round "+game.getRoundCount()+" *****");

            for(int i=0; i<caseCounter; i++){
                game.myBriefcase.chooseBriefcase();
                System.out.println(game.myBriefcase);
            }
            if(caseCounter >1){
                caseCounter--;
            }
            dealAccepted = game.deal();



            if(game.getRoundCount() == 9 && !dealAccepted){
                System.out.println("Suitcase number: " +game.myBriefcase.getBriefcases().keySet()+
                        " is the last one remaining. If you  would like to switch with your suitcase please enter yes");
                if(scanner.nextLine().equalsIgnoreCase("yes")){
                    System.out.println("Opening suitcase number: " +game.myBriefcase.getBriefcases().keySet()+
                            " Congratulations, you have won : " + game.myBriefcase.getBriefcases().values());
                } else {
                    System.out.println("Opening suitcase number: " + game.myBriefcase.chosenBriefcase[0] +
                            " Congratulations, you have won : " + game.myBriefcase.chosenBriefcase[1]);
                }
            }
            game.setRoundCount();

        }


    }


}
