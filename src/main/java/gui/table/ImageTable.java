package gui.table;

import dao.ImageDAOImpl;
import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;
import model.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class ImageTable extends ManagedCard {

    private ImageDAOImpl imageDao = new ImageDAOImpl();

    public ImageTable() {
        super(new BorderLayout());

        List<Image> allUsers = imageDao.getAll();

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
        model.addColumn("ID");
        model.addColumn("NAME");
        
        // Append a row
        allUsers.stream().forEach((r) -> {
            model.addRow(new Object[]{
                r.getId(),
                r.getName()
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
