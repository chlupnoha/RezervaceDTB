package gui.customcomponents;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 8.5.16.
 */
public class ListEnumPanel extends JPanel {

    public ListEnumPanel(String title, String items) {
        super(new BorderLayout());
        JLabel label = new JLabel(title);
        label.setPreferredSize(new Dimension(100, 0));

        add(label, BorderLayout.LINE_START);
        add(new JLabel(items), BorderLayout.SOUTH);
    }
}
