/* Licensed under the Apache License, Version 2.0 (the "License"); you may not
* use this file except in compliance with the License. You may obtain a copy of
* the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations under
* the License.
* By Takuro Yonezawa
*/

package org.jabber.protocol.sox;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class Device{


	@Element (required=false)
    private Geoloc geoloc;
	
	
	@ElementList (inline=true,required=true)
    private List<Transducer> transducer;

	@ElementList (inline=true,required=false)
    private List<Property> property;
    
	@Attribute(required = true)
    private String name;
    
	@Attribute(required = true)
    private String id;
    
	@Attribute(required = true)
    private DeviceType type;
    
	@Attribute (required = false)
    private Date timestamp;
    
	@Attribute (required = false)
    private String description;
    
	@Attribute (required = false)
    private String serialNumber;
	
    public List<Transducer> getTransducer() {
        if (transducer == null) {
            transducer = new ArrayList<Transducer>();
        }
        return this.transducer;
    }

    
    public Geoloc getGeoloc() {
       
        return this.geoloc;
    }
    
    public void setGeoloc(Geoloc _geoloc){
    	geoloc = _geoloc;
    }

    public List<Property> getProperty() {
        if (property == null) {
            property = new ArrayList<Property>();
        }
        return this.property;
    }

   
    public String getName() {
        return name;
    }

    
    public void setName(String value) {
        this.name = value;
    }

    
    public String getId() {
        return id;
    }

   
    public void setId(String value) {
        this.id = value;
    }

    public DeviceType getType() {
        return type;
    }

    
    public void setType(DeviceType value) {
        this.type = value;
    }

    
    public Date getTimestamp() {
        return timestamp;
    }

    
    public void setTimestamp(Date value) {
        this.timestamp = value;
    }

    
    public String getDescription() {
        return description;
    }

    
    public void setDescription(String value) {
        this.description = value;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String value) {
        this.serialNumber = value;
    }

}
