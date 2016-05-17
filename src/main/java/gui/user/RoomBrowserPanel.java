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
import java.util.LinkedList;

/**
 * Created by marek on 8.5.16.
 */
public class RoomBrowserPanel extends ManagedCard {

    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");

    private JButton menuButton = new CardChoosingButton("Menu", UserGuidepostPanel.class);
    private JButton makeReservationButton = new JButton("Make reservation");

    private LinkedList<RoomPreviewPanel> previews = new LinkedList<>();
    private LinkedList<JPanel> reservations = new LinkedList<>();

    private boolean state = false;
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

        RoomPreviewPanel temp;
        RoomReservationPanel temp1;
        for (Room room : roomDAO.getAll()) {
            if (room != null) {
                System.out.println("NO SHIT MANNNNANDASND");
                System.out.println(room);
            }

            temp = new RoomPreviewPanel(room);
            cards.add(temp, String.format("%d preview", room.getId()));
            previews.add(temp);

            temp1 = new RoomReservationPanel(room);
            cards.add(temp1, String.format("%d reserv", room.getId()));
            reservations.add(temp1);
        }
        cardLayout = (CardLayout) cards.getLayout();


        add(cards, BorderLayout.CENTER);


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
                if (!state) {
                    if (!previews.isEmpty()) {
                        RoomPreviewPanel r = previews.peek();
                        cardLayout.show(cards, (r.getId() + " reserv"));

                        makeReservationButton.setText("Back");
                        nextButton.setEnabled(false);
                        previousButton.setEnabled(false);
                        state = true;
                    }
                } else {
                    RoomPreviewPanel r = previews.peek();
                    cardLayout.show(cards, (r.getId() + " preview"));

                    makeReservationButton.setText("Make reservation");
                    nextButton.setEnabled(true);
                    previousButton.setEnabled(true);
                    state = false;
                }


            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomPreviewPanel r = previews.poll();
                previews.add(r);

                JPanel r1 = reservations.poll();
                reservations.add(r1);

                cardLayout.show(cards, (previews.peek().getId() + " preview"));
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomPreviewPanel r = previews.pollLast();
                previews.addFirst(r);

                JPanel r1 = reservations.pollLast();
                reservations.addFirst(r1);

                cardLayout.show(cards, (previews.peek().getId() + " preview"));
            }
        });
        return bottomPanel;
    }


}
