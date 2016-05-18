package gui.table;

import dao.ReservationDAOImp;
import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;
import gui.model_forms.UserForm;
import gui.permission.UserDeleteConstraint;
import model.Reservation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class RezervationTable extends ManagedCard {
    
    private ReservationDAOImp rezervationDao = new ReservationDAOImp();

    public RezervationTable() {
        super(new BorderLayout());

        rezervationDao = new ReservationDAOImp();
        List<Reservation> allUsers = rezervationDao.getAll();

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {                
                    return false;               
            };
        };
        table.setPreferredScrollableViewportSize(new Dimension(400, 200));
        table.setFillsViewportHeight(true);

        // Create a couple of columns
        model.addColumn("ID");
        model.addColumn("CONFIRMED");
        model.addColumn("CREATED");
        model.addColumn("FROM_DATE");
        model.addColumn("TO_DATE");
        model.addColumn("ROOM_ID");
        model.addColumn("USER_EMAIL");
//        model.addColumn("DELETE");
//        model.addColumn("UDPATE");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // Append a row
        allUsers.stream().forEach((r) -> {
            model.addRow(new Object[]{
                r.getId(), 
                r.getConfirmed(), 
                format.format(r.getCreated().getTime()), 
                format.format(r.getFromDate().getTime()), 
                format.format(r.getToDate().getTime()), 
                r.getRoom().getId(), 
                r.getUser().getEmail()});
        });
//        table.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                JTable target = (JTable) e.getSource();
//                int row = target.getSelectedRow();
//                int column = target.getSelectedColumn();
//                // do some action if appropriate column
//                System.out.println(row + " no shit " + column + ", and value: " + target.getValueAt(row, column));
//
//                Long id = (Long) table.getValueAt(row, 0);
//                System.out.println("ID of selected row is " + id);
//
//                if (column == 3) {
//                    new CardChoosingButton("", RezervationTable.class, new UserDeleteConstraint(id), true).invoke(); 
//                    
//                } else if (column == 4) {
//                    //tady staci, kdyz upravi ty data v tabulce ;)
//                    User u = userDao.getById(id);
//                    u.setEmail(table.getValueAt(row, 1).toString());
//                    userDao.update(u);
//                    new CardChoosingButton("", RezervationTable.class, true).invoke(); 
//                }
//
//            }
//        });

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
