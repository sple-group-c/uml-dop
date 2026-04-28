package LabelVM.label.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import LabelVM.label.core.model.Label;
//add other required packages

public abstract class LabelResourceComponent implements LabelResource{
	
	public LabelResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveLabel(VMJExchange vmjExchange);
    public abstract Label createLabel(VMJExchange vmjExchange);
	public abstract Label createLabel(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateLabel(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getLabel(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllLabel(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteLabel(VMJExchange vmjExchange);

}
