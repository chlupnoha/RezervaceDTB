package gui.table;

import dao.UserDAOImpl;
import dataProvider.DataProvider;
import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;
import gui.model_forms.UserForm;
import gui.permission.UserDeleteConstraint;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TableController extends ManagedCard {
    
    private CardChoosingButton adminButton = new CardChoosingButton("Go to simple user data Grid", UsersTable.class);


    {
        setupComponents();
    }


    public TableController() {
        super(new BorderLayout());
//        JScrollPane scrollPane = new JScrollPane(table);
//        add(scrollPane, BorderLayout.CENTER);
        add(adminButton, BorderLayout.PAGE_END);
    }

    @Override
    public void setupComponents() {
    }
}
