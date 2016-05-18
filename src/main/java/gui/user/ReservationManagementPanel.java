package gui.user;

import dao.ReservationDAOImp;
import dao.RoomDAOImpl;
import dao.UserDAOImpl;
import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;
import model.Reservation;
import utility.Authorization;
import utility.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

/**
 * Created by marek on 18.5.16.
 */
public class ReservationManagementPanel extends ManagedCard {
    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");

    private JButton menuButton = new CardChoosingButton("Menu", UserGuidepostPanel.class);
    private JButton makeReservationButton = new JButton("Back");


    private boolean state = false;
    private JPanel cards = new JPanel(new CardLayout());
    private CardLayout cardLayout;


    {
        setupComponents();
    }

    public ReservationManagementPanel() {
        super(new BorderLayout());
    }

    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    @Override
    public void setupComponents() {
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        ReservationDAOImp reservationDAOImp = new ReservationDAOImp();

        final JPanel bottomPanel = bottomMenu();
        JPanel topPanel = upperMenu();

        UpdateReservationPanel temp1;


        JPanel panel = new JPanel(new SpringLayout());
        JPanel centerPanel = new JPanel(null);
        panel.add(new JLabel("Reservation ID"));
        panel.add(new JLabel("Room"));
        panel.add(new JLabel("Date from"));
        panel.add(new JLabel("Date to"));
        panel.add(new JLabel("Delete"));
        panel.add(new JLabel("Update"));

        CardChoosingButton button;
        if (Authorization.getUser() == null) {
            System.out.println("NO SHIT MAN");
        }
        for (Reservation r : Authorization.getUser().getReservations()) {
            panel.add(new JLabel(String.valueOf(r.getId())));
            panel.add(new JLabel(String.valueOf(r.getRoom().getId())));

            int year = r.getFromDate().get(Calendar.YEAR);
            int month = r.getFromDate().get(Calendar.MONTH);
            int day = r.getFromDate().get(Calendar.DAY_OF_MONTH);
            panel.add(new JLabel((String.format("%d/%d/%d", day, month, year))));

            year = r.getToDate().get(Calendar.YEAR);
            month = r.getToDate().get(Calendar.MONTH);
            day = r.getToDate().get(Calendar.DAY_OF_MONTH);
            panel.add(new JLabel((String.format("%d/%d/%d", day, month, year))));

            cards.add(new UpdateReservationPanel(r), r.getId().toString());


            button = new CardChoosingButton("DELETE", ReservationManagementPanel.class, true);
            button.addActionListener(e -> {
                Authorization.getUser().getReservations().remove(r);
                new UserDAOImpl().update(Authorization.getUser());
            });
            panel.add(button);

            JButton button1 = new JButton("UPDATE");
            button1.addActionListener(e -> {
                cardLayout.show(cards, r.getId().toString());

                nextButton.setEnabled(false);
                previousButton.setEnabled(false);
                makeReservationButton.setEnabled(true);
            });
            panel.add(button1);

        }
        SpringUtilities.makeGrid(panel, Authorization.getUser().getReservations().size() + 1, 6, // rows, cols
                50, 0, // initialX, initialY
                15, 15);// xPad, yPad
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 10, 960, 325);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        centerPanel.setPreferredSize(new Dimension(500, 400));
        centerPanel.add(scrollPane);

        makeReservationButton.setEnabled(false);
        makeReservationButton.addActionListener(e -> {
            cardLayout.show(cards, "management");
            makeReservationButton.setEnabled(false);

            nextButton.setEnabled(true);
            previousButton.setEnabled(true);
        });


        cards.add(centerPanel, "management");

        cardLayout = (CardLayout) cards.getLayout();


        add(cards, BorderLayout.CENTER);
        cardLayout.show(cards, "management");
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
