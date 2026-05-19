package ReminderVM.reminder.emailreminder.resource;
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
import ReminderVM.reminder.emailreminder.service.ReminderServiceImpl;

public class ReminderResourceImpl extends ReminderResourceDecorator {
	private ReminderServiceComponent reminderemailreminderServiceImpl;

    public ReminderResourceImpl (ReminderResourceComponent record, ReminderServiceComponent recordService) {
        super(record);
		this.reminderemailreminderServiceImpl = new ReminderServiceImpl(recordService);
    }

    
    @Route(url="call/emailreminder/save")
    public List<HashMap<String,Object>> saveReminder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Reminder reminderemailreminder = createReminder(vmjExchange);
		return getAllReminder(vmjExchange);
	}

    public Reminder createReminder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Reminder result = reminderemailreminderServiceImpl.createReminder(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Reminder createReminder(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Reminder result = reminderemailreminderServiceImpl.createReminder(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/emailreminder/update")
    public HashMap<String, Object> updateReminder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reminderemailreminderServiceImpl.updateReminder(requestBody);
	}

	
    @Route(url="call/emailreminder/detail")
    public HashMap<String, Object> getReminder(VMJExchange vmjExchange){
		return record.getReminder(vmjExchange);
	}

	
    @Route(url="call/emailreminder/list")
    public List<HashMap<String,Object>> getAllReminder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return reminderemailreminderServiceImpl.getAllReminder();
	}

    public List<HashMap<String,Object>> transformReminderListToHashMap(List<Reminder> ReminderEmailReminderList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < ReminderEmailReminderList.size(); i++) {
            resultList.add(ReminderEmailReminderList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/emailreminder/delete")
    public List<HashMap<String,Object>> deleteReminder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reminderemailreminderServiceImpl.deleteReminder(requestBody);
	}

	public void sendsEmail(String emailAddress) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
}
