package gui;

import gui.user.UserLoginPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 4.5.16.
 */
public class BookingSystemFrame implements Runnable {

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
    public static void main(String[] args) {
        new BookingSystemFrame().run();
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        CardManager.getIntance().switchCard(UserLoginPanel.class);
        frame.setContentPane(CardManager.getIntance().getCardsPanel());

        frame.setPreferredSize(new Dimension(800, 500));
        frame.setLocationRelativeTo(null);

        frame.pack();
    }

}
