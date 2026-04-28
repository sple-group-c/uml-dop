package MeetingManagementVM.meetingmanagement.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagement;

public abstract class MeetingManagementServiceDecorator extends MeetingManagementServiceComponent{
	protected MeetingManagementServiceComponent record;

    public MeetingManagementServiceDecorator(MeetingManagementServiceComponent record) {
        this.record = record;
    }

	public MeetingManagement createMeetingManagement(Map<String, Object> requestBody){
		return record.createMeetingManagement(requestBody);
	}
	
	public MeetingManagement createMeetingManagement(Map<String, Object> requestBody, int id){
		return record.createMeetingManagement(requestBody, id);
	}

	public HashMap<String, Object> getMeetingManagement(String idStr){
		return record.getMeetingManagement(idStr);
	}

	public List<HashMap<String,Object>> getAllMeetingManagement(){
		return record.getAllMeetingManagement();
	}

    public HashMap<String, Object> updateMeetingManagement(Map<String, Object> requestBody){
		return record.updateMeetingManagement(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<MeetingManagement> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteMeetingManagement(Map<String, Object> requestBody){
		return record.deleteMeetingManagement(requestBody);
	}

	public HashMap<String, Object> getMeetingManagementById(int id){
        return record.getMeetingManagementById(id);
    }

}
