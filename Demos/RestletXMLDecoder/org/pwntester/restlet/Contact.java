package org.pwntester.restlet;

import java.io.Serializable;

public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String name;
	public String lastName;
}
