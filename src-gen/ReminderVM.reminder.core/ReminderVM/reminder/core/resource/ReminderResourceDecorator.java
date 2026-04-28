package ReminderVM.reminder.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import ReminderVM.reminder.core.model.Reminder;

public abstract class ReminderResourceDecorator extends ReminderResourceComponent{
	protected ReminderResourceComponent record;

    public ReminderResourceDecorator(ReminderResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveReminder(VMJExchange vmjExchange){
		return record.saveReminder(vmjExchange);
	}

    public Reminder createReminder(VMJExchange vmjExchange){
		return record.createReminder(vmjExchange);
	}
	
	public Reminder createReminder(VMJExchange vmjExchange, int id){
		return record.createReminder(vmjExchange, id);
	}

    public HashMap<String, Object> updateReminder(VMJExchange vmjExchange){
		return record.updateReminder(vmjExchange);
	}

    public HashMap<String, Object> getReminder(VMJExchange vmjExchange){
		return record.getReminder(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllReminder(VMJExchange vmjExchange){
		return record.getAllReminder(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteReminder(VMJExchange vmjExchange){
		return record.deleteReminder(vmjExchange);
	}

}
