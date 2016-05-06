package gui.customcomponents;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 6.5.16.
 */
public class ErrorLabel extends JLabel {

    {
        this.setForeground(Color.red);
    }


    public ErrorLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public ErrorLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public ErrorLabel(String text) {
        super(text);
    }

    public ErrorLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public ErrorLabel(Icon image) {
        super(image);
    }

    public ErrorLabel() {
    }

}
