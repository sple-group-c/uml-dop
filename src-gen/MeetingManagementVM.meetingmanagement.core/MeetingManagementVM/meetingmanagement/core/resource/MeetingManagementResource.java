package MeetingManagementVM.meetingmanagement.core.resource;
import java.util.*;

import MeetingManagementVM.meetingmanagement.core.model.MeetingManagement;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface MeetingManagementResource {
    List<HashMap<String,Object>> saveMeetingManagement(VMJExchange vmjExchange);
    HashMap<String, Object> updateMeetingManagement(VMJExchange vmjExchange);
    HashMap<String, Object> getMeetingManagement(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllMeetingManagement(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteMeetingManagement(VMJExchange vmjExchange);
}
