package net.nanoteck137.flaggor;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import net.nanoteck137.flaggor.flags.Flag;
import net.nanoteck137.flaggor.flags.FlagGerman;
import net.nanoteck137.flaggor.flags.FlagSoviet;
import net.nanoteck137.flaggor.flags.FlagSwedish;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Flaggor Uppgift");

        ArrayList<Flag> flags = new ArrayList<Flag>();
        flags.add(new FlagSwedish());
        flags.add(new FlagGerman());
        flags.add(new FlagSoviet());

        FlowPane flagPane = new FlowPane();
        for(Flag flag : flags) {
            flagPane.getChildren().add(flag.render(0.0f, 0.0f, 1.0f));
        }

        float scale = 0.3f;
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(376.2 * scale, 3535.9* scale, -432.9* scale, 2948.1* scale, 59.8* scale, 3120.6* scale, 376.2* scale, 3535.9* scale,
                567.1 * scale, 2948.1* scale, -432.9* scale, 2948.1* scale, 59.8* scale, 3133.7* scale, 567.1* scale, 2948.1* scale,
                -241.9 * scale, 3535.9* scale, 567.1* scale, 2948.1* scale, 58.5* scale, 3089.9* scale, -241.9* scale, 3535.9* scale,
                376.2 * scale, 3535.9* scale, 67.1* scale, 2584.8* scale, 15.0* scale, 3128.8* scale, 376.2* scale, 3535.9* scale,
                -241.9 * scale, 3535.9* scale, 67.1* scale, 2584.8* scale, 99.6* scale, 3123.9* scale, -241.9* scale, 3535.9* scale,
                376.2 * scale, 3535.9* scale, -432.9* scale, 2948.1* scale, 59.8* scale, 3120.6* scale, 376.2* scale, 3535.9* scale,
                567.1 * scale, 2948.1* scale, -432.9* scale, 2948.1* scale, 59.8* scale, 3133.7* scale, 567.1* scale, 2948.1* scale,
                -241.9 * scale, 3535.9* scale, 567.1* scale, 2948.1* scale, 58.5* scale, 3089.9* scale, -241.9* scale, 3535.9* scale,
                376.2 * scale, 3535.9* scale, 67.1* scale, 2584.8* scale, 15.0* scale, 3128.8* scale, 376.2* scale, 3535.9* scale,
                -241.9 * scale, 3535.9* scale, 67.1* scale, 2584.8* scale, 99.6* scale, 3123.9* scale, -241.9* scale, 3535.9* scale);

        flagPane.getChildren().add(polygon);

        flagPane.setPrefWidth(1280 - 200);

        Font font = new Font("Verdana", 24);

        VBox panel = new VBox();
        panel.setMinWidth(200);
        panel.setFillWidth(true);
        panel.setCenterShape(true);

        Label label = new Label("Test Label");
        label.setFont(font);
        label.setTextAlignment(TextAlignment.RIGHT);
        panel.getChildren().add(label);

        Slider slider = new Slider(0.5f, 4.0f, 1.0f);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            flagPane.getChildren().clear();

            for(Flag flag : flags) {
                flagPane.getChildren().add(flag.render(0.0f, 0.0f, newValue.floatValue()));
            }
        });
        panel.getChildren().add(slider);

        for(Flag flag : flags) {
            Label flagName = new Label(flag.getName());
            flagName.setFont(font);
            flagName.setTextAlignment(TextAlignment.CENTER);
            flagName.setTextFill(new Color(0.8f, 0.8f, 0.8f, 1.0f));

            panel.getChildren().add(flagName);
        }

        Rectangle backgroundRect = new Rectangle(200, 720);
        backgroundRect.setFill(new Color(0.3f, 0.3f, 0.3f, 1.0f));

        StackPane left = new StackPane(backgroundRect, panel);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(left);
        borderPane.setCenter(flagPane);

        primaryStage.setScene(new Scene(borderPane, 1280, 720));
        primaryStage.show();
    }
}
