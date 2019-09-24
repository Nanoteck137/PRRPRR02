package net.nanoteck137.flaggor.flags;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FlagGerman extends Flag {

    public FlagGerman() {

    }

    @Override
    public String getName() {
        return "German";
    }

    @Override
    public Node render(float x, float y, float scale) {
        float flagWidth = 270.0f;
        float flagHeight = 180.0f;

        StackPane flagGroup = new StackPane();
        flagGroup.setTranslateX(x);
        flagGroup.setTranslateY(y);

        float stripeHeight = flagHeight / 3;

        Rectangle stripe = new Rectangle(flagWidth * scale, stripeHeight * scale);
        // stripe.setFill(new Color(0 / 255.0f, 75 / 255.0f, 135 / 255.0f, 1.0f));
        stripe.setTranslateY(-stripeHeight * scale);
        flagGroup.getChildren().add(stripe);

        Rectangle stripe2 = new Rectangle(flagWidth * scale, stripeHeight * scale);
        stripe2.setFill(new Color(221 / 255.0f, 0 / 255.0f, 0 / 255.0f, 1.0f));
        stripe2.setTranslateY(0.0f);
        flagGroup.getChildren().add(stripe2);

        Rectangle stripe3 = new Rectangle(flagWidth * scale, stripeHeight * scale);
        stripe3.setFill(new Color(255 / 255.0f, 206 / 255.0f, 0 / 255.0f, 1.0f));
        stripe3.setTranslateY(stripeHeight * scale);
        flagGroup.getChildren().add(stripe3);

        return flagGroup;
    }
}
