package org.jabber.protocol.sox;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root
public class DeviceID {

	@Attribute
    private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
