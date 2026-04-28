package MeetingManagementVM.meetingmanagement.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class MeetingManagementDecorator extends MeetingManagementComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected MeetingManagementComponent record;

	public MeetingManagementDecorator () {
		super();
		Random r = new Random();
		this.idMeeting = Math.abs(r.nextInt());
	}

	public MeetingManagementDecorator (int idMeeting, MeetingManagementComponent record) {
		this.idMeeting =  idMeeting;
		this.record = record;
	}
	
	public MeetingManagementDecorator (MeetingManagementComponent record, String objectName) {
		Random r = new Random();
		this.idMeeting = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getIdMeeting() {
		return record.getIdMeeting();
	}
	public void setIdMeeting(int idMeeting) {
		record.setIdMeeting(idMeeting);
	}
	public String getName() {
		return record.getName();
	}
	public void setName(String name) {
		record.setName(name);
	}
	public String getStartDate() {
		return record.getStartDate();
	}
	public void setStartDate(String startDate) {
		record.setStartDate(startDate);
	}
	public String getEndDate() {
		return record.getEndDate();
	}
	public void setEndDate(String endDate) {
		record.setEndDate(endDate);
	}
	public String getLocation() {
		return record.getLocation();
	}
	public void setLocation(String location) {
		record.setLocation(location);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
