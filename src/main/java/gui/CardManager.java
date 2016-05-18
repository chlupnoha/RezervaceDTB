package gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marek on 4.5.16.
 */
public class CardManager {

    private static CardManager instance;

    private Map<String, ManagedCard> cachedClasses = new HashMap<>();

    private JPanel cards;
    private CardLayout cardLayout;

    private CardManager() {
        super();
        this.cards = new JPanel(new CardLayout());
        cardLayout = (CardLayout) cards.getLayout();
    }

    public static CardManager getIntance() {
        if (instance == null) {
            instance = new CardManager();
            return instance;
        }
        return instance;
    }

    public JPanel getCardsPanel() {
        return cards;
    }

    public final void setFirstCard(String cardName) {
        cardLayout.show(cards, cardName);
    }

    public final void switchCard(Class<? extends ManagedCard> c, boolean refresh) {
        if (!cachedClasses.containsKey(c.getName()) || refresh) {
            try {
                ManagedCard card = c.newInstance();
                cards.add(card, c.getName());
                cachedClasses.put(c.getName(), card);
                System.out.println("add " + c.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cardLayout.show(cards, c.getName());
    }

}
