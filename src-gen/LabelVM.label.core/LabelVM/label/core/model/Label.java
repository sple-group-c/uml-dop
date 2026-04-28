package LabelVM.label.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Label {
	    public int getIdLabel();
	    public void setIdLabel(int idLabel);
	    public String getName();
	    public void setName(String name);
	    public String getDescription();
	    public void setDescription(String description);
	HashMap<String, Object> toHashMap();
}
