package Game;

import java.util.Scanner;

// TODO: 28.05.2023 Проверить результаты метода шот и начинать укранать проект

//Tests: A1 A2 A3 A4 ; E3 F3 G3  B8 C8 D8; F7 F8  J3 J4  C1 C2; H10 J9 H6 I1 (First gamer test)
//Tests: A6 B6 C6 D6 ; F1 F2 F3  F7 F8 F9; D1 D2  I2 I3  A2 B2; A8 B10 G5 I8 (Second gamer test)

public class GameProcess extends Ships {
    Scanner scanner = new Scanner(System.in);

    @Override
    void inputShipsPlacementForFirstGamer(String... ship) {
        System.out.println(Gamer.getGamerName1() + ", please indicate the location of the ships using a capital letter from A to J and a number from 1 to 10. " +
                "An example of the placement of ships is indicated in the rulebook of the game.");
        System.out.print("Mark the locations of the ship with a length of 4 cells: ");

        BattleShipMap.addShipsToStringArray(shipLengthOfFour);
        BattleShipMap.addShipsForFirstGamer(shipLengthOfFour);

        System.out.print("Mark the locations of two ships with a length of 3 cells: ");

        BattleShipMap.addShipsToStringArray(shipsLengthOfThree);
        BattleShipMap.addShipsForFirstGamer(shipsLengthOfThree);

        System.out.print("Mark the locations of three ships with a length of 2 cells: ");

        BattleShipMap.addShipsToStringArray(shipsLengthOfTwo);
        BattleShipMap.addShipsForFirstGamer(shipsLengthOfTwo);

        System.out.print("Mark the locations of four ships with a length of 1 cell: ");

        BattleShipMap.addShipsToStringArray(shipsLengthOfOne);
        BattleShipMap.addShipsForFirstGamer(shipsLengthOfOne);

//        String map = BattleShipMap.gridToString(BattleShipMap.getShipsMapFirstGamer());
//        System.out.println(map);
    }

    @Override
    void inputShipsPlacementForSecondGamer(String... ship) {
        System.out.println(Gamer.getGamerName2() + ", please indicate the location of the ships using a capital letter from A to J and a number from 1 to 10. " +
                "An example of the placement of ships is indicated in the rulebook of the game.");
        System.out.print("Mark the locations of the ship with a length of 4 cells: ");

        BattleShipMap.addShipsToStringArray(shipLengthOfFour);
        BattleShipMap.addShipsForSecondGamer(shipLengthOfFour);

        System.out.print("Mark the locations of two ships with a length of 3 cells: ");

        BattleShipMap.addShipsToStringArray(shipsLengthOfThree);
        BattleShipMap.addShipsForSecondGamer(shipsLengthOfThree);

        System.out.print("Mark the locations of three ships with a length of 2 cells: ");

        BattleShipMap.addShipsToStringArray(shipsLengthOfTwo);
        BattleShipMap.addShipsForSecondGamer(shipsLengthOfTwo);

        System.out.print("Mark the locations of four ships with a length of 1 cell: ");

        BattleShipMap.addShipsToStringArray(shipsLengthOfOne);
        BattleShipMap.addShipsForSecondGamer(shipsLengthOfOne);

//        String map = BattleShipMap.gridToString(BattleShipMap.getShipsMapSecondGamer());
//        System.out.println(map);
    }


    void shots() {

        while (true) { //OK

            System.out.print("Please write the place when you want to shot number 1");

            String shot = scanner.next();
            boolean firstGamerSHot = BattleShipMap.isHitToShip(shot, BattleShipMap.getShipsMapSecondGamer(), BattleShipMap.getShotsMapFirstGamer());

            while (firstGamerSHot) {
                System.out.print("Please write the place when you want to shot " + Gamer.getGamerName1());
                shot = scanner.next();
                firstGamerSHot = BattleShipMap.isHitToShip(shot, BattleShipMap.getShipsMapSecondGamer(), BattleShipMap.getShotsMapFirstGamer());
            }

            System.out.print("Please write the place when you want to shot number 1");
            shot = scanner.next();
            boolean secondGamerShot = BattleShipMap.isHitToShip(shot, BattleShipMap.getShipsMapFirstGamer(), BattleShipMap.getShotsMapSecondGamer());

            while (secondGamerShot) {
                System.out.print("Please write the place when you want to shot " + Gamer.getGamerName2());
                shot = scanner.next();
                secondGamerShot = BattleShipMap.isHitToShip(shot, BattleShipMap.getShipsMapFirstGamer(), BattleShipMap.getShotsMapSecondGamer());
            }

            if (BattleShipMap.isWin(BattleShipMap.getShipsMapFirstGamer())) {
                System.out.println("Congratulations " + Gamer.getGamerName1() + ", you are the ultimate pirate in the Caribbean. ");
                break;
            } else if (BattleShipMap.isWin(BattleShipMap.getShipsMapSecondGamer())) {
                System.out.println("Congratulations " + Gamer.getGamerName2() + ", you are the ultimate pirate in the Caribbean. ");
                break;

            }
        }
    }
}

