package net.nanoteck137.flaggor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import net.nanoteck137.flaggor.flags.FlagSwedish;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Flaggor Uppgift");

        FlagSwedish swedishFlag = new FlagSwedish();

        Group root = new Group(swedishFlag.render(40, 40, 0.3f));

        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }
}
