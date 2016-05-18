package gui.permission;

import dao.UserDAOImpl;

/**
 * Created by marek on 18.5.16.
 */
public class UserDeleteConstraint extends PermissionConstraint {
    
    private final long ElementId;

    public UserDeleteConstraint(long ElementId) {
        this.ElementId = ElementId;
    }    
    
    @Override
    public boolean isOk() {
        UserDAOImpl dao = new UserDAOImpl();
        dao.delete(ElementId);
        return true;
    }
}
