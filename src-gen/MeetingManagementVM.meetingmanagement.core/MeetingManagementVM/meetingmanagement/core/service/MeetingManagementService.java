package MeetingManagementVM.meetingmanagement.core.service;
import java.util.*;

import MeetingManagementVM.meetingmanagement.core.model.MeetingManagement;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface MeetingManagementService {
	MeetingManagement createMeetingManagement(Map<String, Object> requestBody);
	HashMap<String, Object> getMeetingManagement(String idStr);
    HashMap<String, Object> updateMeetingManagement(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllMeetingManagement();
    List<HashMap<String,Object>> deleteMeetingManagement(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<MeetingManagement> List);
}
