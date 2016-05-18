package gui.user;

import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 4.5.16.
 */
public class UserGuidepostPanel extends ManagedCard {
    private JLabel introductoryLabel = new JLabel("Booking Service v1.0");
    private JButton browseRoomsButton = new CardChoosingButton("Browse rooms", RoomBrowserPanel.class);
    private JButton browseReservationsButton = new CardChoosingButton("Browse reservations", ReservationManagementPanel.class);
    private JButton changePasswordButton = new JButton("Change passowrd");
    private CardChoosingButton adminButton = new CardChoosingButton("Logout", UserLoginPanel.class);
    private CardChoosingButton registrationButton = new CardChoosingButton("Menu", UserGuidepostPanel.class);

    {
        setupComponents();
    }

    public UserGuidepostPanel() {
        super(new BorderLayout());
    }

    @Override
    public void setupComponents() {
        JPanel panLeft = new JPanel(new BorderLayout());
        JPanel panRight = new JPanel(new BorderLayout());
        JPanel panCenter = new JPanel(new BorderLayout());

        panLeft.setPreferredSize(new Dimension(250, 0));
        panRight.setPreferredSize(new Dimension(250, 0));
        panCenter.setPreferredSize(new Dimension(300, 0));

        JPanel panCenterTop = new JPanel(new BorderLayout());
        JPanel panCenterBottom = new JPanel(new BorderLayout());
        JPanel panCenterCenter = new JPanel(new BorderLayout());

        panCenterTop.setPreferredSize(new Dimension(0, 200));
        panCenterCenter.setPreferredSize(new Dimension(0, 100));
        panCenterBottom.setPreferredSize(new Dimension(0, 200));

        JPanel panMainTop = new JPanel(new BorderLayout());
        JPanel panMainBottom = new JPanel(new BorderLayout());

        panMainTop.setPreferredSize(new Dimension(0, 50));
        panMainBottom.setPreferredSize(new Dimension(0, 50));

        add(panLeft, BorderLayout.WEST);
        add(panRight, BorderLayout.EAST);
        add(panCenter, BorderLayout.CENTER);

        panCenter.add(panCenterTop, BorderLayout.PAGE_START);
        panCenterTop.setBorder(BorderFactory.createEmptyBorder(2, 70, 15, 15));
        panCenterTop.add(introductoryLabel, BorderLayout.PAGE_END);


        panCenter.add(panCenterCenter, BorderLayout.CENTER);
        panCenter.add(panCenterBottom, BorderLayout.PAGE_END);

        panCenterCenter.add(panMainTop, BorderLayout.NORTH);
        panCenterCenter.add(panMainBottom, BorderLayout.CENTER);

        panMainTop.add(browseRoomsButton, BorderLayout.CENTER);
        panMainBottom.add(browseReservationsButton, BorderLayout.NORTH);
        panMainBottom.add(changePasswordButton, BorderLayout.CENTER);

        panLeft.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panRight.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panLeft.add(registrationButton, BorderLayout.PAGE_END);
        panRight.add(adminButton, BorderLayout.PAGE_END);
    }

}
