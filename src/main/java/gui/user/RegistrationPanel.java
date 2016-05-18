package gui.user;

import gui.ManagedCard;
import gui.admin.AdminLoginPanel;
import gui.customcomponents.CardChoosingButton;
import gui.customcomponents.ErrorLabel;
import gui.permission.RegistrationConstraint;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 4.5.16.
 */
public class RegistrationPanel extends ManagedCard {

    private final ErrorLabel errorLabel = new ErrorLabel();
    private JLabel introductoryLabel = new JLabel("Booking Service v1.0");
    private final JLabel userNameLabel = new JLabel("Username");
    private final JTextField userNameTextField = new JTextField(10);
    private final JLabel passwordLabel = new JLabel("Passowrd");
    private final JPasswordField passwordTextField = new JPasswordField(10);
    private final JLabel passwordAgainLabel = new JLabel("Passowrd again:");
    private final JPasswordField passwordAgainTextField = new JPasswordField(10);
    private final CardChoosingButton proceedButton = new CardChoosingButton("Register!", UserLoginPanel.class, new RegistrationConstraint(userNameTextField, passwordTextField, passwordAgainTextField));
    private final CardChoosingButton adminButton = new CardChoosingButton("Admin", AdminLoginPanel.class);
    private final CardChoosingButton registrationButton = new CardChoosingButton("Login", UserLoginPanel.class);

    {
        setupComponents();
    }

    public RegistrationPanel() {
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

        JPanel panCenterTopBottom = new JPanel(new BorderLayout());

        panCenterTopBottom.setPreferredSize(new Dimension(0, 50));
        panMainTop.setPreferredSize(new Dimension(0, 50));
        panMainBottom.setPreferredSize(new Dimension(0, 50));

        add(panLeft, BorderLayout.WEST);
        add(panRight, BorderLayout.EAST);
        add(panCenter, BorderLayout.CENTER);

        panCenter.add(panCenterTop, BorderLayout.PAGE_START);
        panCenterTop.add(panCenterTopBottom, BorderLayout.PAGE_END);


        panCenter.add(panCenterCenter, BorderLayout.CENTER);
        panCenter.add(panCenterBottom, BorderLayout.PAGE_END);

        panCenterCenter.add(panMainTop, BorderLayout.NORTH);
        panCenterCenter.add(panMainBottom, BorderLayout.CENTER);

        panCenterTopBottom.add(userNameLabel, BorderLayout.NORTH);
        panCenterTopBottom.add(userNameTextField, BorderLayout.CENTER);


        panMainTop.add(passwordLabel, BorderLayout.NORTH);
        panMainTop.add(passwordTextField, BorderLayout.CENTER);
        panMainBottom.add(passwordAgainLabel, BorderLayout.NORTH);
        panMainBottom.add(passwordAgainTextField, BorderLayout.CENTER);

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
