package ReminderVM.reminder.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import ReminderVM.reminder.ReminderFactory;
import ReminderVM.reminder.core.model.Reminder;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class ReminderServiceImpl extends ReminderServiceComponent{

    public Reminder createReminder(Map<String, Object> requestBody){
		String isDisabled = (String) requestBody.get("isDisabled");
		String resendIntervalMinStr = (String) requestBody.get("resendIntervalMin");
		int resendIntervalMin = Integer.parseInt(resendIntervalMinStr);
		String timeTrigger = (String) requestBody.get("timeTrigger");
		
		//to do: fix association attributes
		
		Reminder reminder = ReminderFactory.createReminder("ReminderVM.reminder.core.model.ReminderImpl", isDisabled, resendIntervalMin, timeTrigger);
		Repository.saveObject(reminder);
		return reminder;
	}

	public Reminder createReminder(Map<String, Object> requestBody, int id){
		int idReminder = id;
		String isDisabled = (String) requestBody.get("isDisabled");
		String resendIntervalMinStr = (String) requestBody.get("resendIntervalMin");
		int resendIntervalMin = Integer.parseInt(resendIntervalMinStr);
		String timeTrigger = (String) requestBody.get("timeTrigger");
		
		//to do: fix association attributes
		Reminder reminder = ReminderFactory.createReminder("ReminderVM.reminder.core.model.ReminderImpl",idReminder, isDisabled, resendIntervalMin, timeTrigger);
		Repository.saveObject(reminder);
		return reminder;
	}

    public HashMap<String, Object> updateReminder(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idReminder");
		int id = Integer.parseInt(idStr);
		Reminder reminder = Repository.getObject(id);
		
		reminder.setIsDisabled((String) requestBody.get("isDisabled"));
		String resendIntervalMinStr = (String) requestBody.get("resendIntervalMin");
		reminder.setResendIntervalMin(Integer.parseInt(resendIntervalMinStr));
		
		reminder.setTimeTrigger((String) requestBody.get("timeTrigger"));
		
		Repository.updateObject(reminder);
		
		//to do: fix association attributes
		
		return reminder.toHashMap();
		
	}

    public HashMap<String, Object> getReminder(String idStr){
		int id = Integer.parseInt(idStr);
		Reminder reminder = Repository.getObject(id);
		return reminder.toHashMap();
	}

	public HashMap<String, Object> getReminderById(int id){
		List<HashMap<String, Object>> reminderList = getAllReminder();
		for (HashMap<String, Object> reminder : reminderList){
			int record_id = ((Double) reminder.get("idReminder")).intValue();
			if (record_id == id){
				return reminder;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllReminder(){
		List<Reminder> List = Repository.getAllObject("reminder_impl");
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
