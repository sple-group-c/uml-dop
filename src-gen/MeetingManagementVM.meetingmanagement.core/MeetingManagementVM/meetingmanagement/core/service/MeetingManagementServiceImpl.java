package MeetingManagementVM.meetingmanagement.core.service;
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
import MeetingManagementVM.meetingmanagement.MeetingManagementFactory;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagement;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class MeetingManagementServiceImpl extends MeetingManagementServiceComponent{

    public MeetingManagement createMeetingManagement(Map<String, Object> requestBody){
		String name = (String) requestBody.get("name");
		String startDate = (String) requestBody.get("startDate");
		String endDate = (String) requestBody.get("endDate");
		String location = (String) requestBody.get("location");
		
		//to do: fix association attributes
		
		MeetingManagement meetingmanagement = MeetingManagementFactory.createMeetingManagement("MeetingManagementVM.meetingmanagement.core.model.MeetingManagementImpl", name, startDate, endDate, location);
		Repository.saveObject(meetingmanagement);
		return meetingmanagement;
	}

	public MeetingManagement createMeetingManagement(Map<String, Object> requestBody, int id){
		int idMeeting = id;
		String name = (String) requestBody.get("name");
		String startDate = (String) requestBody.get("startDate");
		String endDate = (String) requestBody.get("endDate");
		String location = (String) requestBody.get("location");
		
		//to do: fix association attributes
		MeetingManagement meetingmanagement = MeetingManagementFactory.createMeetingManagement("MeetingManagementVM.meetingmanagement.core.model.MeetingManagementImpl",idMeeting, name, startDate, endDate, location);
		Repository.saveObject(meetingmanagement);
		return meetingmanagement;
	}

    public HashMap<String, Object> updateMeetingManagement(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idMeeting");
		int id = Integer.parseInt(idStr);
		MeetingManagement meetingmanagement = Repository.getObject(id);
		
		meetingmanagement.setName((String) requestBody.get("name"));
		meetingmanagement.setStartDate((String) requestBody.get("startDate"));
		meetingmanagement.setEndDate((String) requestBody.get("endDate"));
		meetingmanagement.setLocation((String) requestBody.get("location"));
		
		Repository.updateObject(meetingmanagement);
		
		//to do: fix association attributes
		
		return meetingmanagement.toHashMap();
		
	}

    public HashMap<String, Object> getMeetingManagement(String idStr){
		int id = Integer.parseInt(idStr);
		MeetingManagement meetingmanagement = Repository.getObject(id);
		return meetingmanagement.toHashMap();
	}

	public HashMap<String, Object> getMeetingManagementById(int id){
		List<HashMap<String, Object>> meetingmanagementList = getAllMeetingManagement();
		for (HashMap<String, Object> meetingmanagement : meetingmanagementList){
			int record_id = ((Double) meetingmanagement.get("idMeeting")).intValue();
			if (record_id == id){
				return meetingmanagement;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllMeetingManagement(){
		List<MeetingManagement> List = Repository.getAllObject("meetingmanagement_impl");
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
