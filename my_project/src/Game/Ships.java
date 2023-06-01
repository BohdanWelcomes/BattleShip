package Game;

import java.util.ArrayList;
import java.util.List;

//Tests: A1 A2 A3 A4 ; E3 F3 G3  B8 C8 D8; F7 F8  J3 J4  C1 C2; H10 J9 H6 I1 (First gamer test)
//Tests: A6 B6 C6 D6 ; F1 F2 F3  F7 F8 F9; D1 D2  I2 I3  A2 B2; A8 B10 G5 I8 (Second gamer test)

class Ships {

    String[] shipLengthOfFourFirstGamer = {"A1", "A2", "A3", "A4"};
    String[] shipsLengthOfThreeFirstGamer = {"E3", "F3", "G3", "B8", "C8", "D8"};
    String[] shipsLengthOfTwoFirstGamer = {"F7", "F8",  "J3", "J4",  "C1", "C2"};
    String[] shipsLengthOfOneFirstGamer = {"H10", "J9", "H6", "I1"};

    String[] shipLengthOfFourSecondGamer = {"F2", "F3", "F4", "F5"};
    String[] shipsLengthOfThreeSecondGamer = { "A4", "A5", "A6", "J4", "J5", "J6"};
    String[] shipsLengthOfTwoSecondGamer = {"C4" ,"C5", "D10", "E10",  "H3", "H4"};
    String[] shipsLengthOfOneSecondGamer = { "A1","A10","J1","J10" };

    char emptyCellChar = '.';
    char shipCellChar = '☐';
    char emptyShotCellChar = '×';
    char shotShipCellChar = '☒';

    String[][] str = new String[8][];

    char[][] charShipMapPresentFirstGamer = new char[10][10];
    char[][] charShipMapPresentSecondGamer = new char[10][10];


}
