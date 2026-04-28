package BeritaBoardVM.beritaboard.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="beritaboard_impl")
@Table(name="beritaboard_impl")
public class BeritaBoardImpl extends BeritaBoardComponent {

	public BeritaBoardImpl(int beritaid, String content) {
		this.beritaid = beritaid;
		this.content = content;
	}

	public BeritaBoardImpl(String content) {
		Random r = new Random();
		this.beritaid = Math.abs(r.nextInt());
		this.content = content;
	}

	public BeritaBoardImpl() { }

	public int getBeritaid() {
		return this.beritaid;
	}

	public void setBeritaid(int beritaid) {
		this.beritaid = beritaid;
	}
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> beritaboardMap = new HashMap<String,Object>();
		beritaboardMap.put("beritaid",getBeritaid());
		beritaboardMap.put("content",getContent());

        return beritaboardMap;
    }

}
