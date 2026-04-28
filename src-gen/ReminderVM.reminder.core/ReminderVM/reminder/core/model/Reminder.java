package ReminderVM.reminder.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Reminder {
	    public int getIdReminder();
	    public void setIdReminder(int idReminder);
	    public String getIsDisabled();
	    public void setIsDisabled(String isDisabled);
	    public int getResendIntervalMin();
	    public void setResendIntervalMin(int resendIntervalMin);
	    public String getTimeTrigger();
	    public void setTimeTrigger(String timeTrigger);
	HashMap<String, Object> toHashMap();
}
