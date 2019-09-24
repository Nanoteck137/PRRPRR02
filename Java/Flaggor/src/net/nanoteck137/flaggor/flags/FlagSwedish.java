package net.nanoteck137.flaggor.flags;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class FlagSwedish extends Flag {

    public FlagSwedish() {

    }

    @Override
    public String getName() {
        return "Swedish";
    }

    @Override
    public Node render(float x, float y, float scale) {
        float flagWidth = 270.0f;
        float flagHeight = 180.0f;

        StackPane flagGroup = new StackPane();
        flagGroup.setTranslateX(x);
        flagGroup.setTranslateY(y);

        Rectangle mainRect = new Rectangle(flagWidth * scale, flagHeight * scale);
        mainRect.setFill(new Color(0 / 255.0f, 75 / 255.0f, 135 / 255.0f, 1.0f));
        flagGroup.getChildren().add(mainRect);

        Rectangle stripe = new Rectangle(30.0f * scale, flagHeight * scale);
        stripe.setFill(new Color(255 / 255.0f, 205 / 255.0f, 0 / 255.0f, 1.0f));

        float offset = 70.0f * scale;
        stripe.setTranslateX(-mainRect.getWidth() / 2 + stripe.getWidth() / 2 + offset);

        flagGroup.getChildren().add(stripe);

        Rectangle stripe2 = new Rectangle(flagWidth * scale, 30.0f * scale);
        stripe2.setFill(new Color(255 / 255.0f, 205 / 255.0f, 0 / 255.0f, 1.0f));
        flagGroup.getChildren().add(stripe2);

        return flagGroup;
    }
}
