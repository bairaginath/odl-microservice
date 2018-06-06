package com.aricent.northbound;

import java.util.List;
import java.util.ArrayList;

public class Database {
	
	private static List<Link> links = new ArrayList<>(); 
	
	private static Database instance = new Database();
	
	public static Database getInstance() {
		return instance;
	}
	
	public List<Link> getLinks() {
		return links;
	}
	
	public void createLink(Link link) {
		links.add(link);
	}
	
	public boolean removeLink(Link link) {
		return links.add(link);
	} 
	
}
