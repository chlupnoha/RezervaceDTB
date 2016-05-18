package gui.model_forms;



import dao.UserDAOImpl;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.User;
import model.UserRole;

public class UserForm extends JPanel {

    private JTextField[] fields;
    private JCheckBox admin;

    // Create a form with the specified labels, tooltips, and sizes.
    public UserForm(String[] labels) {
        super(new BorderLayout());
        JPanel labelPanel = new JPanel(new GridLayout(labels.length+1, 1));
        JPanel fieldPanel = new JPanel(new GridLayout(labels.length+1, 1));
        add(labelPanel, BorderLayout.WEST);
        add(fieldPanel, BorderLayout.CENTER);
        fields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i += 1) {
            fields[i] = new JTextField();

            fields[i].setColumns(15);

            JLabel lab = new JLabel(labels[i], JLabel.RIGHT);
            lab.setLabelFor(fields[i]);

            labelPanel.add(lab);
            JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p.add(fields[i]);
            fieldPanel.add(p);
        }
            admin = new JCheckBox("Admin");
            JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p.add(admin);
            fieldPanel.add(p);
    }

    public String getText(int i) {
        return (fields[i].getText());
    }

    public Boolean getAdmin() {
        return (admin.isSelected());
    }


    public static void main(String[] args) {
        String[] labels = {"Email", "Password", "Password again"};

        //char[] mnemonics = { 'F', 'M', 'L', 'A' };
        //int[] widths = { 15, 1, 15, 3 };
        //String[] descs = { "First Name", "Middle Initial", "Last Name", "Age" };
        final UserForm form = new UserForm(labels);

        JButton submit = new JButton("Submit Form");

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(form.getText(0) + " " + form.getText(1) + ". " + form.getText(2) + form.getAdmin() );
                UserDAOImpl userDao = new UserDAOImpl();
                if(form.getText(01).equals(form.getText(2))){
                    UserRole role = form.getAdmin() ? UserRole.ADMIN : UserRole.GUEST;
                    userDao.add(new User(form.getText(0), form.getText(1), role));
                    System.out.println("USER ADDED" );
                }else{
                    System.out.println("Not same password" );
                }
            }
        });

        JFrame f = new JFrame("Text Form Example");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);
        JPanel p = new JPanel();
        p.add(submit);
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }
}
