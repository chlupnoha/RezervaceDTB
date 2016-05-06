package gui.permission;

import dao_impl.UserDAOImpl;
import gui.BookingSystemFrame;
import gui.customcomponents.ErrorLabel;

import javax.swing.*;

/**
 * Created by marek on 6.5.16.
 */
public class RegistrationConstraint extends PermissionConstraint {

    private JTextField userNameTextField;
    private JPasswordField passwordTextField;
    private JPasswordField passwordAgainTextField;

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
        UserDAOImpl userDAO = new UserDAOImpl();


        JOptionPane.showMessageDialog(BookingSystemFrame.getInstance().getFrame(),
                "You're succesfully registred with username: !");
        return true;
    }
}
