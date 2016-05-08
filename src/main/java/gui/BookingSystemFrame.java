package gui;

import gui.user.RoomBrowserPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 4.5.16.
 */
public class BookingSystemFrame implements Runnable {

    private static BookingSystemFrame instance;
    private JFrame frame;

    private BookingSystemFrame() {
    }

    public static BookingSystemFrame getInstance() {
        if (instance == null) {
            instance = new BookingSystemFrame();
        }
        return instance;
    }

    public JFrame getFrame() {
        return frame;
    }

    /*
            * login - admin
            *   add room
            *   browse rooms
            *   browse reservations
            *   change password
            *
            *
            * login - user
            *   browse rooms
            *   browse reservations
            *   change password
            *
            *
            * */
    @Override
    public void run() {
        frame = new JFrame("Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        CardManager.getIntance().switchCard(RoomBrowserPanel.class);
        frame.setContentPane(CardManager.getIntance().getCardsPanel());

        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setLocationRelativeTo(null);

        frame.pack();
    }

}
