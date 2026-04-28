package MeetingManagementVM.meetingmanagement.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagement;
//add other required packages

public abstract class MeetingManagementServiceComponent implements MeetingManagementService{
	protected RepositoryUtil<MeetingManagement> Repository;

    public MeetingManagementServiceComponent(){
        this.Repository = new RepositoryUtil<MeetingManagement>(MeetingManagementVM.meetingmanagement.core.model.MeetingManagementComponent.class);
    }	

    public abstract MeetingManagement createMeetingManagement(Map<String, Object> requestBody);
	public abstract MeetingManagement createMeetingManagement(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateMeetingManagement(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getMeetingManagement(String idStr);
    public abstract List<HashMap<String,Object>> getAllMeetingManagement();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<MeetingManagement> List);
    public abstract List<HashMap<String,Object>> deleteMeetingManagement(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getMeetingManagementById(int id);

}
