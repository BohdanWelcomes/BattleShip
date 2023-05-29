package Game;

import java.util.Scanner;

// 0 - empty, 1 - ship, 6 - missed shot, 7 - hit shot

public class BattleShipMap extends Ships {


    private static char[][] shipsMapFirstGamer = new char[10][10];
    private static char[][] shotsMapFirstGamer = new char[10][10];
    private static char[][] shipsMapSecondGamer = new char[10][10];
    private static char[][] shotsMapSecondGamer = new char[10][10];

    public char[][] getShipsMapFirstGamer() {
        return shipsMapFirstGamer;
    }

    public char[][] getShotsMapFirstGamer() {
        return shotsMapFirstGamer;
    }

    public char[][] getShipsMapSecondGamer() {
        return shipsMapSecondGamer;
    }

    public char[][] getShotsMapSecondGamer() {
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

    public void fillDefaultValuesToSHip() {
        for (int i = 0; i < shipsMapFirstGamer.length; i++) {
            for (int j = 0; j < shipsMapFirstGamer[0].length; j++) {
                shipsMapFirstGamer[i][j] = emptyCellChar;
            }
        }
        for (int i = 0; i < shotsMapFirstGamer.length; i++) {
            for (int j = 0; j < shotsMapFirstGamer[0].length; j++) {
                shotsMapFirstGamer[i][j] = emptyCellChar;
            }
        }
        for (int i = 0; i < shipsMapSecondGamer.length; i++) {
            for (int j = 0; j < shipsMapSecondGamer[0].length; j++) {
                shipsMapSecondGamer[i][j] = emptyCellChar;
            }
        }
        for (int i = 0; i < shotsMapSecondGamer.length; i++) {
            for (int j = 0; j < shotsMapSecondGamer[0].length; j++) {
                shotsMapSecondGamer[i][j] = emptyCellChar;
            }

        }
    }


    public void fillShipsMap(char[][] map, int cell) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (10 * i + j == cell) {
                    map[i][j] = shipCellChar;
                }
            }
        }
    } //Fill map input ships

    public int stringMarksForWritingMap(String str) {
        int letterToChar = str.charAt(0) - 64;
        int digitToChar = str.charAt(1) - 49;
        if (str.length() > 2) {
            digitToChar = 9;
        }
        int placementCell = (letterToChar + (10 * digitToChar)) - 1;
        return placementCell;
    }

    public String gridToString(char[][] shipsMap) {

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

    public boolean isWin(char[][] shipsMap) {
        for (int i = 0; i < shipsMap.length; i++) {
            for (int j = 0; j < shipsMap[0].length; j++) {
                if (shipsMap[i][j] == shipCellChar) {
                    return false;
                }
            }
        }
        return true;
    } // check were all ships destroyed

    public boolean isHitToShip(String shot, char[][] shipsMap, char[][] enemyShotsMap) {

        boolean isHit = false;

        int placementCell = stringMarksForWritingMap(shot);

        int row = placementCell / 10;
        int column = placementCell % 10;

        if (shipsMap[row][column] == shipCellChar) {
            isHit = true;
            shipsMap[row][column] = shotShipCellChar;
            enemyShotsMap[row][column] = shotShipCellChar;
        } else {
            enemyShotsMap[row][column] = emptyShotCellChar;
        }

//        System.out.println(gridToString(enemyShotsMap));
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

