package gui.table;

import dao.BuildingDAOImpl;
import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;
import model.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.Building;

public class BuildingImageTable extends ManagedCard {

    private BuildingDAOImpl buildingDao = new BuildingDAOImpl();

    public BuildingImageTable() {
        super(new BorderLayout());

        List<Building> allBuilding = buildingDao.getAll();

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        ;
        };
        table.setPreferredScrollableViewportSize(new Dimension(400, 200));
        table.setFillsViewportHeight(true);

        // Create a couple of columns
        model.addColumn("BUILDING_ID + NAME");
        model.addColumn("IMAGE_ID + NAME");

        // Append a row
        allBuilding.stream().forEach((r) -> {
            r.getImages().stream().forEach((i) -> {
                model.addRow(new Object[]{
                    r.getId() + " " + r.getName(),
                    i.getId() + " " + i.getName()
                });
            });
        });
        

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane, BorderLayout.CENTER);

        JPanel p = new JPanel(new GridLayout(0, 1));
        //p.add(new CardChoosingButton("ADD NEW", UserForm.class));
        p.add(new CardChoosingButton("BACK", TableController.class));      // REDIRECT TO:    UserForm
        add(p, BorderLayout.PAGE_END);
    }

    @Override
    public void setupComponents() {

    }
}
