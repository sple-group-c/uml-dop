package MeetingManagementVM.meetingmanagement.projectmeetingdelta.resource;
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
import MeetingManagementVM.meetingmanagement.projectmeetingdelta.service.MeetingManagementServiceImpl;

public class MeetingManagementResourceImpl extends MeetingManagementResourceDecorator {
	protected MeetingManagementServiceComponent recordComponent;
	private MeetingManagementServiceImpl meetingmanagementprojectmeetingdeltaServiceImpl = new MeetingManagementServiceImpl(recordComponent);

    public MeetingManagementResourceImpl (MeetingManagementResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/projectmeetingdelta/save")
    public List<HashMap<String,Object>> saveMeetingManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		MeetingManagement meetingmanagementprojectmeetingdelta = createMeetingManagement(vmjExchange);
		return getAllMeetingManagement(vmjExchange);
	}

    public MeetingManagement createMeetingManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			MeetingManagement result = meetingmanagementprojectmeetingdeltaServiceImpl.createMeetingManagement(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public MeetingManagement createMeetingManagement(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			MeetingManagement result = meetingmanagementprojectmeetingdeltaServiceImpl.createMeetingManagement(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/projectmeetingdelta/update")
    public HashMap<String, Object> updateMeetingManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return meetingmanagementprojectmeetingdeltaServiceImpl.updateMeetingManagement(requestBody);
	}

	
    @Route(url="call/projectmeetingdelta/detail")
    public HashMap<String, Object> getMeetingManagement(VMJExchange vmjExchange){
		return record.getMeetingManagement(vmjExchange);
	}

	
    @Route(url="call/projectmeetingdelta/list")
    public List<HashMap<String,Object>> getAllMeetingManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return meetingmanagementprojectmeetingdeltaServiceImpl.getAllMeetingManagement();
	}

    public List<HashMap<String,Object>> transformMeetingManagementListToHashMap(List<MeetingManagement> MeetingManagementProjectMeetingDeltaList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < MeetingManagementProjectMeetingDeltaList.size(); i++) {
            resultList.add(MeetingManagementProjectMeetingDeltaList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/projectmeetingdelta/delete")
    public List<HashMap<String,Object>> deleteMeetingManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return meetingmanagementprojectmeetingdeltaServiceImpl.deleteMeetingManagement(requestBody);
	}

	
}
