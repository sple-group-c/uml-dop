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
	    public int getResendIntervalMin();
	    public void setResendIntervalMin(int resendIntervalMin);
	    public int getHour();
	    public void setHour(int hour);
	    public int getMinute();
	    public void setMinute(int minute);
	HashMap<String, Object> toHashMap();
}
