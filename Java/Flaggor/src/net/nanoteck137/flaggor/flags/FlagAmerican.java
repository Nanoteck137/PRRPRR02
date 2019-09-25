package net.nanoteck137.flaggor.flags;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class FlagAmerican extends Flag {
    @Override
    public String getName() {
        return "American";
    }

    @Override
    public Node render(float x, float y, float scale) {
        float flagWidth = 270.0f * scale;
        float flagHeight = 180.0f * scale;

        StackPane flagGroup = new StackPane();

        Rectangle background = new Rectangle(flagWidth, flagHeight);
        background.setFill(new Color(178 / 255.0f, 34 / 255.0f, 52 / 255.0f, 1.0f));
        flagGroup.getChildren().add(background);

        float unit = flagHeight / 13;

        for(int i = 0; i < 13; i += 2) {
            Rectangle stripe = new Rectangle(flagWidth, unit);

            stripe.setTranslateY(-flagHeight / 2 + stripe.getHeight() / 2 + unit + unit * i);
            stripe.setFill(new Color(254 / 255.0f, 254 / 255.0f, 254 / 255.0f, 1.0f));
            flagGroup.getChildren().add(stripe);
        }

        Rectangle rect = new Rectangle(unit * 8, unit * 7);
        rect.setTranslateX(-flagWidth / 2 + rect.getWidth() / 2 - 1);
        rect.setTranslateY(-flagHeight / 2 + rect.getHeight() / 2);
        rect.setFill(new Color(60 / 255.0f, 59 / 255.0f, 110 / 255.0f, 1.0f));
        flagGroup.getChildren().add(rect);

        for(int i = 0; i < 9; i += 2) {
            for(int j = 0;  j < 6; j++) {
                Polygon star = Utils.renderStar(1.4f);
                star.setFill(new Color(254 / 255.0f, 254 / 255.0f, 254 / 255.0f, 1.0f));
                star.setTranslateX(-flagWidth / 2 + star.getLayoutBounds().getWidth() / 2 + 8 + (unit + 8.0f)* j);
                star.setTranslateY(-flagHeight / 2 + star.getLayoutBounds().getHeight() / 2 + 6 + (unit - 8) * i);
                flagGroup.getChildren().add(star);
            }
        }

        for(int i = 1; i < 9; i += 2) {
            for(int j = 0;  j < 5; j++) {
                Polygon star = Utils.renderStar(1.4f);
                star.setFill(new Color(254 / 255.0f, 254 / 255.0f, 254 / 255.0f, 1.0f));
                star.setTranslateX(-flagWidth / 2 + star.getLayoutBounds().getWidth() / 2 + 24 + (unit + 8.0f) * j);
                star.setTranslateY(-flagHeight / 2 + star.getLayoutBounds().getHeight() / 2 + 6 + (unit - 8) * i);
                flagGroup.getChildren().add(star);
            }
        }


        return flagGroup;
    }
}
