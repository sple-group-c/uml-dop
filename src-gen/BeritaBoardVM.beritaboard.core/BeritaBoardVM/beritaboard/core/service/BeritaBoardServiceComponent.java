package BeritaBoardVM.beritaboard.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import BeritaBoardVM.beritaboard.core.model.BeritaBoard;
//add other required packages

public abstract class BeritaBoardServiceComponent implements BeritaBoardService{
	protected RepositoryUtil<BeritaBoard> Repository;

    public BeritaBoardServiceComponent(){
        this.Repository = new RepositoryUtil<BeritaBoard>(BeritaBoardVM.beritaboard.core.model.BeritaBoardComponent.class);
    }	

    public abstract BeritaBoard createBeritaBoard(Map<String, Object> requestBody);
	public abstract BeritaBoard createBeritaBoard(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateBeritaBoard(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getBeritaBoard(String idStr);
    public abstract List<HashMap<String,Object>> getAllBeritaBoard();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<BeritaBoard> List);
    public abstract List<HashMap<String,Object>> deleteBeritaBoard(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getBeritaBoardById(int id);

}
