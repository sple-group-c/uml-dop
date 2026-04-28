package LabelVM.label.core.resource;
import java.util.*;

import LabelVM.label.core.model.Label;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface LabelResource {
    List<HashMap<String,Object>> saveLabel(VMJExchange vmjExchange);
    HashMap<String, Object> updateLabel(VMJExchange vmjExchange);
    HashMap<String, Object> getLabel(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllLabel(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteLabel(VMJExchange vmjExchange);
}
