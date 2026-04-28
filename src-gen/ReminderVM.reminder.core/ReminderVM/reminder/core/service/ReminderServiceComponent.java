package ReminderVM.reminder.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import ReminderVM.reminder.core.model.Reminder;
//add other required packages

public abstract class ReminderServiceComponent implements ReminderService{
	protected RepositoryUtil<Reminder> Repository;

    public ReminderServiceComponent(){
        this.Repository = new RepositoryUtil<Reminder>(ReminderVM.reminder.core.model.ReminderComponent.class);
    }	

    public abstract Reminder createReminder(Map<String, Object> requestBody);
	public abstract Reminder createReminder(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateReminder(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getReminder(String idStr);
    public abstract List<HashMap<String,Object>> getAllReminder();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Reminder> List);
    public abstract List<HashMap<String,Object>> deleteReminder(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getReminderById(int id);

}
