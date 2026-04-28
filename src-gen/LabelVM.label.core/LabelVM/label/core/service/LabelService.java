package LabelVM.label.core.service;
import java.util.*;

import LabelVM.label.core.model.Label;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface LabelService {
	Label createLabel(Map<String, Object> requestBody);
	HashMap<String, Object> getLabel(String idStr);
    HashMap<String, Object> updateLabel(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllLabel();
    List<HashMap<String,Object>> deleteLabel(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Label> List);
}
