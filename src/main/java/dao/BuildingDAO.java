/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import model.Building;
import java.util.List;

/**
 * Data Access Object 
 */
public interface BuildingDAO {
    
    Building getBuildingByID(Integer buildingId);

    Building addBuilding(Building building);

    Building updateBuilding(Building building);

    boolean deleteBuilding(int buildingId);
    
    List<Building> getAllBuildings();

}
