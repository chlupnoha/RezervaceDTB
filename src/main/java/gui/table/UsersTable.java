package gui.table;

import dao.UserDAOImpl;
import dataProvider.DataProvider;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.User;

public class UsersTable extends JPanel {

    public UsersTable() {
        super(new GridLayout(1, 0));
        
        DataProvider dataProvider = new DataProvider();
        dataProvider.fillDatabase();        

        UserDAOImpl userDao = new UserDAOImpl();
        List<User> allUsers = userDao.getAll();

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(800, 200));
        table.setFillsViewportHeight(true);

        // Create a couple of columns 
        model.addColumn("ID");
        model.addColumn("EMAIL");
        model.addColumn("ROLE");

        // Append a row
        allUsers.stream().forEach((u) -> {
            model.addRow(new Object[]{u.getId(), u.getEmail(), u.getRole().toString()});
        });

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        UsersTable newContentPane = new UsersTable();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
