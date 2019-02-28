package com.ji.event;

public class Event {
	
	private Long id; 
	private String name; 
	private EventType type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EventType getType() {
		return type;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	
	public static Event create(Long id, String name, EventType type) {
		Event result = new Event();
		result.id = id;
		result.name = name;
		result.type = type;
		return result;
	}

}
