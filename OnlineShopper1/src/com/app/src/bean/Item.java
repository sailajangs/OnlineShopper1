package com.app.src.bean;

import java.io.Serializable;

public class Item implements Serializable {

	
	private String item;
	private String search;

	    public String getSearch() {
	        return search;
	    }

	    public void setSearch(String search) {
	        this.search = search;
	    }


	    public String getItem() {
	        return item;
	    }

	    public void setItem(String item) {
	        this.item = item;
	    }

}
