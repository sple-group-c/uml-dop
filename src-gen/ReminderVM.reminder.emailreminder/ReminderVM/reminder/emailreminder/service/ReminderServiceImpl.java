package ReminderVM.reminder.emailreminder.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import ReminderVM.reminder.core.service.ReminderServiceDecorator;
import ReminderVM.reminder.core.model.ReminderImpl;
import ReminderVM.reminder.core.service.ReminderServiceComponent;
import ReminderVM.reminder.core.model.Reminder;
import ReminderVM.reminder.core.model.ReminderDecorator;
import ReminderVM.reminder.ReminderFactory;

public class ReminderServiceImpl extends ReminderServiceDecorator {
    public ReminderServiceImpl (ReminderServiceComponent record) {
        super(record);
    }

 	public Reminder createReminder(Map<String, Object> requestBody){
		String email = (String) requestBody.get("email");
		boolean isDisabled = (boolean) requestBody.get("isDisabled");
		String hourStr = (String) requestBody.get("hour");
		int hour = Integer.parseInt(hourStr);
		String minuteStr = (String) requestBody.get("minute");
		int minute = Integer.parseInt(minuteStr);
		String remindingForIdStr = (String) requestBody.get("remindingForId");
		int remindingForId = Integer.parseInt(remindingForIdStr);
		Reminder reminderemailreminder = record.createReminder(requestBody);
		Reminder reminderemailreminderdeco = ReminderFactory.createReminder("ReminderVM.reminder.emailreminder.model.ReminderImpl", reminderemailreminder, email);
		Repository.saveObject(reminderemailreminderdeco);
		return reminderemailreminderdeco;
	}

	public Reminder createReminder(Map<String, Object> requestBody, int id){
		Reminder savedReminder = Repository.getObject(id);
		String email = (String) requestBody.get("email");
		int recordReminderIdReminder = ((ReminderDecorator) savedReminder).getIdReminder();
		Reminder reminder = record.createReminder(requestBody, recordReminderIdReminder);
		Reminder reminderemailreminder = ReminderFactory.createReminder("ReminderVM.reminder.emailreminder.ReminderImpl", reminder, email);
		return reminderemailreminder;
	}

    public HashMap<String, Object> updateReminder(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idReminder");
		int id = Integer.parseInt(idStr);

		Reminder reminderemailreminder = Repository.getObject(id);
		reminderemailreminder = createReminder(requestBody, id);
		
		Repository.updateObject(reminderemailreminder);
		reminderemailreminder = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return reminderemailreminder.toHashMap();
	}

	public HashMap<String, Object> getReminder(String idStr){
		int id = Integer.parseInt(idStr);
		Reminder reminderemailreminder = Repository.getObject(id);
		return reminderemailreminder.toHashMap();
	}

	public HashMap<String, Object> getReminderById(int id){
		List<HashMap<String, Object>> reminderList = getAllReminder();
		for (HashMap<String, Object> reminder : reminderList){
			int reminder_id = ((Double) reminder.get("idreminder")).intValue();
			if (reminder_id == id){
				return reminder;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllReminder(){
		List<Reminder> List = Repository.getAllObject("reminder_emailreminder");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Reminder> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteReminder(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idReminder"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllReminder();
	}

	
	public void sendsEmail(String emailAddress) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
