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
        fillDefaultValuesToSHip();
    }

    public void inputShipsPlacementForFirstGamer() {
        System.out.println(gamer.getGamerName1() + " please indicate the location of the ships using a capital letter from A to J and a number from 1 to 10. " +
                "An example of the placement of ships is indicated in the rulebook of the game.");

        System.out.print("Mark the locations of the ship with a length of 4 cells: ");
        addShipsToStringArray(shipPlacementFirstGamer[0]);
        addShipToMap(shipPlacementFirstGamer[0], getShipsMapFirstGamer());

        System.out.println("Mark the locations of a ship with a length of 3 cells!");
        System.out.print("specify a place to place a first ship of size 3: ");
        addShipsToStringArray(shipPlacementFirstGamer[1]);
        addShipToMap(shipPlacementFirstGamer[1], getShipsMapFirstGamer());
        System.out.print("specify a place to place a second ship of size 3: ");
        addShipsToStringArray(shipPlacementFirstGamer[2]);
        addShipToMap(shipPlacementFirstGamer[2], getShipsMapFirstGamer());

        System.out.println("Mark the locations of three ships with a length of 2 cells!");
        System.out.print("specify a place to place a first ship of size 2: ");
        addShipsToStringArray(shipPlacementFirstGamer[3]);
        addShipToMap(shipPlacementFirstGamer[3], getShipsMapFirstGamer());
        System.out.print("specify a place to place a second ship of size 2: ");
        addShipsToStringArray(shipPlacementFirstGamer[4]);
        addShipToMap(shipPlacementFirstGamer[4], getShipsMapFirstGamer());
        System.out.print("specify a place to place a third ship of size 2: ");
        addShipsToStringArray(shipPlacementFirstGamer[5]);
        addShipToMap(shipPlacementFirstGamer[5], getShipsMapFirstGamer());

        System.out.println("Mark the locations of four ships with a length of 1 cell!");
        System.out.print("specify a place to place a first ship of size 1: ");
        addShipsToStringArray(shipPlacementFirstGamer[6]);
        addShipToMap(shipPlacementFirstGamer[6], getShipsMapFirstGamer());
        System.out.print("specify a place to place a second ship of size 1: ");
        addShipsToStringArray(shipPlacementFirstGamer[7]);
        addShipToMap(shipPlacementFirstGamer[7], getShipsMapFirstGamer());
        System.out.print("specify a place to place a third ship of size 1: ");
        addShipsToStringArray(shipPlacementFirstGamer[8]);
        addShipToMap(shipPlacementFirstGamer[8], getShipsMapFirstGamer());
        System.out.print("specify a place to place a fourth ship of size 1: ");
        addShipsToStringArray(shipPlacementFirstGamer[9]);
        addShipToMap(shipPlacementFirstGamer[9], getShipsMapFirstGamer());

        banOnViewingLocation();
        System.out.println(gridToString(getShipsMapFirstGamer()));
    }

    public void inputShipsPlacementForSecondGamer() {
        System.out.println(gamer.getGamerName2() + " please indicate the location of the ships using a capital letter from A to J and a number from 1 to 10. " +
                "An example of the placement of ships is indicated in the rulebook of the game.");
        System.out.print("Mark the locations of the ship with a length of 4 cells: ");
        addShipsToStringArray(shipPlacementSecondGamer[0]);
        addShipsForSecondGamer(shipPlacementSecondGamer[0]);

        System.out.println("Mark the locations of a ship with a length of 3 cells!");
        System.out.print("specify a place to place a first ship of size 3: ");
        addShipsToStringArray(shipPlacementSecondGamer[1]);
        addShipsForSecondGamer(shipPlacementSecondGamer[1]);
        System.out.print("specify a place to place a second ship of size 3: ");
        addShipsToStringArray(shipPlacementSecondGamer[2]);
        addShipsForSecondGamer(shipPlacementSecondGamer[2]);

        System.out.println("Mark the locations of three ships with a length of 2 cells!");
        System.out.print("specify a place to place a first ship of size 2: ");
        addShipsToStringArray(shipPlacementSecondGamer[3]);
        addShipsForSecondGamer(shipPlacementSecondGamer[3]);
        System.out.print("specify a place to place a second ship of size 2: ");
        addShipsToStringArray(shipPlacementSecondGamer[4]);
        addShipsForSecondGamer(shipPlacementSecondGamer[4]);
        System.out.print("specify a place to place a third ship of size 2: ");
        addShipsToStringArray(shipPlacementSecondGamer[5]);
        addShipsForSecondGamer(shipPlacementSecondGamer[5]);

        System.out.println("Mark the locations of four ships with a length of 1 cell!");
        System.out.print("specify a place to place a first ship of size 1: ");
        addShipsToStringArray(shipPlacementSecondGamer[6]);
        addShipsForSecondGamer(shipPlacementSecondGamer[6]);
        System.out.print("specify a place to place a second ship of size 1: ");
        addShipsToStringArray(shipPlacementSecondGamer[7]);
        addShipsForSecondGamer(shipPlacementSecondGamer[7]);
        System.out.print("specify a place to place a third ship of size 1: ");
        addShipsToStringArray(shipPlacementSecondGamer[8]);
        addShipsForSecondGamer(shipPlacementSecondGamer[8]);
        System.out.print("specify a place to place a fourth ship of size 1: ");
        addShipsToStringArray(shipPlacementSecondGamer[9]);
        addShipsForSecondGamer(shipPlacementSecondGamer[9]);

        banOnViewingLocation();
        System.out.println(gridToString(getShipsMapSecondGamer()));
    }

    public void battle() {

        while (true) {

            String shot;

            boolean firstGamerSHot = true;

            while (firstGamerSHot) {

                System.out.println(gridToString(getShotsMapFirstGamer()));
                System.out.print(gamer.getGamerName1() + " write in which cell you want to shoot ");
                shot = scanner.next();
                isClearShot(shot);
                firstGamerSHot = isHitToShip(shot, getShipsMapSecondGamer(), getShotsMapFirstGamer());
                System.out.println(chantWhenHitShip(firstGamerSHot));

                if (!firstGamerSHot) {
                    break;
                }

                boolean isDestroyed = isAHitOnDestroyedShipFirstGamer(getShotsMapFirstGamer(), shot);

                if (isDestroyed) {
                    System.out.println("Ship scuttled!");
                }

                if (isWin(getShipsMapFirstGamer())) {
                    firstGamerSHot = false;
                }
            }

            boolean secondGamerShot = true;

            while (secondGamerShot) {

                if (isWin(getShipsMapFirstGamer())) {
                    break;
                }

                System.out.println(gridToString(getShotsMapSecondGamer()));
                System.out.print(gamer.getGamerName2() + " write in which cell you want to shoot ");
                shot = scanner.next();
                isClearShot(shot);
                secondGamerShot = isHitToShip(shot, getShipsMapFirstGamer(), getShotsMapSecondGamer());
                System.out.println(chantWhenHitShip(secondGamerShot));

                if (!secondGamerShot) {
                    break;
                }

                boolean isDestroyed = isAHitOnDestroyedShipFirstGamer(getShotsMapFirstGamer(), shot);

                if (isDestroyed) {
                    System.out.println("Ship scuttled!");
                }

                if (isWin(getShipsMapSecondGamer())) {
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

