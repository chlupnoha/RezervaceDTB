package gui.model_forms;


import dao.UserDAOImpl;
import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;
import gui.table.UsersTable;
import model.User;
import model.UserRole;

import javax.swing.*;
import java.awt.*;

public class UserForm extends ManagedCard {

    private final JTextField[] fields;
    private final JCheckBox admin;

    // Create a form with the specified labels, tooltips, and sizes.
    public UserForm() {
        super(new GridLayout(0, 2));
        String[] labels = {"Email", "Password", "Password again"};

        fields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i += 1) {
            add(new JLabel(labels[i]));
            add(fields[i] = new JTextField(15));
        }
        admin = new JCheckBox("Admin");
        add(admin);


        JButton submit = new JButton("Submit Form");

        submit.addActionListener(e -> {
            System.out.println(getText(0) + " " + getText(1) + ". " + getText(2) + getAdmin());
            UserDAOImpl userDao = new UserDAOImpl();
            if (getText(01).equals(getText(2))) {
                UserRole role = getAdmin() ? UserRole.ADMIN : UserRole.GUEST;
                userDao.add(new User(getText(0), getText(1), role));
                System.out.println("USER ADDED");

                //po pridani redirect na tabulku
                new CardChoosingButton("", UsersTable.class).invoke();
            } else {
                System.out.println("Not same password");
            }
        });

        add(submit);
        add(new CardChoosingButton("BACK", UsersTable.class), BorderLayout.PAGE_END);      // REDIRECT TO:    UserForm

    }

    public String getText(int i) {
        return (fields[i].getText());
    }

    public Boolean getAdmin() {
        return (admin.isSelected());
    }

    @Override
    public void setupComponents() {

    }
}
