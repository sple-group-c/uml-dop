package BeritaBoardVM.beritaboard.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface BeritaBoard {
	    public int getBeritaid();
	    public void setBeritaid(int beritaid);
	    public String getContent();
	    public void setContent(String content);
	HashMap<String, Object> toHashMap();
}
