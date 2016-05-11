package gui.customcomponents;

import model.Equipment;
import model.Room;
import model.Tag;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marek on 8.5.16.
 */
public class RoomPreviewPanel extends JPanel {

    private ImagePanel imagePanel;

    private Room room;

    public RoomPreviewPanel(Room room) {
        super(new BorderLayout());
        this.room = room;
        imagePanel = new ImagePanel(room.getImages(), 400, 300);
        setup();
    }

    public void setup() {


        JPanel mainPanel = new JPanel(new GridLayout(0, 2));
        add(mainPanel, BorderLayout.PAGE_START);

        mainPanel.setPreferredSize(new Dimension(0, 350));

        JPanel desriptionPanel = new JPanel(new GridLayout(6, 2));

        imagePanel.setPreferredSize(new Dimension(400, 300));
        mainPanel.add(imagePanel, BorderLayout.LINE_START);
        mainPanel.add(desriptionPanel, BorderLayout.LINE_END);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        desriptionPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel roomName = new JLabel(String.valueOf("Room #" + room.getId()));
        desriptionPanel.add(roomName);


        StringBuilder st = new StringBuilder();
        int i = room.getTags().size();
        for (Tag tag : room.getTags()) {
            st.append(tag.getName());
            i--;
            if (i != 0) {
                st.append(", ");
            }
        }
        ListEnumPanel tagsDataLabel = new ListEnumPanel("Tags:", st.toString());

        desriptionPanel.add(tagsDataLabel);

        st = new StringBuilder();
        i = room.getEquipment().size();
        for (Equipment eq : room.getEquipment()) {
            st.append(eq.getName());
            i--;
            if (i != 0) {
                st.append(", ");
            }
        }

        ListEnumPanel equipmentDataLabel = new ListEnumPanel("Equipment:", st.toString());
        desriptionPanel.add(equipmentDataLabel);


    }

}
