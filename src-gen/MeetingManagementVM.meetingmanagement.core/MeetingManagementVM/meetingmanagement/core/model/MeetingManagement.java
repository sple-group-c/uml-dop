package MeetingManagementVM.meetingmanagement.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface MeetingManagement {
	    public int getIdMeeting();
	    public void setIdMeeting(int idMeeting);
	    public String getName();
	    public void setName(String name);
	    public String getStartDate();
	    public void setStartDate(String startDate);
	    public String getEndDate();
	    public void setEndDate(String endDate);
	    public String getLocation();
	    public void setLocation(String location);
	HashMap<String, Object> toHashMap();
}
