package gui.permission;

import javax.swing.*;

/**
 * Created by marek on 6.5.16.
 */
public class UserLoginConstraint implements PermissionConstraint {

    private JTextField userNameTextField;
    private JPasswordField passwordTextField;
    private JLabel errorLabel;

    public UserLoginConstraint(JTextField userNameTextField, JPasswordField passwordTextField) {
        this.userNameTextField = userNameTextField;
        this.passwordTextField = passwordTextField;
    }

    public UserLoginConstraint(JTextField userNameTextField, JPasswordField passwordTextField, JLabel errorLabel) {
        this.userNameTextField = userNameTextField;
        this.passwordTextField = passwordTextField;
        this.errorLabel = errorLabel;
    }

    @Override
    public boolean isOk() {
        return true;
    }

    @Override
    public void setErrorLabel(JLabel errorLabel) {
        this.errorLabel = errorLabel;
    }
}
