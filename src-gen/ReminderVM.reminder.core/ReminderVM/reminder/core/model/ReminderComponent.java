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
	protected String isDisabled;
	protected int resendIntervalMin;
	protected String timeTrigger;
	protected String objectName = ReminderComponent.class.getName();

	public ReminderComponent() {

	} 

	public ReminderComponent(
        int idReminder, String isDisabled, int resendIntervalMin, String timeTrigger
    ) {
        this.idReminder = idReminder;
        this.isDisabled = isDisabled;
        this.resendIntervalMin = resendIntervalMin;
        this.timeTrigger = timeTrigger;
    }

	public int getIdReminder() {
		return this.idReminder;
	}

	public void setIdReminder(int idReminder) {
		this.idReminder = idReminder;
	}
	public String getIsDisabled() {
		return this.isDisabled;
	}

	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
	}
	public int getResendIntervalMin() {
		return this.resendIntervalMin;
	}

	public void setResendIntervalMin(int resendIntervalMin) {
		this.resendIntervalMin = resendIntervalMin;
	}
	public String getTimeTrigger() {
		return this.timeTrigger;
	}

	public void setTimeTrigger(String timeTrigger) {
		this.timeTrigger = timeTrigger;
	}
 

	@Override
    public String toString() {
        return "{" +
            " idReminder='" + getIdReminder() + "'" +
            " isDisabled='" + getIsDisabled() + "'" +
            " resendIntervalMin='" + getResendIntervalMin() + "'" +
            " timeTrigger='" + getTimeTrigger() + "'" +
            "}";
    }
	
}
