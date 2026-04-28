package MeetingManagementVM.meetingmanagement.meetingdelta.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import MeetingManagementVM.meetingmanagement.core.model.MeetingManagementDecorator;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagement;
import MeetingManagementVM.meetingmanagement.core.model.MeetingManagementComponent;

@Entity(name="meetingmanagement_meetingdelta")
@Table(name="meetingmanagement_meetingdelta")
public class MeetingManagementImpl extends MeetingManagementDecorator {

	public MeetingManagementImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = MeetingManagementImpl.class.getName();
    }

	public MeetingManagementImpl(MeetingManagementComponent record) {
		super(record, MeetingManagementImpl.class.getName());
		this.objectName = MeetingManagementImpl.class.getName();
	}



	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idMeeting", idMeeting);

        return map;
    }

}
