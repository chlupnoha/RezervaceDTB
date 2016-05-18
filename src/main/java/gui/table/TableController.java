package gui.table;

import gui.ManagedCard;
import gui.admin.AdminLoginPanel;
import gui.customcomponents.CardChoosingButton;

import javax.swing.*;
import java.awt.*;

public class TableController extends ManagedCard {

    private CardChoosingButton buildingImageButton = new CardChoosingButton("BUILDING_IMAGE Grid", BuildingImageTable.class);
    private CardChoosingButton buildingButton = new CardChoosingButton("BUILDING data Grid", BuildingTable.class);
    private CardChoosingButton imageButton = new CardChoosingButton("IMAGE data Grid", ImageTable.class);
    private CardChoosingButton rezervationButton = new CardChoosingButton("REZERVATION data Grid", RezervationTable.class);
    private CardChoosingButton tag = new CardChoosingButton("TAG data Grid", TagTable.class);
    private CardChoosingButton userButton = new CardChoosingButton("USER data Grid", UsersTable.class);
    private CardChoosingButton backButton = new CardChoosingButton("BACK", AdminLoginPanel.class);


    {
        setupComponents();
    }


    public TableController() {
        super(new BorderLayout());
        JPanel p = new JPanel();
        p.add(backButton);
        p.add(userButton);
        p.add(buildingImageButton);
        p.add(buildingButton);
        p.add(imageButton);
        p.add(rezervationButton);
        p.add(tag);
        add(p, BorderLayout.PAGE_END);
    }

    @Override
    public void setupComponents() {
    }
}
