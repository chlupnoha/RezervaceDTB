/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import model.Equipment;
import java.util.List;

/**
 * Data Access Object 
 */
public interface EquipmentDAO {
    
    Equipment getEquipmentByID(Integer equipmentId);

    Equipment addEquipment(Equipment equipment);

    Equipment updateEquipment(Equipment equipment);

    boolean deleteEquipment(int equipmentId);
    
    List<Equipment> getAllEquipments();

}
