package BeritaBoardVM.beritaboard.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import BeritaBoardVM.beritaboard.core.model.BeritaBoard;

public abstract class BeritaBoardResourceDecorator extends BeritaBoardResourceComponent{
	protected BeritaBoardResourceComponent record;

    public BeritaBoardResourceDecorator(BeritaBoardResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveBeritaBoard(VMJExchange vmjExchange){
		return record.saveBeritaBoard(vmjExchange);
	}

    public BeritaBoard createBeritaBoard(VMJExchange vmjExchange){
		return record.createBeritaBoard(vmjExchange);
	}
	
	public BeritaBoard createBeritaBoard(VMJExchange vmjExchange, int id){
		return record.createBeritaBoard(vmjExchange, id);
	}

    public HashMap<String, Object> updateBeritaBoard(VMJExchange vmjExchange){
		return record.updateBeritaBoard(vmjExchange);
	}

    public HashMap<String, Object> getBeritaBoard(VMJExchange vmjExchange){
		return record.getBeritaBoard(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllBeritaBoard(VMJExchange vmjExchange){
		return record.getAllBeritaBoard(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteBeritaBoard(VMJExchange vmjExchange){
		return record.deleteBeritaBoard(vmjExchange);
	}

}
