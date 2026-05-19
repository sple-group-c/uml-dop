package BeritaBoardVM.beritaboard.subscription.model;

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

@Entity(name="beritaboard_subscription")
@Table(name="beritaboard_subscription")
public class BeritaBoardImpl extends BeritaBoardDecorator {

	protected boolean subscription;
	public BeritaBoardImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = BeritaBoardImpl.class.getName();
    }

	public BeritaBoardImpl(BeritaBoardComponent record, boolean subscription) {
		super(record, BeritaBoardImpl.class.getName());
		this.subscription = subscription;
		this.objectName = BeritaBoardImpl.class.getName();
	}

	public boolean getSubscription() {
		return this.subscription;
	}

	public void setSubscription(boolean subscription) {
		this.subscription = subscription;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("beritaid", beritaid);
		map.put("subscription", getSubscription());

        return map;
    }

}
