/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package rezervace;


import dao_impl.UserDAOImpl;
import model.User;
import model.UserRole;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
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

    /**
     * Run different methods according to first argument.
     *
     * @param args
     */
    public static void main(String[] args) {
        loggerSetup();
        deleteOldLogs();

        createIlustrationData();


        //tady pak View

    }

    private static void createIlustrationData() {

        // MARINES ***********************************************************
//        Marine m1 = new Marine("Alice", "Johnson", new GregorianCalendar(2000, 8, 24), "Fort Noxis", Status.DEAD);
//        Marine m2 = new Marine("Frenky", "Strasak", new GregorianCalendar(2000, 4, 4), "Fort Noxis", Status.MISSING);
//        Marine m3 = new Marine("Adolf", "Robinson", new GregorianCalendar(2004, 1, 17), "Fort Noxis", Status.ALIVE);
//        Marine m4 = new Marine("Jim", "Johnson", new GregorianCalendar(2007, 5, 25), "Fort Noxis", Status.ALIVE);
//        Marine m5 = new Marine("Arnold", "John", new GregorianCalendar(2010, 8, 29), "Fort Noxis", Status.ALIVE);
//        Marine m6 = new Marine("Oxen", "Shwarzzenegger", new GregorianCalendar(1998, 1, 24), "Fort Noxis", Status.ALIVE);
//        Marine m7 = new Marine("Brad", "Black", new GregorianCalendar(2003, 1, 27), "Fort Noxis", Status.ALIVE);
//        Marine m8 = new Marine("Kim", "Vim", new GregorianCalendar(2001, 8, 14), "Fort Noxis", Status.ALIVE);
//        MarineDAO marineDAO = new MarineDAOImpl();
//        marineDAO.addMarine(m1);
//        marineDAO.addMarine(m2);
//        marineDAO.addMarine(m3);
//        marineDAO.addMarine(m4);
//        marineDAO.addMarine(m5);
//        marineDAO.addMarine(m6);
//        marineDAO.addMarine(m7);
//        marineDAO.addMarine(m8);

        User u1 = new User("email@email.cz", "password", "dfkjlas", UserRole.ADMIN);
        UserDAO uDAO = new UserDAOImpl();
        uDAO.addUser(u1);

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
