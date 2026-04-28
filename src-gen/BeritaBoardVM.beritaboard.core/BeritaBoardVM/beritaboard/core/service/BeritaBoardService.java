package BeritaBoardVM.beritaboard.core.service;
import java.util.*;

import BeritaBoardVM.beritaboard.core.model.BeritaBoard;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface BeritaBoardService {
	BeritaBoard createBeritaBoard(Map<String, Object> requestBody);
	HashMap<String, Object> getBeritaBoard(String idStr);
    HashMap<String, Object> updateBeritaBoard(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllBeritaBoard();
    List<HashMap<String,Object>> deleteBeritaBoard(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<BeritaBoard> List);
}
