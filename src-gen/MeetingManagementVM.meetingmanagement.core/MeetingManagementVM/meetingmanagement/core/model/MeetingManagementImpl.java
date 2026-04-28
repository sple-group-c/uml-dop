package MeetingManagementVM.meetingmanagement.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="meetingmanagement_impl")
@Table(name="meetingmanagement_impl")
public class MeetingManagementImpl extends MeetingManagementComponent {

	public MeetingManagementImpl(int idMeeting, String name, String startDate, String endDate, String location) {
		this.idMeeting = idMeeting;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
	}

	public MeetingManagementImpl(String name, String startDate, String endDate, String location) {
		Random r = new Random();
		this.idMeeting = Math.abs(r.nextInt());
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
	}

	public MeetingManagementImpl() { }

	public int getIdMeeting() {
		return this.idMeeting;
	}

	public void setIdMeeting(int idMeeting) {
		this.idMeeting = idMeeting;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> meetingmanagementMap = new HashMap<String,Object>();
		meetingmanagementMap.put("idMeeting",getIdMeeting());
		meetingmanagementMap.put("name",getName());
		meetingmanagementMap.put("startDate",getStartDate());
		meetingmanagementMap.put("endDate",getEndDate());
		meetingmanagementMap.put("location",getLocation());

        return meetingmanagementMap;
    }

}
