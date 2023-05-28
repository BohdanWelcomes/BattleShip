package Game;

import java.util.Scanner;

// 0 - empty, 1 - ship, 6 - missed shot, 7 - hit shot

public class BattleShipMap extends Ships {


    private static int[][] shipsMapFirstGamer = new int[10][10];
    private static int[][] shotsMapFirstGamer = new int[10][10];
    private static int[][] ShipsMapSecondGamer = new int[10][10];
    private static int[][] shotsMapSecondGamer = new int[10][10];

    public int[][] getShipsMapFirstGamer() {
        return shipsMapFirstGamer;
    }

    public int[][] getShotsMapFirstGamer() {
        return shotsMapFirstGamer;
    }

    public int[][] getShipsMapSecondGamer() {
        return ShipsMapSecondGamer;
    }

    public int[][] getShotsMapSecondGamer() {
        return shotsMapSecondGamer;
    }

    public void banOnViewingLocation() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void fillShipsMap(int[][] map, int cell) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (10 * i + j == cell) {
                    map[i][j] = 1;
                }
            }
        }
    } //Fill map input ships

    public int stringToInteger(String str) {
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

    public String gridToString(int[][] shipsMap) {
        StringBuilder strb = new StringBuilder("   ");
        char letterOfMap = 'A';

        for (int i = 0; i < shipsMap[0].length; i++) {
            strb.append(letterOfMap++).append(" ");
            if (i == 9) {
                strb.append("\n");
                strb.append("   ");
            }
        }

        for (int i = 0; i < shipsMap[0].length + 9; i++) {
            strb.append("-");
            if (i == 18) {
                strb.append("\n");
                strb.append(" 1|");
            }
        }

        for (int i = 0; i < shipsMap.length; i++) {
            for (int j = 0; j < shipsMap[i].length; j++) {
                strb.append(shipsMap[i][j]).append(" ");
            }

            strb.append("\n");

            if (i + 2 != 10) {
                strb.append(" ");
            }
            if (i == shipsMap.length - 1) {
                break;
            }
            strb.append(i + 2);
            strb.append("|");

        }
        return strb.toString();
    } //from array to String

    public void addShipsForFirstGamer(String[] ship) {
        for (int i = 0; i < ship.length; i++) {
            String cell = ship[i];
            int letterToChar = cell.charAt(0) - 64;
            int digitToChar = cell.charAt(1) - 49;
            if (cell.length() > 2) {
                digitToChar = 9;
            }
            int placementCell = (letterToChar + (10 * digitToChar)) - 1;
            fillShipsMap(getShipsMapFirstGamer(), placementCell);

        }
    } //add '1' to map, where 1 is ship placement

    public void addShipsForSecondGamer(String[] ship) {
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
            fillShipsMap(getShipsMapSecondGamer(), placementCell);

        }
    } //add '1' to map, where 1 is ship placement

    public void addShipsToStringArray(String[] sizeShipArray) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < sizeShipArray.length; i++) {
            sizeShipArray[i] = scanner.next();
        }
    } //add ships to int map

    public boolean isWin(int[][] shipsMap) {
        for (int i = 0; i < shipsMap.length; i++) {
            for (int j = 0; j < shipsMap[0].length; j++) {
                if (shipsMap[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    } // check were all ships destroyed

    public boolean isHitToShip(String shot, int[][] shipsMap, int[][] enemyShotsMap) {

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

    public String chantWhenHitShip(boolean isHit) {
        String result = null;
        if (!isHit) {
            return "Bad luck";
        } else {


            String[] chant = {"straight to the bullseye!", "young man, drown him", "Lets go, lets fight, we're here to win all right", "No survivors?", "Bring me that horizon",
                    "Somebody give a bottle of rome for this pirate!", "If you get into his ship again, he must declare to the British government that you are a dangerous pirate!",
                    "Head shot if it would be Counter Strike", "Can I ask you: Do you have black beard?"};

            for (int i = 0; i < chant.length; i++) {
                int rand = (int) (Math.random() * 9);
                result = chant[rand];
            }
            return result;
        }
    }
}

