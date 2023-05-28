package Game;

import java.util.Scanner;

public class Gamer implements IntroductionToTheGame{
    private static String gamerName1;
    private static String gamerName2;

    public void welcomeToGame() {
        System.out.print("Welcome to the game! Please enter your game nick: ");
        Scanner scanner = new Scanner(System.in);
        gamerName1 = scanner.nextLine();
        System.out.println("It's nice to meet you, " + gamerName1 + "!");
        System.out.print("What about you, the gamer number two, please write down your game nick: ");
        gamerName2 = scanner.nextLine();
        System.out.println("It's nice to meet you, " + gamerName2 + "!");
        System.out.println("The rules of the game you can read when the author provide it.");
    }

    public static String getGamerName1() {
        return gamerName1;
    }

    public static String getGamerName2() {
        return gamerName2;
    }
}
