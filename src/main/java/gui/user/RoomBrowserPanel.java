package gui.user;

import dao.RoomDAOImpl;
import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;
import gui.customcomponents.RoomPreviewPanel;
import model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marek on 8.5.16.
 */
public class RoomBrowserPanel extends ManagedCard {


    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");
    private JButton menuButton = new CardChoosingButton("Menu", UserGuidepostPanel.class);
    private JButton logoutButton = new CardChoosingButton("Make reservation", MakeReservationPanel.class);

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
        JPanel topPanel = upperMenu();
        final JPanel bottomPanel = bottomMenu();

        for (Room room : roomDAO.getAll()) {
            cards.add(new RoomPreviewPanel(room));
        }
        cardLayout = (CardLayout) cards.getLayout();


        add(cards, BorderLayout.CENTER);


        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cards);
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cards);
            }
        });
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
        bottomPanel.add(logoutButton, BorderLayout.LINE_END);
        return bottomPanel;
    }
}
