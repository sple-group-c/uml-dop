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

	public ReminderImpl(int idReminder, String isDisabled, int resendIntervalMin, String timeTrigger) {
		this.idReminder = idReminder;
		this.isDisabled = isDisabled;
		this.resendIntervalMin = resendIntervalMin;
		this.timeTrigger = timeTrigger;
	}

	public ReminderImpl(String isDisabled, int resendIntervalMin, String timeTrigger) {
		Random r = new Random();
		this.idReminder = Math.abs(r.nextInt());
		this.isDisabled = isDisabled;
		this.resendIntervalMin = resendIntervalMin;
		this.timeTrigger = timeTrigger;
	}

	public ReminderImpl() { }

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

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> reminderMap = new HashMap<String,Object>();
		reminderMap.put("idReminder",getIdReminder());
		reminderMap.put("isDisabled",getIsDisabled());
		reminderMap.put("resendIntervalMin",getResendIntervalMin());
		reminderMap.put("timeTrigger",getTimeTrigger());

        return reminderMap;
    }

}
