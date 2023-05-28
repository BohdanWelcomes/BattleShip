package Game;

import java.util.Scanner;

//Tests: A1 A2 A3 A4 ; E3 F3 G3  B8 C8 D8; F7 F8  J3 J4  C1 C2; H10 J9 H6 I1 (First gamer test)
//Tests: A6 B6 C6 D6 ; F1 F2 F3  F7 F8 F9; D1 D2  I2 I3  A2 B2; A8 B10 G5 I8 (Second gamer test)

public class GameProcess extends BattleShipMap {
    Scanner scanner = new Scanner(System.in);
    Gamer gamer = new Gamer();

    public void welcomeToGame() {
        System.out.print("Welcome to the game! The gamer № 1 please write your game nickname: ");
        Scanner scanner = new Scanner(System.in);
        gamer.setGamerName1(scanner.nextLine());
        System.out.println("It's nice to meet you, " + gamer.getGamerName1() + "!");
        System.out.print("What about you, the gamer № 2, please write your game nickname: ");
        gamer.setGamerName2(scanner.nextLine());
        System.out.println("It's nice to meet you, " + gamer.getGamerName2() + "!");
        System.out.println("The rules of the game you can read when the author provide it.");
    }

    public void inputShipsPlacementForFirstGamer() {
        System.out.println(gamer.getGamerName1() + " please indicate the location of the ships using a capital letter from A to J and a number from 1 to 10. " +
                "An example of the placement of ships is indicated in the rulebook of the game.");
        System.out.print("Mark the locations of the ship with a length of 4 cells: ");

        addShipsToStringArray(shipLengthOfFour);
        addShipsForFirstGamer(shipLengthOfFour);

        System.out.print("Mark the locations of two ships with a length of 3 cells: ");

        addShipsToStringArray(shipsLengthOfThree);
        addShipsForFirstGamer(shipsLengthOfThree);

        System.out.print("Mark the locations of three ships with a length of 2 cells: ");

        addShipsToStringArray(shipsLengthOfTwo);
        addShipsForFirstGamer(shipsLengthOfTwo);

        System.out.print("Mark the locations of four ships with a length of 1 cell: ");

        addShipsToStringArray(shipsLengthOfOne);
        addShipsForFirstGamer(shipsLengthOfOne);
        banOnViewingLocation();
    }

    public void inputShipsPlacementForSecondGamer() {
        System.out.println(gamer.getGamerName2() + " please indicate the location of the ships using a capital letter from A to J and a number from 1 to 10. " +
                "An example of the placement of ships is indicated in the rulebook of the game.");
        System.out.print("Mark the locations of the ship with a length of 4 cells: ");

        addShipsToStringArray(shipLengthOfFour);
        addShipsForSecondGamer(shipLengthOfFour);

        System.out.print("Mark the locations of two ships with a length of 3 cells: ");

        addShipsToStringArray(shipsLengthOfThree);
        addShipsForSecondGamer(shipsLengthOfThree);

        System.out.print("Mark the locations of three ships with a length of 2 cells: ");

        addShipsToStringArray(shipsLengthOfTwo);
        addShipsForSecondGamer(shipsLengthOfTwo);

        System.out.print("Mark the locations of four ships with a length of 1 cell: ");

        addShipsToStringArray(shipsLengthOfOne);
        addShipsForSecondGamer(shipsLengthOfOne);

//        String map = BattleShipMap.gridToString(BattleShipMap.getShipsMapSecondGamer());
//        System.out.println(map);
    }

    public void battle() {

        while (true) {

            String shot;
            boolean firstGamerSHot = true;

            while (firstGamerSHot) {
                System.out.print(gamer.getGamerName1() + " write in which cell you want to shoot ");
                shot = scanner.next();
                firstGamerSHot = isHitToShip(shot, getShipsMapSecondGamer(), getShotsMapFirstGamer());

                System.out.println(chantWhenHitShip(firstGamerSHot));

                if (isWin(getShipsMapFirstGamer())) {
                    firstGamerSHot = false;
                }
            }

            boolean secondGamerShot = true;

            while (secondGamerShot) {
                System.out.print(gamer.getGamerName2() + " write in which cell you want to shoot ");
                shot = scanner.next();
                secondGamerShot = isHitToShip(shot, getShipsMapFirstGamer(), getShotsMapSecondGamer());
                System.out.println(chantWhenHitShip(secondGamerShot));


                if (isWin(getShipsMapFirstGamer())) {
                    secondGamerShot = false;
                }
            }

            if (isWin(getShipsMapSecondGamer())) {
                System.out.println("Congratulations " + gamer.getGamerName1() + ", you are the ultimate pirate in the Caribbean. ");
                break;
            } else if (isWin(getShipsMapFirstGamer())) {
                System.out.println("Congratulations " + gamer.getGamerName2() + ", you are the ultimate pirate in the Caribbean. ");
                break;

            }
        }
    }
}

