package ReminderVM.reminder.reminderdelta.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import ReminderVM.reminder.core.model.ReminderDecorator;
import ReminderVM.reminder.core.model.Reminder;
import ReminderVM.reminder.core.model.ReminderComponent;

@Entity(name="reminder_reminderdelta")
@Table(name="reminder_reminderdelta")
public class ReminderImpl extends ReminderDecorator {

	public ReminderImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = ReminderImpl.class.getName();
    }

	public ReminderImpl(ReminderComponent record) {
		super(record, ReminderImpl.class.getName());
		this.objectName = ReminderImpl.class.getName();
	}



	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idReminder", idReminder);

        return map;
    }

}
