/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package rezervace;

import dao.*;
import dataProvider.DataProvider;
import gui.BookingSystemFrame;
import model.*;
import utility.Authorization;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    //Logger setup
    private static final Level LOG_LEVEL = Level.INFO;
    private static final String LOG_DIR = "log";
    private static final String LOG_NAME = String.format("%1$tF %1$tH-%1$tM-%1$tS.log", new Date());
    private static final int LOG_MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
    private static final int LOG_MAX_FILES_COUNT = 10;
    private static final boolean LOG_APPEND = false;

    private static final ImageDAOImpl imageDAO = new ImageDAOImpl();
    private static final TagDAOImpl tagDAO = new TagDAOImpl();
    private static final EquipmentDAOImpl equipmentDAO = new EquipmentDAOImpl();
    private static final RoomDAOImpl roomDAO = new RoomDAOImpl();


    /**
     * Run different methods according to first argument.
     *
     * @param args
     */
    public static void main(String[] args) {


        loggerSetup();
        deleteOldLogs();

        createIlustrationData();
        new DataProvider().fillDatabase();

        BookingSystemFrame.getInstance().run();
        try {
            Authorization.login("email@email.cz", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //tady pak View


    }

    private static void createIlustrationData() {

        try {
            User u1 = new User("email@email.cz", "password", "dfkjlas", UserRole.ADMIN);
            UserDAOImpl ruDAO = new UserDAOImpl();
            ruDAO.add(u1);

        } catch (Exception e) {
            System.out.println("User already added!");
        }
        addAnother();
        addAnother();


    }

    private static void addAnother() {

        Set<Tag> tags = new HashSet<>();
        Tag tag = new Tag();
        tag.setName("terrace");
        tags.add(tag);
        tagDAO.add(tag);
        Tag tag1 = new Tag();
        tag1.setName("big");
        tags.add(tag1);
        tagDAO.add(tag1);
        Tag tag2 = new Tag();
        tag2.setName("double_bed");
        tags.add(tag2);
        tagDAO.add(tag2);

        Set<Image> images = new HashSet<>();

        Image image = new Image();
        image.setName("image1");
        imageDAO.add(image);
        images.add(image);
        Image image1 = new Image();
        image1.setName("image2");
        imageDAO.add(image1);
        images.add(image1);

        Set<Equipment> equipment = new HashSet<>();

        Equipment e = new Equipment();
        e.setName("bath room");
        equipmentDAO.add(e);
        Equipment e1 = new Equipment();
        e1.setName("TV");
        equipmentDAO.add(e1);
        Equipment e2 = new Equipment();
        e2.setName("double_bed");
        equipmentDAO.add(e2);
        equipment.add(e);
        equipment.add(e1);
        equipment.add(e2);

        Room room = new Room();
        room.setTags(tags);
        room.setImages(images);
        room.setEquipment(equipment);
        roomDAO.add(room);
    }

    private static void loggerSetup() throws SecurityException {
        File logDir = new File(LOG_DIR);
        logDir.mkdirs();
        Logger.getLogger("").setLevel(LOG_LEVEL);
        try {
            Handler handler = new FileHandler(LOG_DIR + "/" + LOG_NAME, LOG_MAX_FILE_SIZE, 1, LOG_APPEND);
            Logger.getLogger("").addHandler(handler);
        } catch (IOException | SecurityException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        for (Handler handler : Logger.getLogger("").getHandlers()) {
            handler.setLevel(LOG_LEVEL);
        }
    }

    private static void deleteOldLogs() {
        File logDir = new File(LOG_DIR);
        if (logDir.canRead() && logDir.isDirectory()) {
            File[] logs = logDir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.matches(".*\\.log$");
                }
            });
            if (logs.length >= LOG_MAX_FILES_COUNT) {
                Arrays.sort(logs, 0, logs.length, new Comparator<File>() {
                    @Override
                    public int compare(File o1, File o2) {
                        return (int) Math.signum(o1.lastModified() - o2.lastModified());
                    }
                });
                for (int i = 0; i < logs.length - LOG_MAX_FILES_COUNT; i++) {
                    LOG.log(Level.FINE, "Deleting old log {0}", logs[i]);
                    logs[i].delete();
                }
            }
        }
    }
}
