package LabelVM.label.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import LabelVM.label.core.model.Label;

public abstract class LabelResourceDecorator extends LabelResourceComponent{
	protected LabelResourceComponent record;

    public LabelResourceDecorator(LabelResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveLabel(VMJExchange vmjExchange){
		return record.saveLabel(vmjExchange);
	}

    public Label createLabel(VMJExchange vmjExchange){
		return record.createLabel(vmjExchange);
	}
	
	public Label createLabel(VMJExchange vmjExchange, int id){
		return record.createLabel(vmjExchange, id);
	}

    public HashMap<String, Object> updateLabel(VMJExchange vmjExchange){
		return record.updateLabel(vmjExchange);
	}

    public HashMap<String, Object> getLabel(VMJExchange vmjExchange){
		return record.getLabel(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllLabel(VMJExchange vmjExchange){
		return record.getAllLabel(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteLabel(VMJExchange vmjExchange){
		return record.deleteLabel(vmjExchange);
	}

}
