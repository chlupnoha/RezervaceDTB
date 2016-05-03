/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao_impl;

import dao.BuildingDAO;
import java.util.List;
import java.util.logging.Logger;
import model.Building;
import org.hibernate.Session;

/**
 *
 * @author chlupnoha
 */
public class BuildingDAOImpl extends CommonDAOImpl<Building> implements BuildingDAO {

    private static final Logger LOG = Logger.getLogger(BuildingDAOImpl.class.getName());

    public BuildingDAOImpl() {
        this(null);
    }

    public BuildingDAOImpl(Session session) {
        super(Building.class, session);
    }

    @Override
    public Building getBuildingByID(Integer buildingId) {
        return super.getEntityById(buildingId);
    }

    @Override
    public Building addBuilding(Building building) {
        return super.addEntity(building);
    }

    @Override
    public Building updateBuilding(Building building) {
        return super.updateEntity(building);
    }

    @Override
    public boolean deleteBuilding(int buildingId) {
        return super.deleteEntity(buildingId);
    }

    @Override
    public List<Building> getAllBuildings() {
        return super.getAllEntities();
    }

    
}
