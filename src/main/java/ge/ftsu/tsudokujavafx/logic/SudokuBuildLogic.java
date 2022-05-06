package ge.ftsu.tsudokujavafx.logic;

import ge.ftsu.tsudokujavafx.auxiliaries.IStorage;
import ge.ftsu.tsudokujavafx.auxiliaries.SudokuGame;
import ge.ftsu.tsudokujavafx.userinterface.IUserInterfaceContract;
import ge.ftsu.tsudokujavafx.userinterface.logic.ControlLogic;
import ge.ftsu.tsudokujavafx.dataimpl.LocalStorageImpl;
import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            initialState = storage.getGameData();
        } catch (IOException e) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
