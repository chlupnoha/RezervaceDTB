package gui.customcomponents;

import model.Room;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 8.5.16.
 */
public class RoomPreviewPanel extends JPanel {

    private ImagePanel imagePanel;

    private Room room;

    public RoomPreviewPanel(Room room) {
        super(new GridLayout(0, 2));
        this.room = room;
        imagePanel = new ImagePanel(room.getImages(), 400, 300);
        setup();
    }

    public void setup() {


        setPreferredSize(new Dimension(0, 350));

        JPanel desriptionPanel = new JPanel(new GridLayout(6, 2));

        imagePanel.setPreferredSize(new Dimension(400, 300));
        add(imagePanel, BorderLayout.LINE_START);
        add(desriptionPanel, BorderLayout.LINE_END);
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        desriptionPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel roomName = new JLabel("Room #1");
        desriptionPanel.add(roomName);

        JLabel tagsLabel = new JLabel("");
        desriptionPanel.add(tagsLabel);
        ListEnumPanel tagsDataLabel = new ListEnumPanel("Tags:", "#nice_view #big #terrace");
        desriptionPanel.add(tagsDataLabel);

        ListEnumPanel equipmentDataLabel = new ListEnumPanel("Equipment:", "TV, double bed, bath room, kitchen, kitchen, kitchen");
        desriptionPanel.add(equipmentDataLabel);


    }
}
