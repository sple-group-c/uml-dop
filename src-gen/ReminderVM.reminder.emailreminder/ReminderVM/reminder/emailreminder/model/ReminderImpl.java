package ReminderVM.reminder.emailreminder.model;

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

@Entity(name="reminder_emailreminder")
@Table(name="reminder_emailreminder")
public class ReminderImpl extends ReminderDecorator {

	protected String email;
	public ReminderImpl() {
        super();
		Random r = new Random();
		this.idReminder = Math.abs(r.nextInt());
        this.objectName = ReminderImpl.class.getName();
    }

	public ReminderImpl(ReminderComponent record, String email) {
		super(record, ReminderImpl.class.getName());
		this.email = email;
		this.objectName = ReminderImpl.class.getName();
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void sendsEmail(String emailAddress) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idReminder", idReminder);
		map.put("email", getEmail());

        return map;
    }

}
