package LabelVM.label.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import LabelVM.label.LabelFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import LabelVM.label.core.model.Label;
import LabelVM.label.core.service.LabelServiceImpl;
//add other required packages


public class LabelResourceImpl extends LabelResourceComponent{
	
	private LabelServiceImpl labelServiceImpl = new LabelServiceImpl();

	
    @Route(url="call/label/save")
    public List<HashMap<String,Object>> saveLabel(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Label label = createLabel(vmjExchange);
		return labelServiceImpl.getAllLabel();
	}

    public Label createLabel(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Label result = labelServiceImpl.createLabel(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Label createLabel(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Label result = labelServiceImpl.createLabel(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/label/update")
    public HashMap<String, Object> updateLabel(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return labelServiceImpl.updateLabel(requestBody);
		
	}

	
    @Route(url="call/label/detail")
    public HashMap<String, Object> getLabel(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("idLabel");
		return labelServiceImpl.getLabel(idStr);
	}

	
    @Route(url="call/label/list")
    public List<HashMap<String,Object>> getAllLabel(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return labelServiceImpl.getAllLabel();
	}

	
    @Route(url="call/label/delete")
    public List<HashMap<String,Object>> deleteLabel(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return labelServiceImpl.deleteLabel(requestBody);
	}


}
