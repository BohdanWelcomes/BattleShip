package Game;

public class Test {
    public static void main(String[] args) {
        GameProcess gameProcess = new GameProcess();
        Gamer gamer = new Gamer();
////        gamer.welcomeToGame();
        gameProcess.inputShipsPlacementForFirstGamer();
        gameProcess.inputShipsPlacementForSecondGamer();
        gameProcess.shots();

    }
}
