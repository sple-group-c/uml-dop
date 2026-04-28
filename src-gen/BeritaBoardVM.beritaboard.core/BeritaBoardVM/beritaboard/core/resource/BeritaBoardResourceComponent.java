package BeritaBoardVM.beritaboard.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import BeritaBoardVM.beritaboard.core.model.BeritaBoard;
//add other required packages

public abstract class BeritaBoardResourceComponent implements BeritaBoardResource{
	
	public BeritaBoardResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveBeritaBoard(VMJExchange vmjExchange);
    public abstract BeritaBoard createBeritaBoard(VMJExchange vmjExchange);
	public abstract BeritaBoard createBeritaBoard(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateBeritaBoard(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getBeritaBoard(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllBeritaBoard(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteBeritaBoard(VMJExchange vmjExchange);

}
