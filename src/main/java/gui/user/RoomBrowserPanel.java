package gui.user;

import dao.RoomDAOImpl;
import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;
import gui.customcomponents.RoomPreviewPanel;
import gui.customcomponents.RoomReservationPanel;
import model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marek on 8.5.16.
 */
public class RoomBrowserPanel extends ManagedCard {

    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");

    private JButton menuButton = new CardChoosingButton("Menu", UserGuidepostPanel.class);
    private JButton makeReservationButton = new JButton("Make reservation");

    private List<JPanel> previews = new ArrayList<>();
    private List<JPanel> reservations = new ArrayList<>();

    private JPanel cards = new JPanel(new CardLayout());
    private CardLayout cardLayout;
    private RoomDAOImpl roomDAO = new RoomDAOImpl();
    private JPanel centerPanel;

    {
        setupComponents();
    }

    public RoomBrowserPanel() {
        super(new BorderLayout());
    }

    @Override
    public void setupComponents() {
        final JPanel bottomPanel = bottomMenu();
        JPanel topPanel = upperMenu();

        JPanel temp;
        for (Room room : roomDAO.getAll()) {
            temp = new RoomPreviewPanel(room);
            cards.add(temp, String.format("%d preview", room.getId()));
            previews.add(temp);

            temp = new RoomReservationPanel(room);
            cards.add(temp, String.format("%d reserv", room.getId()));
            reservations.add(temp);
        }
        cardLayout = (CardLayout) cards.getLayout();


        add(cards, BorderLayout.CENTER);

        nextButton.addActionListener(e -> cardLayout.next(cards));
        previousButton.addActionListener(e -> cardLayout.previous(cards));

    }

    private JPanel upperMenu() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(0, 75));
        add(topPanel, BorderLayout.PAGE_START);
        topPanel.add(previousButton, BorderLayout.LINE_START);
        topPanel.add(nextButton, BorderLayout.LINE_END);
        topPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        return topPanel;
    }

    private JPanel bottomMenu() {
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(0, 75));
        add(bottomPanel, BorderLayout.PAGE_END);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        bottomPanel.add(menuButton, BorderLayout.LINE_START);
        bottomPanel.add(makeReservationButton, BorderLayout.LINE_END);

        makeReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        return bottomPanel;
    }


}
