package gui.user;

import dao.ReservationDAOImp;
import gui.customcomponents.CardChoosingButton;
import gui.customcomponents.DatePicker;
import gui.customcomponents.ErrorLabel;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by marek on 18.5.16.
 */
public class UpdateReservationPanel extends JPanel {

    private final Reservation reservation;
    private ReservationDAOImp reservationDAOImp = new ReservationDAOImp();
    private ErrorLabel errorLabel = new ErrorLabel();
    private DatePicker datePickerFrom = new DatePicker("FROM");
    private DatePicker datePickerTo = new DatePicker("TO");
    private JButton makeReservationButton;

    public UpdateReservationPanel(Reservation reservation) {
        super();
        this.reservation = reservation;
        makeReservationButton = new JButton("Update reservation");

        makeReservationButton.addActionListener(e -> {
            int day = datePickerFrom.getDay();
            int month = datePickerFrom.getMonth();
            int year = datePickerFrom.getYear();
            Calendar c = new GregorianCalendar(year, month, day);

            day = datePickerTo.getDay();
            month = datePickerTo.getMonth();
            year = datePickerTo.getYear();
            Calendar c1 = new GregorianCalendar(year, month, day);


            reservation.setFromDate(c);
            reservation.setToDate(c1);

            reservationDAOImp.update(reservation);

            new CardChoosingButton("", ReservationManagementPanel.class, true).invoke();
        });


        setupComponents();
    }


    public void setupComponents() {
        final JPanel mainPanel = addUpperMenu();
    }

    private JPanel addUpperMenu() {
        if (reservation == null) {
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
