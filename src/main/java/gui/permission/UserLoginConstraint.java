package gui.permission;

import gui.customcomponents.ErrorLabel;

import javax.swing.*;

/**
 * Created by marek on 6.5.16.
 */
public class UserLoginConstraint extends PermissionConstraint {

    private JTextField userNameTextField;
    private JPasswordField passwordTextField;


    public UserLoginConstraint(ErrorLabel errorLabel, JTextField userNameTextField, JPasswordField passwordTextField) {
        super(errorLabel);
        this.userNameTextField = userNameTextField;
        this.passwordTextField = passwordTextField;
    }

    public UserLoginConstraint(JTextField userNameTextField, JPasswordField passwordTextField) {
        this.userNameTextField = userNameTextField;
        this.passwordTextField = passwordTextField;
    }

    @Override
    public boolean isOk() {
        //errorLabel.setText("NO SHIT MAN");
        return true;
    }
}
