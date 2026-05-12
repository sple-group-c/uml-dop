package ReminderVM.reminder.inappnotification.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import ReminderVM.reminder.core.resource.ReminderResourceDecorator;
import ReminderVM.reminder.core.resource.ReminderResourceComponent;
import ReminderVM.reminder.core.model.Reminder;
import ReminderVM.reminder.core.model.ReminderImpl;
import ReminderVM.reminder.core.service.ReminderServiceComponent;
import ReminderVM.reminder.inappnotification.service.ReminderServiceImpl;

public class ReminderResourceImpl extends ReminderResourceDecorator {
	protected ReminderServiceComponent recordComponent;
	private ReminderServiceImpl reminderinappnotificationServiceImpl = new ReminderServiceImpl(recordComponent);

    public ReminderResourceImpl (ReminderResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/inappnotification/save")
    public List<HashMap<String,Object>> saveReminder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Reminder reminderinappnotification = createReminder(vmjExchange);
		return getAllReminder(vmjExchange);
	}

    public Reminder createReminder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Reminder result = reminderinappnotificationServiceImpl.createReminder(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Reminder createReminder(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Reminder result = reminderinappnotificationServiceImpl.createReminder(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/inappnotification/update")
    public HashMap<String, Object> updateReminder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reminderinappnotificationServiceImpl.updateReminder(requestBody);
	}

	
    @Route(url="call/inappnotification/detail")
    public HashMap<String, Object> getReminder(VMJExchange vmjExchange){
		return record.getReminder(vmjExchange);
	}

	
    @Route(url="call/inappnotification/list")
    public List<HashMap<String,Object>> getAllReminder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return reminderinappnotificationServiceImpl.getAllReminder();
	}

    public List<HashMap<String,Object>> transformReminderListToHashMap(List<Reminder> ReminderInAppNotificationList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < ReminderInAppNotificationList.size(); i++) {
            resultList.add(ReminderInAppNotificationList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/inappnotification/delete")
    public List<HashMap<String,Object>> deleteReminder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reminderinappnotificationServiceImpl.deleteReminder(requestBody);
	}

	
}
