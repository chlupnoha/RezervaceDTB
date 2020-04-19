package gui.customcomponents;

/**
 * Created by marek on 8.5.16.
 */

import model.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Set;

public class ImagePanel extends JPanel {

    private final PriorityQueue<BufferedImage> bufferedImageQueue = new PriorityQueue<>();
    private BufferedImage image;
    private final int width;
    private final int height;

    public ImagePanel(Set<Image> images, int width, int height) {
        this.width = 400;
        this.height = height;

        try {
            //System.out.println(images.size());
            for (Image image : images) {
                //System.out.println(image.getName());
                bufferedImageQueue.add(ImageIO.read(new File("images/" + image.getName() + ".jpg")));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (!bufferedImageQueue.isEmpty()) {
            image = bufferedImageQueue.remove();
        }

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bufferedImageQueue.add(image);
                image = bufferedImageQueue.remove();
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    private void setImage(BufferedImage bufferedImage) {
        this.image = bufferedImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, width, height, null);
        } else {
            System.out.println("THERE HAS BEEN A PROBLEM");
        }

    }


}