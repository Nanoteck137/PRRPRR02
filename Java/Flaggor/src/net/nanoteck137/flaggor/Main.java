package net.nanoteck137.flaggor;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import net.nanoteck137.flaggor.flags.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private List<Flag> flags;

    private Flag currentFlag = null;

    public void switchFlag() {

    }

    @Override
    public void init() throws Exception {
        super.init();

        flags = new ArrayList<>();
        flags.add(new FlagSwedish());
        flags.add(new FlagGerman());
        flags.add(new FlagSoviet());
        flags.add(new FlagAmerican());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Flaggor Uppgift");

        FlowPane flagPane = new FlowPane();
        /*for(Flag flag : flags) {
            flagPane.getChildren().add(flag.render(0.0f, 0.0f, 2.0f));
        }*/

        flagPane.getChildren().add(flags.get(3).render(0.0f, 0.0f, 1.0f));

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

            flagPane.getChildren().add(currentFlag.render(0.0f, 0.0f, newValue.floatValue()));
        });
        panel.getChildren().add(slider);

        VBox flagSelect = new VBox();

        ToggleGroup flagToggleGroup = new ToggleGroup();
        flagToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if(flagToggleGroup.selectedToggleProperty() != null) {
                Flag flag = (Flag)flagToggleGroup.getSelectedToggle().getUserData();
                currentFlag = flag;

                flagPane.getChildren().clear();
                flagPane.getChildren().add(flag.render(0.0f, 0.0f, 1.0f));
                System.out.println(flag.getName());
            }
        });
        for(Flag flag : flags) {
            /*CheckBox flagCheck = new CheckBox(flag.getName());
            flagCheck.setTextFill(new Color(1.0f, 1.0f, 1.0f, 1.0f));
            flagCheck.setTranslateX(4.0f);
            flagCheck.setFont(font);
            panel.getChildren().add(flagCheck);*/

            RadioButton flagRadioButton = new RadioButton(flag.getName());
            flagRadioButton.setToggleGroup(flagToggleGroup);
            flagRadioButton.setUserData(flag);

            flagSelect.getChildren().add(flagRadioButton);
        }
        ((RadioButton)flagSelect.getChildren().get(3)).setSelected(true);
        flagSelect.setSpacing(10.0f);
        flagSelect.setTranslateX(4.0f);
        panel.getChildren().add(flagSelect);

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
