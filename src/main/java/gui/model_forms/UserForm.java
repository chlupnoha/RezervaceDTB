package gui.model_forms;

/**
 *
 * @author chlupnoha
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserForm extends JPanel {

    //private JTextField[] fields;
    private JTextField email;

    private JTextField password;

    private JTextField passwordAgain;

//    private final JButton submit = new JButton("Submit Form");

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getPasswordAgain() {
        return passwordAgain.getText();
    }

    // Create a form with the specified labels, tooltips, and sizes.
    public UserForm() {
        super(new BorderLayout());
        JPanel labelPanel = new JPanel(new GridLayout(3, 1));
        JPanel fieldPanel = new JPanel(new GridLayout(3, 1));
        add(labelPanel, BorderLayout.WEST);
        add(fieldPanel, BorderLayout.CENTER);

        initField(email, labelPanel, fieldPanel);
        initField(password, labelPanel, fieldPanel);
        initField(passwordAgain, labelPanel, fieldPanel);
    }

    private void initField(JTextField field, JPanel labelPanel, JPanel fieldPanel) {

        field = new JTextField();

        field.setColumns(15);

        JLabel lab = new JLabel("Email", JLabel.RIGHT);
        lab.setLabelFor(field);

        labelPanel.add(lab);
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(field);
        fieldPanel.add(p);

    }

    
    

    public static void main(String[] args) {
        final UserForm form = new UserForm();

        JButton submit = new JButton("Submit Form");

        submit.addActionListener((ActionEvent e) -> {
//            System.out.println(form.getText());
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
