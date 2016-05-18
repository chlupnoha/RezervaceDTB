package gui.customcomponents;

import gui.permission.ReservationConstraint;
import gui.user.UserGuidepostPanel;
import model.Room;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 8.5.16.
 */
public class RoomReservationPanel extends JPanel {

    private final Room room;
    private final ErrorLabel errorLabel = new ErrorLabel();
    private final DatePicker datePickerFrom = new DatePicker("FROM");
    private final DatePicker datePickerTo = new DatePicker("TO");
    private final CardChoosingButton makeReservationButton;

    public RoomReservationPanel(Room room) {
        super(new BorderLayout());

        this.room = room;

        makeReservationButton = new CardChoosingButton("Make reservation", UserGuidepostPanel.class, new ReservationConstraint(errorLabel, room, datePickerFrom, datePickerTo));
        setupComponents();
    }


    public void setupComponents() {
        final JPanel mainPanel = addUpperMenu();
    }

    private JPanel addUpperMenu() {
        if (room == null) {
            return null;
        }
        JPanel mainPanel = new JPanel(new GridLayout(0, 4));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        mainPanel.add(datePickerFrom);
        mainPanel.add(new JLabel());
        mainPanel.add(datePickerTo);
        mainPanel.add(new JLabel());
        add(mainPanel, BorderLayout.PAGE_START);

        JPanel mainBottomPanel = new JPanel(new GridLayout(0, 5));
        mainBottomPanel.add(new JLabel());
        mainBottomPanel.add(new JLabel());
        mainBottomPanel.add(makeReservationButton);
        mainBottomPanel.add(errorLabel);
        add(mainBottomPanel, BorderLayout.PAGE_END);

        return mainPanel;
    }
}