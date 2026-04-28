package BeritaBoardVM.beritaboard.fansramy.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import BeritaBoardVM.beritaboard.core.model.BeritaBoardDecorator;
import BeritaBoardVM.beritaboard.core.model.BeritaBoard;
import BeritaBoardVM.beritaboard.core.model.BeritaBoardComponent;

@Entity(name="beritaboard_fansramy")
@Table(name="beritaboard_fansramy")
public class BeritaBoardImpl extends BeritaBoardDecorator {

	public BeritaBoardImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = BeritaBoardImpl.class.getName();
    }

	public BeritaBoardImpl(BeritaBoardComponent record) {
		super(record, BeritaBoardImpl.class.getName());
		this.objectName = BeritaBoardImpl.class.getName();
	}



	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("beritaid", beritaid);

        return map;
    }

}
