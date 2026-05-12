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
	protected int resendIntervalMin;
	protected int hour;
	protected int minute;
	protected String objectName = ReminderComponent.class.getName();

	public ReminderComponent() {

	} 

	public ReminderComponent(
        int idReminder, boolean isDisabled, int resendIntervalMin, int hour, int minute
    ) {
        this.idReminder = idReminder;
        this.isDisabled = isDisabled;
        this.resendIntervalMin = resendIntervalMin;
        this.hour = hour;
        this.minute = minute;
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
	public int getResendIntervalMin() {
		return this.resendIntervalMin;
	}

	public void setResendIntervalMin(int resendIntervalMin) {
		this.resendIntervalMin = resendIntervalMin;
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
 

	@Override
    public String toString() {
        return "{" +
            " idReminder='" + getIdReminder() + "'" +
            " isDisabled='" + getIsDisabled() + "'" +
            " resendIntervalMin='" + getResendIntervalMin() + "'" +
            " hour='" + getHour() + "'" +
            " minute='" + getMinute() + "'" +
            "}";
    }
	
}
