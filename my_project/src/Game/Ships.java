package Game;

import java.util.ArrayList;
import java.util.List;

//Tests: A1 A2 A3 A4 ; E3 F3 G3  B8 C8 D8; F7 F8  J3 J4  C1 C2; H10 J9 H6 I1 (First gamer test)
//Tests: A6 B6 C6 D6 ; F1 F2 F3  F7 F8 F9; D1 D2  I2 I3  A2 B2; A8 B10 G5 I8 (Second gamer test)

class Ships {
    
    String[][] shipPlacementFirstGamer = randomShipPlacement();

    String[][] shipPlacementSecondGamer = randomShipPlacement();
    
    private String[][] randomShipPlacement() {
        String[][] shipPlacement = {{"1", "2", "3", "4"},
                {"1", "2", "3"}, {"1", "2", "3"},
                {"1", "2"}, {"1", "2"}, {"1", "2"},
                {"1"}, {"1"}, {"1"}, {"1"}};
        // TODO: 25.07.2023 Napisać metodę, która losowo iniciuje rozmieszczenie statków w tablicy
        return shipPlacement;
    }

    char emptyCellChar = '.';
    static char shipCellChar = '☐';
    static char emptyShotCellChar = '×';
    static char shotShipCellChar = '☒';

}
