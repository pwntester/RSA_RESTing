package org.pwntester.springjaxb.controller;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlRootElement(name="contact")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact {
	@XmlElement(required=true) 
	private String name;

	public String getName() {
	    return this.name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	@XmlElement(required=true) 
	private String lastName;

	public String getLastName() {
	    return this.lastName;
	}

	public void setLastName(String lastName) {
	    this.lastName = lastName;
	}
}

