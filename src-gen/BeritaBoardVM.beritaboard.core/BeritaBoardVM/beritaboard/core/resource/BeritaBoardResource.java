package BeritaBoardVM.beritaboard.core.resource;
import java.util.*;

import BeritaBoardVM.beritaboard.core.model.BeritaBoard;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface BeritaBoardResource {
    List<HashMap<String,Object>> saveBeritaBoard(VMJExchange vmjExchange);
    HashMap<String, Object> updateBeritaBoard(VMJExchange vmjExchange);
    HashMap<String, Object> getBeritaBoard(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllBeritaBoard(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteBeritaBoard(VMJExchange vmjExchange);
}
