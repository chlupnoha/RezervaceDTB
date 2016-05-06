package gui.permission;

import javax.swing.*;

/**
 * Created by marek on 6.5.16.
 */
public class AdminLoginConstraint extends PermissionConstraint {

    private JTextField userNameTextField;
    private JPasswordField passwordTextField;

    public AdminLoginConstraint(JLabel errorLabel, JTextField userNameTextField, JPasswordField passwordTextField) {
        super(errorLabel);
        this.userNameTextField = userNameTextField;
        this.passwordTextField = passwordTextField;
    }

    public AdminLoginConstraint(JTextField userNameTextField, JPasswordField passwordTextField) {
        this.userNameTextField = userNameTextField;
        this.passwordTextField = passwordTextField;
    }

    @Override
    public boolean isOk() {
        return true;
    }
}
