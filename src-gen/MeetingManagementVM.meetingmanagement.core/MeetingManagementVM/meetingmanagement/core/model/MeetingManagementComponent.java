package MeetingManagementVM.meetingmanagement.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="meetingmanagement_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MeetingManagementComponent implements MeetingManagement{
	@Id
	protected int idMeeting; 
	protected String name;
	protected String startDate;
	protected String endDate;
	protected String location;
	protected String objectName = MeetingManagementComponent.class.getName();

	public MeetingManagementComponent() {

	} 

	public MeetingManagementComponent(
        int idMeeting, String name, String startDate, String endDate, String location
    ) {
        this.idMeeting = idMeeting;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
    }

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
 

	@Override
    public String toString() {
        return "{" +
            " idMeeting='" + getIdMeeting() + "'" +
            " name='" + getName() + "'" +
            " startDate='" + getStartDate() + "'" +
            " endDate='" + getEndDate() + "'" +
            " location='" + getLocation() + "'" +
            "}";
    }
	
}
