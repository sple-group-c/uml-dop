package MeetingManagementVM.meetingmanagement.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagement;
//add other required packages

public abstract class MeetingManagementResourceComponent implements MeetingManagementResource{
	
	public MeetingManagementResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveMeetingManagement(VMJExchange vmjExchange);
    public abstract MeetingManagement createMeetingManagement(VMJExchange vmjExchange);
	public abstract MeetingManagement createMeetingManagement(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateMeetingManagement(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getMeetingManagement(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllMeetingManagement(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteMeetingManagement(VMJExchange vmjExchange);

}
