/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao_impl;

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
