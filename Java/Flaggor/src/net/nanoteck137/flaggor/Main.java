package net.nanoteck137.flaggor;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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

        FlowPane flags = new FlowPane(germanFlag.render(0.0f, 0.0f, 0.5f), swedishFlag.render(0.0f, 0.0f,  0.5f));
        flags.setPrefWidth(1280 - 200);

        Rectangle rect = new Rectangle(200, 720);
        rect.setFill(new Color(1.0f, 0.0f, 1.0f, 1.0f));

        Font font = new Font("Verdana", 24);
        Text text = new Text("Hello World");
        text.setEffect(new Glow());
        text.setFont(font);
        text.setTextAlignment(TextAlignment.CENTER);

        Label label = new Label("Test Label");
        label.setFont(font);
        label.setPrefWidth(200);
        label.setTextAlignment(TextAlignment.RIGHT);
        label.setMinWidth(200);

        VBox panel = new VBox(label);
        panel.setMinWidth(200);
        panel.setFillWidth(true);
        panel.setCenterShape(true);

        Rectangle backgroundRect = new Rectangle(200, 720);
        backgroundRect.setFill(new Color(0.3f, 0.3f, 0.3f, 1.0f));

        StackPane left = new StackPane(backgroundRect, panel);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(left);
        borderPane.setCenter(flags);

        primaryStage.setScene(new Scene(borderPane, 1280, 720));
        primaryStage.show();
    }
}
