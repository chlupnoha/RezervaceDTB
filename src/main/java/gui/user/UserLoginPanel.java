package gui.user;

import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;
import gui.customcomponents.ErrorLabel;
import gui.permission.UserLoginConstraint;
import gui.table.UsersTable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 4.5.16.
 */
public class UserLoginPanel extends ManagedCard {
    private ErrorLabel errorLabel = new ErrorLabel();
    private JLabel introductoryLabel = new JLabel("Booking Service v1.0");
    private JLabel userNameLabel = new JLabel("Username");
    private JTextField userNameTextField = new JTextField(10);
    private JLabel passwordLabel = new JLabel("Passowrd");
    private JPasswordField passwordTextField = new JPasswordField(10);
    private CardChoosingButton proceedButton = new CardChoosingButton("Sign in!", UserGuidepostPanel.class, new UserLoginConstraint(errorLabel, userNameTextField, passwordTextField));
    private CardChoosingButton adminButton = new CardChoosingButton("Go to simple data APP", UsersTable.class);
    private CardChoosingButton registrationButton = new CardChoosingButton("Sign up!", RegistrationPanel.class);

    {
        setupComponents();
    }


    public UserLoginPanel() {
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

        panMainTop.add(userNameLabel, BorderLayout.NORTH);
        panMainTop.add(userNameTextField, BorderLayout.CENTER);
        panMainBottom.add(passwordLabel, BorderLayout.NORTH);
        panMainBottom.add(passwordTextField, BorderLayout.CENTER);

        JPanel panCenterBottomTop = new JPanel(new BorderLayout());
        panCenterBottom.add(panCenterBottomTop, BorderLayout.NORTH);

        panCenterBottomTop.setBorder(BorderFactory.createEmptyBorder(2, 15, 15, 15));
        panCenterBottomTop.add(proceedButton, BorderLayout.NORTH);
        panCenterBottomTop.add(errorLabel, BorderLayout.CENTER);


        panLeft.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panRight.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panLeft.add(registrationButton, BorderLayout.PAGE_END);
        panRight.add(adminButton, BorderLayout.PAGE_END);
    }
}

