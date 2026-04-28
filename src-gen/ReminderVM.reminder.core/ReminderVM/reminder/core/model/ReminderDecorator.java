package ReminderVM.reminder.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ReminderDecorator extends ReminderComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ReminderComponent record;

	public ReminderDecorator () {
		super();
		Random r = new Random();
		this.idReminder = Math.abs(r.nextInt());
	}

	public ReminderDecorator (int idReminder, ReminderComponent record) {
		this.idReminder =  idReminder;
		this.record = record;
	}
	
	public ReminderDecorator (ReminderComponent record, String objectName) {
		Random r = new Random();
		this.idReminder = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getIdReminder() {
		return record.getIdReminder();
	}
	public void setIdReminder(int idReminder) {
		record.setIdReminder(idReminder);
	}
	public String getIsDisabled() {
		return record.getIsDisabled();
	}
	public void setIsDisabled(String isDisabled) {
		record.setIsDisabled(isDisabled);
	}
	public int getResendIntervalMin() {
		return record.getResendIntervalMin();
	}
	public void setResendIntervalMin(int resendIntervalMin) {
		record.setResendIntervalMin(resendIntervalMin);
	}
	public String getTimeTrigger() {
		return record.getTimeTrigger();
	}
	public void setTimeTrigger(String timeTrigger) {
		record.setTimeTrigger(timeTrigger);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
