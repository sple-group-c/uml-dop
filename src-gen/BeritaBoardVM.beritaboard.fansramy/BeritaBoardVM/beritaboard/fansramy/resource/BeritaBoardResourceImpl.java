package BeritaBoardVM.beritaboard.fansramy.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import BeritaBoardVM.beritaboard.core.resource.BeritaBoardResourceDecorator;
import BeritaBoardVM.beritaboard.core.resource.BeritaBoardResourceComponent;
import BeritaBoardVM.beritaboard.core.model.BeritaBoard;
import BeritaBoardVM.beritaboard.core.model.BeritaBoardImpl;
import BeritaBoardVM.beritaboard.core.service.BeritaBoardServiceComponent;
import BeritaBoardVM.beritaboard.fansramy.service.BeritaBoardServiceImpl;

public class BeritaBoardResourceImpl extends BeritaBoardResourceDecorator {
	protected BeritaBoardServiceComponent recordComponent;
	private BeritaBoardServiceImpl beritaboardfansramyServiceImpl = new BeritaBoardServiceImpl(recordComponent);

    public BeritaBoardResourceImpl (BeritaBoardResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/fansramy/save")
    public List<HashMap<String,Object>> saveBeritaBoard(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		BeritaBoard beritaboardfansramy = createBeritaBoard(vmjExchange);
		return getAllBeritaBoard(vmjExchange);
	}

    public BeritaBoard createBeritaBoard(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BeritaBoard result = beritaboardfansramyServiceImpl.createBeritaBoard(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public BeritaBoard createBeritaBoard(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BeritaBoard result = beritaboardfansramyServiceImpl.createBeritaBoard(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/fansramy/update")
    public HashMap<String, Object> updateBeritaBoard(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return beritaboardfansramyServiceImpl.updateBeritaBoard(requestBody);
	}

	
    @Route(url="call/fansramy/detail")
    public HashMap<String, Object> getBeritaBoard(VMJExchange vmjExchange){
		return record.getBeritaBoard(vmjExchange);
	}

	
    @Route(url="call/fansramy/list")
    public List<HashMap<String,Object>> getAllBeritaBoard(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return beritaboardfansramyServiceImpl.getAllBeritaBoard();
	}

    public List<HashMap<String,Object>> transformBeritaBoardListToHashMap(List<BeritaBoard> BeritaBoardFansramyList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < BeritaBoardFansramyList.size(); i++) {
            resultList.add(BeritaBoardFansramyList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/fansramy/delete")
    public List<HashMap<String,Object>> deleteBeritaBoard(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return beritaboardfansramyServiceImpl.deleteBeritaBoard(requestBody);
	}

	
}
