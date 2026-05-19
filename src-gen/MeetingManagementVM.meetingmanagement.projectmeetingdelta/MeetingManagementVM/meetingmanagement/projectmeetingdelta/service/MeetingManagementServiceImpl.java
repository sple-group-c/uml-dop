package MeetingManagementVM.meetingmanagement.projectmeetingdelta.service;

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
		String idMeetingStr = (String) requestBody.get("idMeeting");
		int idMeeting = Integer.parseInt(idMeetingStr);
		String name = (String) requestBody.get("name");
		String startDate = (String) requestBody.get("startDate");
		String endDate = (String) requestBody.get("endDate");
		String location = (String) requestBody.get("location");
		MeetingManagement meetingmanagementprojectmeetingdelta = record.createMeetingManagement(requestBody);
		MeetingManagement meetingmanagementprojectmeetingdeltadeco = MeetingManagementFactory.createMeetingManagement("MeetingManagementVM.meetingmanagement.projectmeetingdelta", meetingmanagementprojectmeetingdelta, idMeeting, name, startDate, endDate, location, project);
		Repository.saveObject(meetingmanagementprojectmeetingdeltadeco);
		return meetingmanagementprojectmeetingdeltadeco;
	}

	public MeetingManagement createMeetingManagement(Map<String, Object> requestBody, int id){
		MeetingManagement savedMeetingManagement = Repository.getObject(id);
		String idMeetingStr = (String) requestBody.get("idMeeting");
		int idMeeting = Integer.parseInt(idMeetingStr);
		String name = (String) requestBody.get("name");
		String startDate = (String) requestBody.get("startDate");
		String endDate = (String) requestBody.get("endDate");
		String location = (String) requestBody.get("location");
		UUID recordMeetingManagementIdMeeting = ((MeetingManagementDecorator) savedMeetingManagement).getIdMeeting();
		MeetingManagement MeetingManagement = record.createMeetingManagement(requestBody, recordMeetingManagementIdMeeting);
		MeetingManagement meetingmanagementprojectmeetingdelta = MeetingManagementFactory.createMeetingManagement("MeetingManagementVM.meetingmanagement.projectmeetingdelta.model.MeetingManagementImpl", MeetingManagement, idMeeting, name, startDate, endDate, location, project);
		return meetingmanagementprojectmeetingdelta;
	}

    public HashMap<String, Object> updateMeetingManagement(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idMeeting");
		
		MeetingManagement meetingmanagementprojectmeetingdelta = Repository.getObject(id);
		meetingmanagementprojectmeetingdelta = createMeetingManagement(requestBody, id);
		
		Repository.updateObject(meetingmanagementprojectmeetingdelta);
		meetingmanagementprojectmeetingdelta = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return meetingmanagementprojectmeetingdelta.toHashMap();
	}

	public HashMap<String, Object> getMeetingManagement(String idStr){
		int id = Integer.parseInt(idStr);
		MeetingManagement meetingmanagementprojectmeetingdelta = Repository.getObject(id);
		return meetingmanagementprojectmeetingdelta.toHashMap();
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
		List<MeetingManagement> List = Repository.getAllObject("meetingmanagement_projectmeetingdelta");
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
