package ReminderVM.reminder.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import ReminderVM.reminder.core.model.Reminder;
//add other required packages

public abstract class ReminderResourceComponent implements ReminderResource{
	
	public ReminderResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveReminder(VMJExchange vmjExchange);
    public abstract Reminder createReminder(VMJExchange vmjExchange);
	public abstract Reminder createReminder(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateReminder(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getReminder(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllReminder(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteReminder(VMJExchange vmjExchange);

}
