package net.nanoteck137.flaggor.flags;

import javafx.scene.Node;

public abstract class Flag {

    public String getName() { return "Unknown"; }

    public abstract Node render(float x, float y, float scale);

}
