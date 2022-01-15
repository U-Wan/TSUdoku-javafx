package ge.ftsu.tsudokujavafx.userinterface.logic;


import  ge.ftsu.tsudokujavafx.constants.GameState;
import  ge.ftsu.tsudokujavafx.constants.Messages;
import  ge.ftsu.tsudokujavafx.logic.GameLogic;
import  ge.ftsu.tsudokujavafx.auxiliaries.IStorage;
import  ge.ftsu.tsudokujavafx.auxiliaries.SudokuGame;
import  ge.ftsu.tsudokujavafx.userinterface.IUserInterfaceContract;

import java.io.IOException;

public class ControlLogic implements IUserInterfaceContract.EventListener {

    private IStorage storage;
    private IUserInterfaceContract.View view;

    public ControlLogic(IStorage storage, IUserInterfaceContract.View view) {
        this.storage = storage;
        this.view = view;
    }
    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            SudokuGame gameData = storage.getGameData();
            int[][] newGridState = gameData.getCopyOfGridState();
            newGridState[x][y] = input;

            gameData = new SudokuGame(
                    GameLogic.checkForCompletion(newGridState),
                    newGridState
            );
            storage.updateGameData(gameData);
            view.updateSquare(x, y, input);



           if (gameData.getGameState() == GameState.COMPLETE)
               view.showDialog(Messages.getProperties("Complete"));


         //  System.out.println(Messages.getmessage());
            //es ar imushavebs radgan propertidan amokitxvas vaketebt
        } catch (IOException e) {
            e.printStackTrace();
           view.showError(Messages.getProperties("Error"));
        }
    }

    @Override
    public void onDialogClick() {
        try {
            storage.updateGameData(
                    GameLogic.getNewGame()
            );
            view.updateBoard(storage.getGameData());
        } catch (IOException e) {
        view.showError(Messages.getProperties("Error"));
        }
    }
}
