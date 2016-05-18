package gui.user;

import dao.RezervationDAOImp;
import dao.RoomDAOImpl;
import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;
import model.Reservation;
import utility.Authorization;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 18.5.16.
 */
public class RegistrationManagementPanel extends ManagedCard {
    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");

    private JButton menuButton = new CardChoosingButton("Menu", UserGuidepostPanel.class);
    private JButton makeReservationButton = new JButton("Make reservation");

    {
        setupComponents();
    }

    public RegistrationManagementPanel() {
        super(new BorderLayout());
    }

    @Override
    public void setupComponents() {
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        RezervationDAOImp rezervationDAOImp = new RezervationDAOImp();


        final JPanel bottomPanel = bottomMenu();
        JPanel topPanel = upperMenu();


        JPanel centerPanel = new JPanel(new GridLayout(0, 4));
        JScrollPane scrollPane = new JScrollPane(centerPanel);



        for (Reservation r : Authorization.getUser().getReservations()) {
            centerPanel.add(new JLabel("# " + r.getRoom().getId()));
            centerPanel.add(new JLabel("# " + r.getFromDate()));
            centerPanel.add(new JLabel("# " + r.getToDate()));
            centerPanel.add(new JButton("delete"));

        }

        add(scrollPane);
        add(centerPanel, BorderLayout.CENTER);
    }


    private JPanel upperMenu() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(0, 75));

        topPanel.add(previousButton, BorderLayout.LINE_START);
        topPanel.add(nextButton, BorderLayout.LINE_END);
        topPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        add(topPanel, BorderLayout.PAGE_START);
        return topPanel;
    }

    private JPanel bottomMenu() {
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(0, 75));

        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        bottomPanel.add(menuButton, BorderLayout.LINE_START);
        bottomPanel.add(makeReservationButton, BorderLayout.LINE_END);

        add(bottomPanel, BorderLayout.PAGE_END);
        return bottomPanel;
    }


}
