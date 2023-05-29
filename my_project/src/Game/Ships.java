package Game;

abstract class Ships {

    String[] shipLengthOfFour = new String[4];
    String[] shipsLengthOfThree = new String[6];
    String[] shipsLengthOfTwo = new String[6];
    String[] shipsLengthOfOne = new String[4];

    char emptyCellChar = '.';
    char shipCellChar = '☐';
    char emptyShotCellChar = '×';
    char shotShipCellChar = '☒';

    char[][] charShipMapPresentFirstGamer = new char[10][10];
    char[][] charShipMapPresentSecondGamer = new char[10][10];

}
