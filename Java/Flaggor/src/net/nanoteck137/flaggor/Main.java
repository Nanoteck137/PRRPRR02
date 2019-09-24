package net.nanoteck137.flaggor;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Flaggor Uppgift");

        Rectangle rect = new Rectangle(0.0f, 32.0f,  32.0f, 32.0f);

        Group group = new Group();
        group.getChildren().add(rect);

        primaryStage.setScene(new Scene(group, 1280, 720));
        primaryStage.show();
    }
}
