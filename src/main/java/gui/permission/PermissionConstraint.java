package gui.permission;

import javax.swing.*;

/**
 * Created by marek on 6.5.16.
 */
public interface PermissionConstraint {


    boolean isOk();

    void setErrorLabel(JLabel errorLabel);
}
