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


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;


@Root
public class TransducerValue {


	@Attribute
    private String id;
	
	@Attribute(required=false)
	private String name;
	
	@Attribute
    private String typedValue;
	
	@Attribute
    private String timestamp;
	
	@Attribute
    private String rawValue;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the typedValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypedValue() {
        return typedValue;
    }

    /**
     * Sets the value of the typedValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypedValue(String value) {
        this.typedValue = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the rawValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRawValue() {
        return rawValue;
    }

    /**
     * Sets the value of the rawValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRawValue(String value) {
        this.rawValue = value;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
