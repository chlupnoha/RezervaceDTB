package gui.permission;

import javax.swing.*;

/**
 * Created by marek on 6.5.16.
 */
public abstract class PermissionConstraint {

    protected JLabel errorLabel;

    public PermissionConstraint(JLabel errorLabel) {
        this.errorLabel = errorLabel;
    }

    public PermissionConstraint() {
    }

    public abstract boolean isOk();

    public JLabel getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(JLabel errorLabel) {
        this.errorLabel = errorLabel;
    }
}
