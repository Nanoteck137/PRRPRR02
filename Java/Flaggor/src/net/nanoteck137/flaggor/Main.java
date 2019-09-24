package net.nanoteck137.flaggor;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.nanoteck137.flaggor.flags.FlagGerman;
import net.nanoteck137.flaggor.flags.FlagSwedish;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Flaggor Uppgift");

        FlagSwedish swedishFlag = new FlagSwedish();
        FlagGerman germanFlag = new FlagGerman();

        HBox root = new HBox(germanFlag.render(0.0f, 0.0f, 0.5f), swedishFlag.render(0.0f, 0.0f,  0.5f));

        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }
}
