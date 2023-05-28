package Game;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        GameProcess gameProcess = new GameProcess();
        gameProcess.welcomeToGame();
        gameProcess.inputShipsPlacementForFirstGamer();
        gameProcess.inputShipsPlacementForSecondGamer();
        gameProcess.battle();
    }
}
