package Game;

import java.util.Scanner;

public class Game {

    void game() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the game! Gamer № 1 enter your game nick: ");
        String firstGamer = scanner.nextLine();
        System.out.print("Gamer № 2 enter your game nick: ");
        String secondGamer = scanner.nextLine();


        while (true) { //OK

            System.out.print(firstGamer + ", write the place when you want to shot: ");

            String shot = scanner.next();
            boolean doesTheFirstGamerHit = BattleShipMap.isHitToShip(shot, BattleShipMap.getShipsMapSecondGamer(), BattleShipMap.getShotsMapFirstGamer());

            while (doesTheFirstGamerHit) {
                System.out.print(firstGamer + ", write the place when you want to shot again");
                shot = scanner.next();
                doesTheFirstGamerHit = BattleShipMap.isHitToShip(shot, BattleShipMap.getShipsMapSecondGamer(), BattleShipMap.getShotsMapFirstGamer());
            }

            System.out.print(secondGamer + ", write the place when you want to shot: ");
            shot = scanner.next();
            boolean doesTheSecondGamerHit = BattleShipMap.isHitToShip(shot, BattleShipMap.getShipsMapFirstGamer(), BattleShipMap.getShotsMapSecondGamer());

            while (doesTheSecondGamerHit) {
                System.out.print(secondGamer + ", write the place when you want to shot again: ");
                shot = scanner.next();
                doesTheSecondGamerHit = BattleShipMap.isHitToShip(shot, BattleShipMap.getShipsMapFirstGamer(), BattleShipMap.getShotsMapSecondGamer());
            }

            if (BattleShipMap.isWin(BattleShipMap.getShipsMapFirstGamer())) {
                System.out.println("Congratulations " + firstGamer + ", you are the ultimate pirate in the Caribbean. ");
                break;
            } else if (BattleShipMap.isWin(BattleShipMap.getShipsMapSecondGamer())) {
                System.out.println("Congratulations " + secondGamer + ", you are the ultimate pirate in the Caribbean. ");
                break;
            }
        }
    }
}
