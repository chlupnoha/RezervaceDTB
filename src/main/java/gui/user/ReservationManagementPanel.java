package gui.user;

import dao.RezervationDAOImp;
import dao.RoomDAOImpl;
import dao.UserDAOImpl;
import gui.ManagedCard;
import gui.customcomponents.CardChoosingButton;
import model.Reservation;
import utility.Authorization;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

/**
 * Created by marek on 18.5.16.
 */
public class ReservationManagementPanel extends ManagedCard {
    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");

    private JButton menuButton = new CardChoosingButton("Menu", UserGuidepostPanel.class);
    private JButton makeReservationButton = new JButton("Make reservation");

    {
        setupComponents();
    }

    public ReservationManagementPanel() {
        super(new BorderLayout());
    }

    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    @Override
    public void setupComponents() {
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        RezervationDAOImp rezervationDAOImp = new RezervationDAOImp();


        final JPanel bottomPanel = bottomMenu();
        JPanel topPanel = upperMenu();

        JPanel panel = new JPanel(new SpringLayout());
        JPanel centerPanel = new JPanel(null);
        panel.add(new JLabel("Reservation ID"));
        panel.add(new JLabel("Room"));
        panel.add(new JLabel("Date from"));
        panel.add(new JLabel("Date to"));
        panel.add(new JLabel("Delete"));

        CardChoosingButton button;
        if (Authorization.getUser() == null) {
            System.out.println("NO SHIT MAN");
        }
        for (Reservation r : Authorization.getUser().getReservations()) {
            panel.add(new JLabel(String.valueOf(r.getId())));
            panel.add(new JLabel(String.valueOf(r.getRoom().getId())));

            int year = r.getFromDate().get(Calendar.YEAR);
            int month = r.getFromDate().get(Calendar.MONTH);
            int day = r.getFromDate().get(Calendar.DAY_OF_MONTH);
            panel.add(new JLabel((String.format("%d/%d/%d", day, month, year))));

            year = r.getToDate().get(Calendar.YEAR);
            month = r.getToDate().get(Calendar.MONTH);
            day = r.getToDate().get(Calendar.DAY_OF_MONTH);
            panel.add(new JLabel((String.format("%d/%d/%d", day, month, year))));

            button = new CardChoosingButton("DELETE", ReservationManagementPanel.class, true);
            button.addActionListener(e -> {
                Authorization.getUser().getReservations().remove(r);
                new UserDAOImpl().update(Authorization.getUser());
            });
            panel.add(button);

        }
        // Lay out the panel.
        SpringUtilities.makeGrid(panel, Authorization.getUser().getReservations().size() + 1, 5, // rows, cols
                50, 0, // initialX, initialY
                15, 15);// xPad, yPad
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 10, 960, 325);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);


        for (Reservation r : Authorization.getUser().getReservations()) {
            //          centerPanel.add(new JLabel("# " + r.getRoom().getId()));
            //centerPanel.add(new JLabel("# " + r.getFromDate()));
            //centerPanel.add(new JLabel("# " + r.getToDate()));
            //        centerPanel.add(new JButton("delete"));

        }

        centerPanel.setPreferredSize(new Dimension(500, 400));
        centerPanel.add(scrollPane);
        //centerPanel.add(panel);
        add(centerPanel, BorderLayout.CENTER);
    }

    private JPanel upperMenu() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(0, 75));

        topPanel.add(previousButton, BorderLayout.LINE_START);
        topPanel.add(nextButton, BorderLayout.LINE_END);
        topPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        add(topPanel, BorderLayout.PAGE_START);
        return topPanel;
    }

    private JPanel bottomMenu() {
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(0, 75));

        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        bottomPanel.add(menuButton, BorderLayout.LINE_START);
        bottomPanel.add(makeReservationButton, BorderLayout.LINE_END);

        add(bottomPanel, BorderLayout.PAGE_END);
        return bottomPanel;
    }

    private static class SpringUtilities {
        /**
         * A debugging utility that prints to stdout the component's minimum,
         * preferred, and maximum sizes.
         */
        public static void printSizes(Component c) {
            System.out.println("minimumSize = " + c.getMinimumSize());
            System.out.println("preferredSize = " + c.getPreferredSize());
            System.out.println("maximumSize = " + c.getMaximumSize());
        }

        /**
         * Aligns the first <code>rows</code> * <code>cols</code> components of
         * <code>parent</code> in a grid. Each component is as big as the maximum
         * preferred width and height of the components. The parent is made just big
         * enough to fit them all.
         *
         * @param rows     number of rows
         * @param cols     number of columns
         * @param initialX x location to start the grid at
         * @param initialY y location to start the grid at
         * @param xPad     x padding between cells
         * @param yPad     y padding between cells
         */
        public static void makeGrid(Container parent, int rows, int cols, int initialX, int initialY,
                                    int xPad, int yPad) {
            SpringLayout layout;
            try {
                layout = (SpringLayout) parent.getLayout();
            } catch (ClassCastException exc) {
                System.err.println("The first argument to makeGrid must use SpringLayout.");
                return;
            }

            Spring xPadSpring = Spring.constant(xPad);
            Spring yPadSpring = Spring.constant(yPad);
            Spring initialXSpring = Spring.constant(initialX);
            Spring initialYSpring = Spring.constant(initialY);
            int max = rows * cols;

            // Calculate Springs that are the max of the width/height so that all
            // cells have the same size.
            Spring maxWidthSpring = layout.getConstraints(parent.getComponent(0)).getWidth();
            Spring maxHeightSpring = layout.getConstraints(parent.getComponent(0)).getWidth();
            for (int i = 1; i < max; i++) {
                SpringLayout.Constraints cons = layout.getConstraints(parent.getComponent(i));

                maxWidthSpring = Spring.max(maxWidthSpring, cons.getWidth());
                maxHeightSpring = Spring.max(maxHeightSpring, cons.getHeight());
            }

            // Apply the new width/height Spring. This forces all the
            // components to have the same size.
            for (int i = 0; i < max; i++) {
                SpringLayout.Constraints cons = layout.getConstraints(parent.getComponent(i));

                cons.setWidth(maxWidthSpring);
                cons.setHeight(maxHeightSpring);
            }

            // Then adjust the x/y constraints of all the cells so that they
            // are aligned in a grid.
            SpringLayout.Constraints lastCons = null;
            SpringLayout.Constraints lastRowCons = null;
            for (int i = 0; i < max; i++) {
                SpringLayout.Constraints cons = layout.getConstraints(parent.getComponent(i));
                if (i % cols == 0) { // start of new row
                    lastRowCons = lastCons;
                    cons.setX(initialXSpring);
                } else { // x position depends on previous component
                    cons.setX(Spring.sum(lastCons.getConstraint(SpringLayout.EAST), xPadSpring));
                }

                if (i / cols == 0) { // first row
                    cons.setY(initialYSpring);
                } else { // y position depends on previous row
                    cons.setY(Spring.sum(lastRowCons.getConstraint(SpringLayout.SOUTH), yPadSpring));
                }
                lastCons = cons;
            }

            // Set the parent's size.
            SpringLayout.Constraints pCons = layout.getConstraints(parent);
            pCons.setConstraint(SpringLayout.SOUTH, Spring.sum(Spring.constant(yPad), lastCons
                    .getConstraint(SpringLayout.SOUTH)));
            pCons.setConstraint(SpringLayout.EAST, Spring.sum(Spring.constant(xPad), lastCons
                    .getConstraint(SpringLayout.EAST)));
        }

        /* Used by makeCompactGrid. */
        private static SpringLayout.Constraints getConstraintsForCell(int row, int col, Container parent,
                                                                      int cols) {
            SpringLayout layout = (SpringLayout) parent.getLayout();
            Component c = parent.getComponent(row * cols + col);
            return layout.getConstraints(c);
        }

        /**
         * Aligns the first <code>rows</code> * <code>cols</code> components of
         * <code>parent</code> in a grid. Each component in a column is as wide as
         * the maximum preferred width of the components in that column; height is
         * similarly determined for each row. The parent is made just big enough to
         * fit them all.
         *
         * @param rows     number of rows
         * @param cols     number of columns
         * @param initialX x location to start the grid at
         * @param initialY y location to start the grid at
         * @param xPad     x padding between cells
         * @param yPad     y padding between cells
         */
        public static void makeCompactGrid(Container parent, int rows, int cols, int initialX,
                                           int initialY, int xPad, int yPad) {
            SpringLayout layout;
            try {
                layout = (SpringLayout) parent.getLayout();
            } catch (ClassCastException exc) {
                System.err.println("The first argument to makeCompactGrid must use SpringLayout.");
                return;
            }

            // Align all cells in each column and make them the same width.
            Spring x = Spring.constant(initialX);
            for (int c = 0; c < cols; c++) {
                Spring width = Spring.constant(0);
                for (int r = 0; r < rows; r++) {
                    width = Spring.max(width, getConstraintsForCell(r, c, parent, cols).getWidth());
                }
                for (int r = 0; r < rows; r++) {
                    SpringLayout.Constraints constraints = getConstraintsForCell(r, c, parent, cols);
                    constraints.setX(x);
                    constraints.setWidth(width);
                }
                x = Spring.sum(x, Spring.sum(width, Spring.constant(xPad)));
            }

            // Align all cells in each row and make them the same height.
            Spring y = Spring.constant(initialY);
            for (int r = 0; r < rows; r++) {
                Spring height = Spring.constant(0);
                for (int c = 0; c < cols; c++) {
                    height = Spring.max(height, getConstraintsForCell(r, c, parent, cols).getHeight());
                }
                for (int c = 0; c < cols; c++) {
                    SpringLayout.Constraints constraints = getConstraintsForCell(r, c, parent, cols);
                    constraints.setY(y);
                    constraints.setHeight(height);
                }
                y = Spring.sum(y, Spring.sum(height, Spring.constant(yPad)));
            }

            // Set the parent's size.
            SpringLayout.Constraints pCons = layout.getConstraints(parent);
            pCons.setConstraint(SpringLayout.SOUTH, y);
            pCons.setConstraint(SpringLayout.EAST, x);
        }
    }
}
