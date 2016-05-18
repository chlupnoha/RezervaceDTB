package gui.permission;

import dao.UserDAOImpl;

/**
 * Created by marek on 18.5.16.
 */
public class UserUpdateConstraint extends PermissionConstraint {
    
    private final long ElementId;

    public UserUpdateConstraint(long ElementId) {
        this.ElementId = ElementId;
    }    
    
    @Override
    public boolean isOk() {
        UserDAOImpl dao = new UserDAOImpl();
        return dao.delete(ElementId);
    }
}
