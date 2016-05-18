
package dao;

import model.Equipment;
import org.hibernate.Session;

import java.util.logging.Logger;

/**
 * @author chlupnoha
 */
public class EquipmentDAOImpl extends CommonDAOImpl<Equipment> {

    private static final Logger LOG = Logger.getLogger(EquipmentDAOImpl.class.getName());

    public EquipmentDAOImpl() {
        this(null);
    }

    public EquipmentDAOImpl(Session session) {
        super(Equipment.class, session);
    }


}
