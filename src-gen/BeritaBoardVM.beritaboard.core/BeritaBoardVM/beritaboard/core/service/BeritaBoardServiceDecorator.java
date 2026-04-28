package BeritaBoardVM.beritaboard.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import BeritaBoardVM.beritaboard.core.model.BeritaBoard;

public abstract class BeritaBoardServiceDecorator extends BeritaBoardServiceComponent{
	protected BeritaBoardServiceComponent record;

    public BeritaBoardServiceDecorator(BeritaBoardServiceComponent record) {
        this.record = record;
    }

	public BeritaBoard createBeritaBoard(Map<String, Object> requestBody){
		return record.createBeritaBoard(requestBody);
	}
	
	public BeritaBoard createBeritaBoard(Map<String, Object> requestBody, int id){
		return record.createBeritaBoard(requestBody, id);
	}

	public HashMap<String, Object> getBeritaBoard(String idStr){
		return record.getBeritaBoard(idStr);
	}

	public List<HashMap<String,Object>> getAllBeritaBoard(){
		return record.getAllBeritaBoard();
	}

    public HashMap<String, Object> updateBeritaBoard(Map<String, Object> requestBody){
		return record.updateBeritaBoard(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<BeritaBoard> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteBeritaBoard(Map<String, Object> requestBody){
		return record.deleteBeritaBoard(requestBody);
	}

	public HashMap<String, Object> getBeritaBoardById(int id){
        return record.getBeritaBoardById(id);
    }

}
