package ReminderVM.reminder.core.resource;
import java.util.*;

import ReminderVM.reminder.core.model.Reminder;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ReminderResource {
    List<HashMap<String,Object>> saveReminder(VMJExchange vmjExchange);
    HashMap<String, Object> updateReminder(VMJExchange vmjExchange);
    HashMap<String, Object> getReminder(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllReminder(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteReminder(VMJExchange vmjExchange);
}
