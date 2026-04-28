package ReminderVM.reminder.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import ReminderVM.reminder.ReminderFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import ReminderVM.reminder.core.model.Reminder;
import ReminderVM.reminder.core.service.ReminderServiceImpl;
//add other required packages


public class ReminderResourceImpl extends ReminderResourceComponent{
	
	private ReminderServiceImpl reminderServiceImpl = new ReminderServiceImpl();

	
    @Route(url="call/reminder/save")
    public List<HashMap<String,Object>> saveReminder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Reminder reminder = createReminder(vmjExchange);
		return reminderServiceImpl.getAllReminder();
	}

    public Reminder createReminder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Reminder result = reminderServiceImpl.createReminder(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Reminder createReminder(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Reminder result = reminderServiceImpl.createReminder(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/reminder/update")
    public HashMap<String, Object> updateReminder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reminderServiceImpl.updateReminder(requestBody);
		
	}

	
    @Route(url="call/reminder/detail")
    public HashMap<String, Object> getReminder(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("idReminder");
		return reminderServiceImpl.getReminder(idStr);
	}

	
    @Route(url="call/reminder/list")
    public List<HashMap<String,Object>> getAllReminder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reminderServiceImpl.getAllReminder();
	}

	
    @Route(url="call/reminder/delete")
    public List<HashMap<String,Object>> deleteReminder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reminderServiceImpl.deleteReminder(requestBody);
	}


}
