package BeritaBoardVM.beritaboard.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class BeritaBoardDecorator extends BeritaBoardComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected BeritaBoardComponent record;

	public BeritaBoardDecorator () {
		super();
		Random r = new Random();
		this.beritaid = Math.abs(r.nextInt());
	}

	public BeritaBoardDecorator (int beritaid, BeritaBoardComponent record) {
		this.beritaid =  beritaid;
		this.record = record;
	}
	
	public BeritaBoardDecorator (BeritaBoardComponent record, String objectName) {
		Random r = new Random();
		this.beritaid = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getBeritaid() {
		return record.getBeritaid();
	}
	public void setBeritaid(int beritaid) {
		record.setBeritaid(beritaid);
	}
	public String getContent() {
		return record.getContent();
	}
	public void setContent(String content) {
		record.setContent(content);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
