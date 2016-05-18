package gui.customcomponents;

import gui.CardManager;
import gui.ManagedCard;
import gui.permission.PermissionConstraint;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marek on 4.5.16.
 */
public class CardChoosingButton extends JButton {

    private final Class<? extends ManagedCard> c;
    private final ButtonActionListener buttonListener;
    private PermissionConstraint constraint;


    public CardChoosingButton(String text, Class<? extends ManagedCard> c) {
        super(text);
        this.c = c;
        this.buttonListener = new ButtonActionListener();
        this.addActionListener(buttonListener);
    }

    public CardChoosingButton(String text, Class<? extends ManagedCard> c, PermissionConstraint constraint) {
        super(text);
        this.c = c;
        this.constraint = constraint;
        this.buttonListener = new ButtonActionListener();
        this.addActionListener(buttonListener);
    }

    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ((constraint != null && constraint.isOk()) || constraint == null) {
                CardManager.getIntance().switchCard(c);
            }
        }
    }
    public void invoke() {
        buttonListener.actionPerformed(null);
    }


}
