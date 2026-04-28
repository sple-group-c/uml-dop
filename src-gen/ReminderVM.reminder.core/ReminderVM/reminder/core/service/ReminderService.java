package ReminderVM.reminder.core.service;
import java.util.*;

import ReminderVM.reminder.core.model.Reminder;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ReminderService {
	Reminder createReminder(Map<String, Object> requestBody);
	HashMap<String, Object> getReminder(String idStr);
    HashMap<String, Object> updateReminder(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllReminder();
    List<HashMap<String,Object>> deleteReminder(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Reminder> List);
}
