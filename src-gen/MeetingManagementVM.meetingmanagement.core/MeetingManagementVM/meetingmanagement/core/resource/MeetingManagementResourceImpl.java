package MeetingManagementVM.meetingmanagement.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import MeetingManagementVM.meetingmanagement.MeetingManagementFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagement;
import MeetingManagementVM.meetingmanagement.core.service.MeetingManagementServiceImpl;
//add other required packages


public class MeetingManagementResourceImpl extends MeetingManagementResourceComponent{
	
	private MeetingManagementServiceImpl meetingmanagementServiceImpl = new MeetingManagementServiceImpl();

	
    @Route(url="call/meetingmanagement/save")
    public List<HashMap<String,Object>> saveMeetingManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		MeetingManagement meetingmanagement = createMeetingManagement(vmjExchange);
		return meetingmanagementServiceImpl.getAllMeetingManagement();
	}

    public MeetingManagement createMeetingManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			MeetingManagement result = meetingmanagementServiceImpl.createMeetingManagement(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public MeetingManagement createMeetingManagement(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			MeetingManagement result = meetingmanagementServiceImpl.createMeetingManagement(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/meetingmanagement/update")
    public HashMap<String, Object> updateMeetingManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return meetingmanagementServiceImpl.updateMeetingManagement(requestBody);
		
	}

	
    @Route(url="call/meetingmanagement/detail")
    public HashMap<String, Object> getMeetingManagement(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("idMeeting");
		return meetingmanagementServiceImpl.getMeetingManagement(idStr);
	}

	
    @Route(url="call/meetingmanagement/list")
    public List<HashMap<String,Object>> getAllMeetingManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return meetingmanagementServiceImpl.getAllMeetingManagement();
	}

	
    @Route(url="call/meetingmanagement/delete")
    public List<HashMap<String,Object>> deleteMeetingManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return meetingmanagementServiceImpl.deleteMeetingManagement(requestBody);
	}


}
