module ge.ftsu.tsudokujavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires log4j;
    requires java.desktop;


    opens ge.ftsu.tsudokujavafx to javafx.fxml;
    exports ge.ftsu.tsudokujavafx;
}