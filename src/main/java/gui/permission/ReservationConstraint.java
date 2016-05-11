package gui.permission;

import gui.customcomponents.DatePicker;
import gui.customcomponents.ErrorLabel;
import model.Room;

/**
 * Created by marek on 11.5.16.
 */
public class ReservationConstraint extends PermissionConstraint {

    private Room room;
    private DatePicker datePickerFrom;
    private DatePicker datePickerTo;

    public ReservationConstraint(ErrorLabel errorLabel, Room room, DatePicker datePickerFrom, DatePicker datePickerTo) {
        super(errorLabel);
        this.room = room;
        this.datePickerFrom = datePickerFrom;
        this.datePickerTo = datePickerTo;
    }

    public ReservationConstraint(Room room, DatePicker datePickerFrom, DatePicker datePickerTo) {
        this.room = room;
        this.datePickerFrom = datePickerFrom;
        this.datePickerTo = datePickerTo;
    }


    @Override
    public boolean isOk() {
        return true;
    }
}
