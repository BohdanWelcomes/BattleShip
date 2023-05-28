package Game;

import java.util.Arrays;
import java.util.Scanner;
// 0 - empty, 1 - ship, 6 - missed shot, 7 - hit shot

public class BattleShipMap {


    private static int[][] shipsMapFirstGamer = new int[10][10]; //	'\u0000'
    private static int[][] shotsMapFirstGamer = new int[10][10];
    private static int[][] ShipsMapSecondGamer = new int[10][10]; //	'\u0000'
    private static int[][] shotsMapSecondGamer = new int[10][10];

    public static int[][] getShipsMapFirstGamer() {
        return shipsMapFirstGamer;
    }

    public static int[][] getShotsMapFirstGamer() {
        return shotsMapFirstGamer;
    }

    public static int[][] getShipsMapSecondGamer() {
        return ShipsMapSecondGamer;
    }

    public static int[][] getShotsMapSecondGamer() {
        return shotsMapSecondGamer;
    }

    public static void fillShipsMap(int[][] map, int cell) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (10 * i + j == cell) {
                    map[i][j] = 1;
                }
            }
        }
    } //Fill map input ships

    public static int stringToInteger(String str) {
        int letterToChar = 0;
        int digitToChar = 0;
        letterToChar = str.charAt(0) - 64;
        digitToChar = str.charAt(1) - 49;
        if (str.length() > 2) {
            digitToChar = 9;
        }
        int placementCell = (letterToChar + (10 * digitToChar)) - 1;
        return placementCell;
    }

    public static String gridToString(int[][] shipsMap) {
        StringBuilder strb = new StringBuilder();
        char letterOfMap = 'A';

        for (int i = 0; i < shipsMap[0].length; i++) {

            strb.append(letterOfMap++);
            if (i == 9) {
                strb.append("\n");
            }
        }

        for (int i = 0; i < shipsMap[0].length; i++) {
            strb.append("_");
            if (i == 9) {
                strb.append("\n");
                strb.append("|");
                strb.append("\n");
            }
        }

        for (int i = 0; i < shipsMap.length; i++) {
            for (int j = 0; j < shipsMap[i].length; j++) {
                strb.append(shipsMap[i][j]);
            }
            strb.append("\n");
        }
        return strb.toString();
    } //from array to String

    public static void addShipsForFirstGamer(String[] ship) {
        int letterToChar = 0;
        int digitToChar = 0;
        for (int i = 0; i < ship.length; i++) {
            String cell = ship[i];
            letterToChar = cell.charAt(0) - 64;
            digitToChar = cell.charAt(1) - 49;
            if (cell.length() > 2) {
                digitToChar = 9;
            }
            int placementCell = (letterToChar + (10 * digitToChar)) - 1;
            BattleShipMap.fillShipsMap(BattleShipMap.getShipsMapFirstGamer(), placementCell);

        }
    } //add '1' to map, where 1 is ship placement

    public static void addShipsForSecondGamer(String[] ship) {
        int letterToChar = 0;
        int digitToChar = 0;
        for (int i = 0; i < ship.length; i++) {
            String cell = ship[i];
            letterToChar = cell.charAt(0) - 64;
            digitToChar = cell.charAt(1) - 49;
            if (cell.length() > 2) {
                digitToChar = 9;
            }
            int placementCell = (letterToChar + (10 * digitToChar)) - 1;
            BattleShipMap.fillShipsMap(BattleShipMap.getShipsMapSecondGamer(), placementCell);

        }
    } //add '1' to map, where 1 is ship placement

    public static void addShipsToStringArray(String[] sizeShipArray) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < sizeShipArray.length; i++) {
            sizeShipArray[i] = scanner.next();
        }
    } //add ships to int map

    public static boolean isWin(int[][] shipsMap) {
        for (int i = 0; i < shipsMap.length; i++) {
            for (int j = 0; j < shipsMap[0].length; j++) {
                if (shipsMap[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    } // check were all ships destroyed

    public static boolean isHitToShip(String shot, int[][] shipsMap, int[][] enemyShotsMap) {

        boolean isHit = false;

        int placementCell = stringToInteger(shot);

        int row = placementCell / 10;
        int column = placementCell % 10;

        if (shipsMap[row][column] == 1) {
            isHit = true;
            shipsMap[row][column] = 7;
            enemyShotsMap[row][column] = 7;
        } else {
            enemyShotsMap[row][column] = 6;
        }

        System.out.println(gridToString(enemyShotsMap));
        return isHit;
    }
}

