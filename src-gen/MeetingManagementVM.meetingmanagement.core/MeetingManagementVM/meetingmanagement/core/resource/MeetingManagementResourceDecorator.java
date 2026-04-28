package MeetingManagementVM.meetingmanagement.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagement;

public abstract class MeetingManagementResourceDecorator extends MeetingManagementResourceComponent{
	protected MeetingManagementResourceComponent record;

    public MeetingManagementResourceDecorator(MeetingManagementResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveMeetingManagement(VMJExchange vmjExchange){
		return record.saveMeetingManagement(vmjExchange);
	}

    public MeetingManagement createMeetingManagement(VMJExchange vmjExchange){
		return record.createMeetingManagement(vmjExchange);
	}
	
	public MeetingManagement createMeetingManagement(VMJExchange vmjExchange, int id){
		return record.createMeetingManagement(vmjExchange, id);
	}

    public HashMap<String, Object> updateMeetingManagement(VMJExchange vmjExchange){
		return record.updateMeetingManagement(vmjExchange);
	}

    public HashMap<String, Object> getMeetingManagement(VMJExchange vmjExchange){
		return record.getMeetingManagement(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllMeetingManagement(VMJExchange vmjExchange){
		return record.getAllMeetingManagement(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteMeetingManagement(VMJExchange vmjExchange){
		return record.deleteMeetingManagement(vmjExchange);
	}

}
