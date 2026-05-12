package ReminderVM.reminder.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="reminder_impl")
@Table(name="reminder_impl")
public class ReminderImpl extends ReminderComponent {

	public ReminderImpl(int idReminder, boolean isDisabled, int resendIntervalMin, int hour, int minute) {
		this.idReminder = idReminder;
		this.isDisabled = isDisabled;
		this.resendIntervalMin = resendIntervalMin;
		this.hour = hour;
		this.minute = minute;
	}

	public ReminderImpl(boolean isDisabled, int resendIntervalMin, int hour, int minute) {
		Random r = new Random();
		this.idReminder = Math.abs(r.nextInt());
		this.isDisabled = isDisabled;
		this.resendIntervalMin = resendIntervalMin;
		this.hour = hour;
		this.minute = minute;
	}

	public ReminderImpl() { }

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

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> reminderMap = new HashMap<String,Object>();
		reminderMap.put("idReminder",getIdReminder());
		reminderMap.put("isDisabled",getIsDisabled());
		reminderMap.put("resendIntervalMin",getResendIntervalMin());
		reminderMap.put("hour",getHour());
		reminderMap.put("minute",getMinute());

        return reminderMap;
    }

}
