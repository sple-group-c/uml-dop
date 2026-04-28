package MeetingManagementVM.meetingmanagement.meetingdelta.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import MeetingManagementVM.meetingmanagement.core.resource.MeetingManagementResourceDecorator;
import MeetingManagementVM.meetingmanagement.core.resource.MeetingManagementResourceComponent;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagement;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagementImpl;
import MeetingManagementVM.meetingmanagement.core.service.MeetingManagementServiceComponent;
import MeetingManagementVM.meetingmanagement.meetingdelta.service.MeetingManagementServiceImpl;

public class MeetingManagementResourceImpl extends MeetingManagementResourceDecorator {
	protected MeetingManagementServiceComponent recordComponent;
	private MeetingManagementServiceImpl meetingmanagementmeetingdeltaServiceImpl = new MeetingManagementServiceImpl(recordComponent);

    public MeetingManagementResourceImpl (MeetingManagementResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/meetingdelta/save")
    public List<HashMap<String,Object>> saveMeetingManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		MeetingManagement meetingmanagementmeetingdelta = createMeetingManagement(vmjExchange);
		return getAllMeetingManagement(vmjExchange);
	}

    public MeetingManagement createMeetingManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			MeetingManagement result = meetingmanagementmeetingdeltaServiceImpl.createMeetingManagement(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public MeetingManagement createMeetingManagement(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			MeetingManagement result = meetingmanagementmeetingdeltaServiceImpl.createMeetingManagement(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/meetingdelta/update")
    public HashMap<String, Object> updateMeetingManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return meetingmanagementmeetingdeltaServiceImpl.updateMeetingManagement(requestBody);
	}

	
    @Route(url="call/meetingdelta/detail")
    public HashMap<String, Object> getMeetingManagement(VMJExchange vmjExchange){
		return record.getMeetingManagement(vmjExchange);
	}

	
    @Route(url="call/meetingdelta/list")
    public List<HashMap<String,Object>> getAllMeetingManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return meetingmanagementmeetingdeltaServiceImpl.getAllMeetingManagement();
	}

    public List<HashMap<String,Object>> transformMeetingManagementListToHashMap(List<MeetingManagement> MeetingManagementMeetingDeltaList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < MeetingManagementMeetingDeltaList.size(); i++) {
            resultList.add(MeetingManagementMeetingDeltaList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/meetingdelta/delete")
    public List<HashMap<String,Object>> deleteMeetingManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return meetingmanagementmeetingdeltaServiceImpl.deleteMeetingManagement(requestBody);
	}

	
}
