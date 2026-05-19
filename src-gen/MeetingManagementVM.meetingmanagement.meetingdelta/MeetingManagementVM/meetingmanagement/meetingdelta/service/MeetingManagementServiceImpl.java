package MeetingManagementVM.meetingmanagement.meetingdelta.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import MeetingManagementVM.meetingmanagement.core.service.MeetingManagementServiceDecorator;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagementImpl;
import MeetingManagementVM.meetingmanagement.core.service.MeetingManagementServiceComponent;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagement;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagementDecorator;
import MeetingManagementVM.meetingmanagement.MeetingManagementFactory;

public class MeetingManagementServiceImpl extends MeetingManagementServiceDecorator {
    public MeetingManagementServiceImpl (MeetingManagementServiceComponent record) {
        super(record);
    }

 	public MeetingManagement createMeetingManagement(Map<String, Object> requestBody){
		String name = (String) requestBody.get("name");
		String startDate = (String) requestBody.get("startDate");
		String endDate = (String) requestBody.get("endDate");
		String location = (String) requestBody.get("location");
		MeetingManagement meetingmanagementmeetingdelta = record.createMeetingManagement(requestBody);
		MeetingManagement meetingmanagementmeetingdeltadeco = MeetingManagementFactory.createMeetingManagement("MeetingManagementVM.meetingmanagement.meetingdelta.model.MeetingManagementImpl", meetingmanagementmeetingdelta, );
		Repository.saveObject(meetingmanagementmeetingdeltadeco);
		return meetingmanagementmeetingdeltadeco;
	}

	public MeetingManagement createMeetingManagement(Map<String, Object> requestBody, int id){
		MeetingManagement savedMeetingManagement = Repository.getObject(id);
		UUID recordMeetingManagementIdMeeting = ((MeetingManagementDecorator) savedMeetingManagement).getIdMeeting();
		MeetingManagement meetingmanagement = record.createMeetingManagement(requestBody, recordMeetingManagementIdMeeting);
		MeetingManagement meetingmanagementmeetingdelta = MeetingManagementFactory.createMeetingManagement("MeetingManagementVM.meetingmanagement.meetingdelta.MeetingManagementImpl", meetingmanagement, );
		return meetingmanagementmeetingdelta;
	}

    public HashMap<String, Object> updateMeetingManagement(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idMeeting");
		
		MeetingManagement meetingmanagementmeetingdelta = Repository.getObject(id);
		meetingmanagementmeetingdelta = createMeetingManagement(requestBody, id);
		
		Repository.updateObject(meetingmanagementmeetingdelta);
		meetingmanagementmeetingdelta = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return meetingmanagementmeetingdelta.toHashMap();
	}

	public HashMap<String, Object> getMeetingManagement(String idStr){
		int id = Integer.parseInt(idStr);
		MeetingManagement meetingmanagementmeetingdelta = Repository.getObject(id);
		return meetingmanagementmeetingdelta.toHashMap();
	}

	public HashMap<String, Object> getMeetingManagementById(int id){
		List<HashMap<String, Object>> meetingmanagementList = getAllMeetingManagement();
		for (HashMap<String, Object> meetingmanagement : meetingmanagementList){
			int meetingmanagement_id = ((Double) meetingmanagement.get("idmeeting")).intValue();
			if (meetingmanagement_id == id){
				return meetingmanagement;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllMeetingManagement(){
		List<MeetingManagement> List = Repository.getAllObject("meetingmanagement_meetingdelta");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<MeetingManagement> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteMeetingManagement(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idMeeting"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllMeetingManagement();
	}

	
}
