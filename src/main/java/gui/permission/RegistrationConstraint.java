package gui.permission;

import gui.BookingSystemFrame;
import gui.customcomponents.ErrorLabel;

import javax.swing.*;

/**
 * Created by marek on 6.5.16.
 */
public class RegistrationConstraint extends PermissionConstraint {

    private final JTextField userNameTextField;
    private final JPasswordField passwordTextField;
    private final JPasswordField passwordAgainTextField;

    public RegistrationConstraint(ErrorLabel errorLabel, JTextField userNameTextField, JPasswordField passwordTextField, JPasswordField passwordAgainTextField) {
        super(errorLabel);
        this.userNameTextField = userNameTextField;
        this.passwordTextField = passwordTextField;
        this.passwordAgainTextField = passwordAgainTextField;
    }

    public RegistrationConstraint(JTextField userNameTextField, JPasswordField passwordTextField, JPasswordField passwordAgainTextField) {
        this.userNameTextField = userNameTextField;
        this.passwordTextField = passwordTextField;
        this.passwordAgainTextField = passwordAgainTextField;
    }

    @Override
    public boolean isOk() {

        JOptionPane.showMessageDialog(BookingSystemFrame.getInstance().getFrame(),
                "You're successfully registered with username: !");
        return true;
    }
}
