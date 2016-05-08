package gui.user;

import dao.RoomDAOImpl;
import gui.ManagedCard;
import gui.customcomponents.RoomPreviewPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 8.5.16.
 */
public class RoomBrowserPanel extends ManagedCard {


    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");
    private JButton menuButton = new JButton("Menu");
    private JButton logoutButton = new JButton("Make reservation");

    private JPanel cards;
    private CardLayout cardLayout;

    {
        setupComponents();
    }

    public RoomBrowserPanel() {
        super(new BorderLayout());
        //this.cards = new JPanel(new CardLayout());
        //cardLayout = (CardLayout) cards.getLayout();

        //RoomDAOImpl roomDAO = new RoomDAOImpl();
    }

    @Override
    public void setupComponents() {
        JPanel topPanel = upperMenu();
        JPanel bottomPanel = bottomMenu();

        RoomDAOImpl roomDAO = new RoomDAOImpl();

        JPanel centerPanel = new RoomPreviewPanel(roomDAO.getAll().get(0));
        add(centerPanel, BorderLayout.CENTER);


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
