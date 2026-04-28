package BeritaBoardVM.beritaboard.fansramy.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import BeritaBoardVM.beritaboard.core.service.BeritaBoardServiceDecorator;
import BeritaBoardVM.beritaboard.core.model.BeritaBoardImpl;
import BeritaBoardVM.beritaboard.core.service.BeritaBoardServiceComponent;
import BeritaBoardVM.beritaboard.core.model.BeritaBoard;
import BeritaBoardVM.beritaboard.core.model.BeritaBoardDecorator;
import BeritaBoardVM.beritaboard.BeritaBoardFactory;

public class BeritaBoardServiceImpl extends BeritaBoardServiceDecorator {
    public BeritaBoardServiceImpl (BeritaBoardServiceComponent record) {
        super(record);
    }

 	public BeritaBoard createBeritaBoard(Map<String, Object> requestBody){
		String beritaidStr = (String) requestBody.get("beritaid");
		int beritaid = Integer.parseInt(beritaidStr);
		String content = (String) requestBody.get("content");
		BeritaBoard beritaboardfansramy = record.createBeritaBoard(requestBody);
		BeritaBoard beritaboardfansramydeco = BeritaBoardFactory.createBeritaBoard("BeritaBoardVM.beritaboard.fansramy", beritaboardfansramy, beritaid, content);
		Repository.saveObject(beritaboardfansramydeco);
		return beritaboardfansramydeco;
	}

	public BeritaBoard createBeritaBoard(Map<String, Object> requestBody, int id){
		BeritaBoard savedBeritaBoard = Repository.getObject(id);
		String beritaidStr = (String) requestBody.get("beritaid");
		int beritaid = Integer.parseInt(beritaidStr);
		String content = (String) requestBody.get("content");
		UUID recordBeritaBoardBeritaid = ((BeritaBoardDecorator) savedBeritaBoard).getBeritaid();
		BeritaBoard BeritaBoard = record.createBeritaBoard(requestBody, recordBeritaBoardBeritaid);
		BeritaBoard beritaboardfansramy = BeritaBoardFactory.createBeritaBoard("BeritaBoardVM.beritaboard.fansramy.model.BeritaBoardImpl", BeritaBoard, beritaid, content);
		return beritaboardfansramy;
	}

    public HashMap<String, Object> updateBeritaBoard(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("beritaid");
		
		BeritaBoard beritaboardfansramy = Repository.getObject(id);
		beritaboardfansramy = createBeritaBoard(requestBody, id);
		
		Repository.updateObject(beritaboardfansramy);
		beritaboardfansramy = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return beritaboardfansramy.toHashMap();
	}

	public HashMap<String, Object> getBeritaBoard(String idStr){
		int id = Integer.parseInt(idStr);
		BeritaBoard beritaboardfansramy = Repository.getObject(id);
		return beritaboardfansramy.toHashMap();
	}

	public HashMap<String, Object> getBeritaBoardById(int id){
		List<HashMap<String, Object>> beritaboardList = getAllBeritaBoard();
		for (HashMap<String, Object> beritaboard : beritaboardList){
			int beritaboard_id = ((Double) beritaboard.get("beritaid")).intValue();
			if (beritaboard_id == id){
				return beritaboard;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllBeritaBoard(){
		List<BeritaBoard> List = Repository.getAllObject("beritaboard_fansramy");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<BeritaBoard> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteBeritaBoard(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("beritaid"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllBeritaBoard();
	}

	
}
