package gui.permission;

import gui.customcomponents.ErrorLabel;

/**
 * Created by marek on 6.5.16.
 */
public abstract class PermissionConstraint {

    protected ErrorLabel errorLabel;

    public PermissionConstraint(ErrorLabel errorLabel) {
        this.errorLabel = errorLabel;
    }

    public PermissionConstraint() {
    }

    public abstract boolean isOk();

    public ErrorLabel getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(ErrorLabel errorLabel) {
        this.errorLabel = errorLabel;
    }
}
