package gui.table;

import dao.UserDAOImpl;
import dataProvider.DataProvider;
import model.User;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UsersTable extends JPanel {

    public UsersTable() {
        super(new GridLayout(0, 4));

        DataProvider dataProvider = new DataProvider();
        dataProvider.fillDatabase();

        UserDAOImpl userDao = new UserDAOImpl();
        List<User> allUsers = userDao.getAll();

        class AddListeneser implements ActionListener {

            Long id;

            public AddListeneser(Long id) {
                this.id = id;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                UserDAOImpl u = new UserDAOImpl();

                // muzeme pracovat s ID
                // BLA BLA BLA
            }
        }


        allUsers.stream().forEach((u) -> {
            add(new JLabel(u.getId().toString()));
            add(new JLabel(u.getEmail().toString()));
            add(new JLabel(u.getRole().toString()));
            JButton j = new JButton("delete");
            j.addActionListener(new AddListeneser(u.getId()));
            add(j);
        });


        // Append a row

        //table.getColumn("Button").setCellRenderer(new ButtonRenderer());
        //table.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
        //Create the scroll pane and add the table to it.
        //JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        //add(scrollPane);
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


class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            JOptionPane.showMessageDialog(button, label + ": Ouch!");
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}