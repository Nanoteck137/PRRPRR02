package net.nanoteck137.flaggor.flags;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;

public class FlagSoviet extends Flag {
    @Override
    public String getName() {
        return "Soviet";
    }

    @Override
    public Node render(float x, float y, float scale) {
        float flagWidth = 270.0f;
        float flagHeight = 180.0f;

        StackPane flagGroup = new StackPane();

        Rectangle rect = new Rectangle(flagWidth * scale, flagHeight * scale);
        rect.setFill(new Color(205 / 255.0f, 0 / 255.0f, 0 / 255.0f, 1.0f));
        flagGroup.getChildren().add(rect);

        Polygon hammer = Utils.renderHammerAndSickle(scale);

        hammer.setFill(new Color(255 / 255.0f, 217 / 255.0f, 0 / 255.0f, 1.0f));
        hammer.setTranslateX(-90.0f * scale);
        hammer.setTranslateY(-20.0f * scale);
        flagGroup.getChildren().add(hammer);

        StackPane starPane = new StackPane();
        Polygon outerStar = Utils.renderStar(2.0f * scale);
        outerStar.setFill(new Color(255 / 255.0f, 217 / 255.0f, 0 / 255.0f, 1.0f));
        starPane.getChildren().add(outerStar);

        Polygon innerStar = Utils.renderStar(1.0f * scale);
        innerStar.setFill(new Color(205 / 255.0f, 0 / 255.0f, 0 / 255.0f, 1.0f));
        starPane.getChildren().add(innerStar);

        starPane.setTranslateX(-90.0f * scale);
        starPane.setTranslateY(-70.0f * scale);

        flagGroup.getChildren().add(starPane);

        return flagGroup;
    }
}
