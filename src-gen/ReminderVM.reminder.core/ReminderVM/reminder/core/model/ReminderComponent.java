package ReminderVM.reminder.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="reminder_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReminderComponent implements Reminder{
	@Id
	protected int idReminder; 
	protected boolean isDisabled;
	protected int hour;
	protected int minute;
	protected int remindingForId;
	protected String objectName = ReminderComponent.class.getName();

	public ReminderComponent() {

	} 

	public ReminderComponent(
        int idReminder, boolean isDisabled, int hour, int minute, int remindingForId
    ) {
        this.idReminder = idReminder;
        this.isDisabled = isDisabled;
        this.hour = hour;
        this.minute = minute;
        this.remindingForId = remindingForId;
    }

	public int getIdReminder() {
		return this.idReminder;
	}

	public void setIdReminder(int idReminder) {
		this.idReminder = idReminder;
	}
	public boolean getIsDisabled() {
		return this.isDisabled;
	}

	public void setIsDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}
	public int getHour() {
		return this.hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return this.minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getRemindingForId() {
		return this.remindingForId;
	}

	public void setRemindingForId(int remindingForId) {
		this.remindingForId = remindingForId;
	}
 

	@Override
    public String toString() {
        return "{" +
            " idReminder='" + getIdReminder() + "'" +
            " isDisabled='" + getIsDisabled() + "'" +
            " hour='" + getHour() + "'" +
            " minute='" + getMinute() + "'" +
            " remindingForId='" + getRemindingForId() + "'" +
            "}";
    }
	
}
