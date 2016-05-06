package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 5.5.16.
 */
public abstract class ManagedCard extends JPanel {
    public ManagedCard(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public ManagedCard(LayoutManager layout) {
        super(layout);
    }

    public ManagedCard(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public ManagedCard() {
    }

    private void setupBasics() {
        setPreferredSize(new Dimension(800, 500));
        setVisible(true);
    }

}
