package ReminderVM.reminder.inappnotification.service;

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
		String idReminderStr = (String) requestBody.get("idReminder");
		int idReminder = Integer.parseInt(idReminderStr);
		boolean isDisabled = (boolean) requestBody.get("isDisabled");
		String resendIntervalMinStr = (String) requestBody.get("resendIntervalMin");
		int resendIntervalMin = Integer.parseInt(resendIntervalMinStr);
		String hourStr = (String) requestBody.get("hour");
		int hour = Integer.parseInt(hourStr);
		String minuteStr = (String) requestBody.get("minute");
		int minute = Integer.parseInt(minuteStr);
		Reminder reminderinappnotification = record.createReminder(requestBody);
		Reminder reminderinappnotificationdeco = ReminderFactory.createReminder("ReminderVM.reminder.inappnotification", reminderinappnotification, idReminder, isDisabled, resendIntervalMin, hour, minute);
		Repository.saveObject(reminderinappnotificationdeco);
		return reminderinappnotificationdeco;
	}

	public Reminder createReminder(Map<String, Object> requestBody, int id){
		Reminder savedReminder = Repository.getObject(id);
		String idReminderStr = (String) requestBody.get("idReminder");
		int idReminder = Integer.parseInt(idReminderStr);
		boolean isDisabled = (boolean) requestBody.get("isDisabled");
		String resendIntervalMinStr = (String) requestBody.get("resendIntervalMin");
		int resendIntervalMin = Integer.parseInt(resendIntervalMinStr);
		String hourStr = (String) requestBody.get("hour");
		int hour = Integer.parseInt(hourStr);
		String minuteStr = (String) requestBody.get("minute");
		int minute = Integer.parseInt(minuteStr);
		UUID recordReminderIdReminder = ((ReminderDecorator) savedReminder).getIdReminder();
		Reminder Reminder = record.createReminder(requestBody, recordReminderIdReminder);
		Reminder reminderinappnotification = ReminderFactory.createReminder("ReminderVM.reminder.inappnotification.model.ReminderImpl", Reminder, idReminder, isDisabled, resendIntervalMin, hour, minute);
		return reminderinappnotification;
	}

    public HashMap<String, Object> updateReminder(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idReminder");
		
		Reminder reminderinappnotification = Repository.getObject(id);
		reminderinappnotification = createReminder(requestBody, id);
		
		Repository.updateObject(reminderinappnotification);
		reminderinappnotification = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return reminderinappnotification.toHashMap();
	}

	public HashMap<String, Object> getReminder(String idStr){
		int id = Integer.parseInt(idStr);
		Reminder reminderinappnotification = Repository.getObject(id);
		return reminderinappnotification.toHashMap();
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
		List<Reminder> List = Repository.getAllObject("reminder_inappnotification");
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

	
}
