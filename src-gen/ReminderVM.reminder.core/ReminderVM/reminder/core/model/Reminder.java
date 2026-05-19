package ReminderVM.reminder.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Reminder {
	    public int getIdReminder();
	    public void setIdReminder(int idReminder);
	    public boolean getIsDisabled();
	    public void setIsDisabled(boolean isDisabled);
	    public int getHour();
	    public void setHour(int hour);
	    public int getMinute();
	    public void setMinute(int minute);
	    public int getRemindingForId();
	    public void setRemindingForId(int remindingForId);
	HashMap<String, Object> toHashMap();
}
