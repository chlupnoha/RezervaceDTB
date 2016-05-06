package gui.customcomponents;

import gui.CardManager;
import gui.ManagedCard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marek on 4.5.16.
 */
public class CardChoosingButton extends JButton {

    private final Class<? extends ManagedCard> c;

    public CardChoosingButton(String text, Class<? extends ManagedCard> c) {
        super(text);
        this.c = c;

        this.addActionListener(new ButtonActionListener());
    }

    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardManager.getIntance().switchCard(c);
        }
    }

}
