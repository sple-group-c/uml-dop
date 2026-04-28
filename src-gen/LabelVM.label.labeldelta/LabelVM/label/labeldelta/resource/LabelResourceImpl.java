package LabelVM.label.labeldelta.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import LabelVM.label.core.resource.LabelResourceDecorator;
import LabelVM.label.core.resource.LabelResourceComponent;
import LabelVM.label.core.model.Label;
import LabelVM.label.core.model.LabelImpl;
import LabelVM.label.core.service.LabelServiceComponent;
import LabelVM.label.labeldelta.service.LabelServiceImpl;

public class LabelResourceImpl extends LabelResourceDecorator {
	protected LabelServiceComponent recordComponent;
	private LabelServiceImpl labellabeldeltaServiceImpl = new LabelServiceImpl(recordComponent);

    public LabelResourceImpl (LabelResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/labeldelta/save")
    public List<HashMap<String,Object>> saveLabel(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Label labellabeldelta = createLabel(vmjExchange);
		return getAllLabel(vmjExchange);
	}

    public Label createLabel(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Label result = labellabeldeltaServiceImpl.createLabel(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Label createLabel(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Label result = labellabeldeltaServiceImpl.createLabel(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/labeldelta/update")
    public HashMap<String, Object> updateLabel(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return labellabeldeltaServiceImpl.updateLabel(requestBody);
	}

	
    @Route(url="call/labeldelta/detail")
    public HashMap<String, Object> getLabel(VMJExchange vmjExchange){
		return record.getLabel(vmjExchange);
	}

	
    @Route(url="call/labeldelta/list")
    public List<HashMap<String,Object>> getAllLabel(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return labellabeldeltaServiceImpl.getAllLabel();
	}

    public List<HashMap<String,Object>> transformLabelListToHashMap(List<Label> LabelLabelDeltaList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < LabelLabelDeltaList.size(); i++) {
            resultList.add(LabelLabelDeltaList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/labeldelta/delete")
    public List<HashMap<String,Object>> deleteLabel(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return labellabeldeltaServiceImpl.deleteLabel(requestBody);
	}

	
}
