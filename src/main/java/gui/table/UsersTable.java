package gui.table;

import dao.UserDAOImpl;
import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;
import gui.model_forms.UserForm;
import gui.permission.DeleteConstraint;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UsersTable extends ManagedCard {

    public UsersTable() {
        super(new BorderLayout());

//        DataProvider dataProvider = new DataProvider();
//        dataProvider.fillDatabase();

        UserDAOImpl userDao = new UserDAOImpl();
        List<User> allUsers = userDao.getAll();

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(400, 200));
        table.setFillsViewportHeight(true);

        // Create a couple of columns
        model.addColumn("ID");
        model.addColumn("EMAIL");
        model.addColumn("ROLE");
        model.addColumn("DELETE");
        model.addColumn("UDPATE");

        // Append a row
        allUsers.stream().forEach((u) -> {
            model.addRow(new Object[]{u.getId(), u.getEmail(), u.getRole().toString(), "DELETE", "UPDATE"});
            userDao.delete(u.getId());
        });
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();
                int column = target.getSelectedColumn();
                // do some action if appropriate column
                System.out.println(row + " no shit " + column + ", and value: " + target.getValueAt(row, column));

                Long id = (Long) table.getValueAt(row, 0);
                System.out.println("ID of selected row is " + id);

                if (column == 3) {
                    //delete

                    new CardChoosingButton("", UsersTable.class, new DeleteConstraint()).invoke(); /// kamo, uprav DeleteConstraint a je to... tadle vec funguje svym zpusobem jako refresh
                } else if (column == 4) {
                    //update

                    new CardChoosingButton("", UserForm.class).invoke();                /// UUUUSE FOR REDIRECT TO ANOTHER FORM, narvi vlastni tridu na update, bude podobna jako ADD

                }

            }
        });


        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);


        //Add the scroll pane to this panel.
        add(scrollPane, BorderLayout.CENTER);
        add(new CardChoosingButton("ADD NEW", UserForm.class), BorderLayout.PAGE_END);      // REDIRECT TO:    UserForm
    }

    @Override
    public void setupComponents() {

    }
}

