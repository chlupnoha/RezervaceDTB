package gui.customcomponents;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.stream.IntStream;

enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private int order;

    Month(int order) {
        this.order = order;
    }
}

/**
 * Created by marek on 11.5.16.
 */
public class DatePicker extends JPanel {
    public DatePicker() {
        super(new GridLayout(0, 1));
        setupComponents();
    }

    public DatePicker(String label) {
        super(new GridLayout(0, 1));
        add(new JLabel("        " + label));
        setupComponents();
    }

    private void setupComponents() {

        add(new JLabel("Month:"));
        JComboBox monthList = new JComboBox();
        Arrays.stream(Month.values()).forEach((m) -> monthList.addItem(m));
        add(monthList);

        add(new JLabel("Day:"));
        JComboBox dayList = new JComboBox();
        IntStream.range(1, 13).forEach((i) -> dayList.addItem(i));
        add(dayList);

        add(new JLabel("Year:"));
        JComboBox yearList = new JComboBox();
        IntStream.range(2016, 2017).forEach((i) -> yearList.addItem(i));
        add(yearList);


    }

}