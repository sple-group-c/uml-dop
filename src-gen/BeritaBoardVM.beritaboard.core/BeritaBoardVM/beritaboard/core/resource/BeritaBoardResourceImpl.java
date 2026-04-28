package BeritaBoardVM.beritaboard.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import BeritaBoardVM.beritaboard.BeritaBoardFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import BeritaBoardVM.beritaboard.core.model.BeritaBoard;
import BeritaBoardVM.beritaboard.core.service.BeritaBoardServiceImpl;
//add other required packages


public class BeritaBoardResourceImpl extends BeritaBoardResourceComponent{
	
	private BeritaBoardServiceImpl beritaboardServiceImpl = new BeritaBoardServiceImpl();

	
    @Route(url="call/beritaboard/save")
    public List<HashMap<String,Object>> saveBeritaBoard(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		BeritaBoard beritaboard = createBeritaBoard(vmjExchange);
		return beritaboardServiceImpl.getAllBeritaBoard();
	}

    public BeritaBoard createBeritaBoard(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BeritaBoard result = beritaboardServiceImpl.createBeritaBoard(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public BeritaBoard createBeritaBoard(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BeritaBoard result = beritaboardServiceImpl.createBeritaBoard(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/beritaboard/update")
    public HashMap<String, Object> updateBeritaBoard(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return beritaboardServiceImpl.updateBeritaBoard(requestBody);
		
	}

	
    @Route(url="call/beritaboard/detail")
    public HashMap<String, Object> getBeritaBoard(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("beritaid");
		return beritaboardServiceImpl.getBeritaBoard(idStr);
	}

	
    @Route(url="call/beritaboard/list")
    public List<HashMap<String,Object>> getAllBeritaBoard(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return beritaboardServiceImpl.getAllBeritaBoard();
	}

	
    @Route(url="call/beritaboard/delete")
    public List<HashMap<String,Object>> deleteBeritaBoard(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return beritaboardServiceImpl.deleteBeritaBoard(requestBody);
	}


}
