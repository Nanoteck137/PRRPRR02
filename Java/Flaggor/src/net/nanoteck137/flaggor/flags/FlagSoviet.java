package net.nanoteck137.flaggor.flags;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;

public class FlagSoviet extends Flag {
    @Override
    public Node render(float x, float y, float scale) {
        float flagWidth = 270.0f;
        float flagHeight = 180.0f;



        StackPane flagGroup = new StackPane();

        Rectangle rect = new Rectangle(flagWidth * scale, flagHeight * scale);
        rect.setFill(new Color(205 / 255.0f, 0 / 255.0f, 0 / 255.0f, 1.0f));
        flagGroup.getChildren().add(rect);

        Polygon polygon = new Polygon();
        float polygonScale = 0.19f * scale;
        polygon.getPoints().addAll(165.490 * polygonScale, 15.470 * polygonScale,
                247.438 * polygonScale, 65.036 * polygonScale,
                298.510 * polygonScale, 141.966 * polygonScale,
                299.337 * polygonScale, 201.509 * polygonScale,
                275.582 * polygonScale, 251.628 * polygonScale,
                315.140 * polygonScale, 290.491 * polygonScale,
                305.241 * polygonScale, 308.293 * polygonScale,
                289.169 * polygonScale, 315.531 * polygonScale,
                250.273 * polygonScale, 275.270 * polygonScale,
                195.242 * polygonScale, 292.955 * polygonScale,
                126.313 * polygonScale, 272.129 * polygonScale,
                96.926 * polygonScale, 246.335 * polygonScale,
                92.024 * polygonScale, 250.464 * polygonScale,
                93.350 * polygonScale, 260.065 * polygonScale,
                83.861 * polygonScale, 262.958 * polygonScale,
                63.027 * polygonScale, 284.978 * polygonScale,
                37.916 * polygonScale, 312.884 * polygonScale,
                17.998 * polygonScale, 308.493 * polygonScale,
                20.696 * polygonScale, 287.704 * polygonScale,
                63.090 * polygonScale, 250.212 * polygonScale,
                69.821 * polygonScale, 236.751 * polygonScale,
                79.125 * polygonScale, 237.352 * polygonScale,
                87.010 * polygonScale, 229.363 * polygonScale,
                95.784 * polygonScale, 229.037 * polygonScale,
                103.905 * polygonScale, 220.184 * polygonScale,
                110.724 * polygonScale, 225.801 * polygonScale,
                156.593 * polygonScale, 253.869 * polygonScale,
                224.287 * polygonScale, 248.379 * polygonScale,
                99.467 * polygonScale, 119.469 * polygonScale,
                71.375 * polygonScale, 148.854 * polygonScale,
                36.526 * polygonScale, 113.647 * polygonScale,
                102.587 * polygonScale, 48.254 * polygonScale,
                159.690 * polygonScale, 63.831 * polygonScale,
                120.367 * polygonScale, 99.004 * polygonScale,
                250.477 * polygonScale, 226.864 * polygonScale,
                267.687 * polygonScale, 181.360 * polygonScale,
                256.944 * polygonScale, 117.459 * polygonScale,
                206.286 * polygonScale, 49.177 * polygonScale,
                165.485 * polygonScale, 15.476 * polygonScale);
        polygon.setFill(new Color(255 / 255.0f, 217 / 255.0f, 0 / 255.0f, 1.0f));
        polygon.setTranslateX(-90.0f * scale);
        polygon.setTranslateY(-50.0f * scale);
        flagGroup.getChildren().add(polygon);

        return flagGroup;
    }
}
