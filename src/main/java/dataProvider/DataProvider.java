package dataProvider;

import dao.BuildingDAOImpl;
import dao.CommonDAOImpl;
import dao.ReservationDAOImp;
import dao.RoomDAOImpl;
import dao.TagDAOImpl;
import dao.UserDAOImpl;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import model.Building;
import model.Confirmed;
import model.Reservation;
import model.Room;
import model.User;
import model.UserRole;
import org.apache.commons.lang.RandomStringUtils;
import java.util.concurrent.ThreadLocalRandom;
import model.Image;
import model.Tag;

/**
 * @author chlupnoha
 */
public class DataProvider {

    private static final Logger LOG = Logger.getLogger(CommonDAOImpl.class.getName());
    
    public void fillDatabase() {
        fillUser(25);
        fillRezervation(25);
        fillBuildingWithImages();
    }
    
    public void fillUser(int count){
        User u1;
        String email;
        UserDAOImpl userDAO = new UserDAOImpl();
        for (int i = 0; i < count; i++) {
            email = RandomStringUtils.randomAlphanumeric(10).toLowerCase() + "@" + RandomStringUtils.randomAlphanumeric(10).toLowerCase() + ".cz";
            User u = userDAO.getFirstByColumn(User.class, email, "email");
            if (u != null) {
                //cant be same email again 24^30....
                email = RandomStringUtils.randomAlphanumeric(10).toLowerCase() + email;
            }
            u1 = new User(email,
                    RandomStringUtils.randomAlphanumeric(14).toLowerCase(),
                    UserRole.GUEST);
            userDAO.add(u1);
        }
        
    }
    
    public void fillRezervation(int count){
        System.out.println("addRezervation");

        User user = new User("reservationProvider@reservation.cz", "pass3word", "salt_salt", UserRole.GUEST);
        UserDAOImpl userDAO = new UserDAOImpl();
        User addUser = userDAO.add(user);

        BuildingDAOImpl buildingDao = new BuildingDAOImpl();
        Building building = buildingDao.add(new Building("na3me", "888777666", "tes3t@test.cz", "adress"));

        Room room = new Room(building);
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        Room addRoom = roomDAO.add(room);

        ReservationDAOImp instance = new ReservationDAOImp();
        for (int i = 0; i < count; i++) {
            int fromMonth  = ThreadLocalRandom.current().nextInt(0, 10);
            int fromDay  = ThreadLocalRandom.current().nextInt(0, 31);
            Calendar from = new GregorianCalendar(2013, fromMonth, fromDay);
            Calendar to = new GregorianCalendar(2013, fromMonth+2, fromDay);

            Reservation reservation = new Reservation(from, to, Confirmed.CONFIRMED, addUser, addRoom);  

            instance.add(reservation);          
        }
    }
    
    public void fillTags(int count){
        Tag tag;
        TagDAOImpl instance = new TagDAOImpl();
        for (int i = 0; i < count; i++) {
            tag = new Tag("tagTest" + i);
            instance.add(tag);
        }
    }
    
    public void fillBuildingWithImages(){
        Building building;
        building = new Building("dataProviderBuilding", "999666333", "test2@test.test", "adressTest2");
        Set<Image> s = new HashSet();
        for (int i = 0; i < 25; i++) {
            s.add(new Image("testImage" + i));
        }
        building.setImages(s);
        BuildingDAOImpl buldingDao = new BuildingDAOImpl();
        buldingDao.add(building);
    }

}
