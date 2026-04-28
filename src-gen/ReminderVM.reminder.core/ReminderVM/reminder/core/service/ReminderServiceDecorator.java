package ReminderVM.reminder.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import ReminderVM.reminder.core.model.Reminder;

public abstract class ReminderServiceDecorator extends ReminderServiceComponent{
	protected ReminderServiceComponent record;

    public ReminderServiceDecorator(ReminderServiceComponent record) {
        this.record = record;
    }

	public Reminder createReminder(Map<String, Object> requestBody){
		return record.createReminder(requestBody);
	}
	
	public Reminder createReminder(Map<String, Object> requestBody, int id){
		return record.createReminder(requestBody, id);
	}

	public HashMap<String, Object> getReminder(String idStr){
		return record.getReminder(idStr);
	}

	public List<HashMap<String,Object>> getAllReminder(){
		return record.getAllReminder();
	}

    public HashMap<String, Object> updateReminder(Map<String, Object> requestBody){
		return record.updateReminder(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Reminder> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteReminder(Map<String, Object> requestBody){
		return record.deleteReminder(requestBody);
	}

	public HashMap<String, Object> getReminderById(int id){
        return record.getReminderById(id);
    }

}
