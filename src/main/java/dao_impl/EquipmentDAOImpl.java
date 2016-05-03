/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao_impl;

import dao.EquipmentDAO;
import java.util.List;
import java.util.logging.Logger;
import model.Equipment;
import org.hibernate.Session;

/**
 *
 * @author chlupnoha
 */
public class EquipmentDAOImpl extends CommonDAOImpl<Equipment> implements EquipmentDAO {

    private static final Logger LOG = Logger.getLogger(EquipmentDAOImpl.class.getName());

    public EquipmentDAOImpl() {
        this(null);
    }

    public EquipmentDAOImpl(Session session) {
        super(Equipment.class, session);
    }

    @Override
    public Equipment getEquipmentByID(Integer equipmentId) {
        return super.getEntityById(equipmentId);
    }

    @Override
    public Equipment addEquipment(Equipment equipment) {
        return super.addEntity(equipment);
    }

    @Override
    public Equipment updateEquipment(Equipment equipment) {
        return super.updateEntity(equipment);
    }

    @Override
    public boolean deleteEquipment(int equipmentId) {
        return super.deleteEntity(equipmentId);
    }

    @Override
    public List<Equipment> getAllEquipments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
