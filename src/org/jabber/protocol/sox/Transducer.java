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


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Transducer {

	@Element(required=false) 
	private Geoloc geoloc;
	@ElementList (inline=true,required=false) 
	private List<Property> property;
	@Attribute(required = true)
	private String name;
	@Attribute(required = true)
	private String id;
	@Attribute(required = true)
	private AllowedUnits units;
	@Attribute(required = false)
	private BigInteger unitScaler;
	@Attribute(required = false)
	private Boolean canActuate;
	@Attribute(required = false)
	private Boolean hasOwnNode;
	@Attribute(required = false)
	private String transducerTypeName;
	@Attribute(required = false)
	private String manufacturer;
	@Attribute(required = false)
	private String partNumber;
	@Attribute(required = false)
	private String serialNumber;
	@Attribute(required = false)
	private Float minValue;
	@Attribute(required = false)
	private Float maxValue;
	@Attribute(required = false)
	private Float resolution;
	@Attribute(required = false)
	private Float precision;
	@Attribute(required = false)
	private Float accuracy;



	public Geoloc getGeoloc() {
		return geoloc;
	}

	public void setGeoloc(Geoloc value) {
		this.geoloc = value;
	}
	
	/**
	 * Gets the value of the property property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the property property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getProperty().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Property }
	 * 
	 * 
	 */
	public List<Property> getProperty() {
		if (property == null) {
			property = new ArrayList<Property>();
		}
		return this.property;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setName(String value) {
		this.name = value;
	}

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
	 * Gets the value of the units property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link AllowedUnits }
	 *     
	 */
	public AllowedUnits getUnits() {
		return units;
	}

	/**
	 * Sets the value of the units property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link AllowedUnits }
	 *     
	 */
	public void setUnits(AllowedUnits value) {
		this.units = value;
	}

	/**
	 * Gets the value of the unitScaler property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link BigInteger }
	 *     
	 */
	public BigInteger getUnitScaler() {
		if (unitScaler == null) {
			return new BigInteger("0");
		} else {
			return unitScaler;
		}
	}

	/**
	 * Sets the value of the unitScaler property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link BigInteger }
	 *     
	 */
	public void setUnitScaler(BigInteger value) {
		this.unitScaler = value;
	}

	/**
	 * Gets the value of the canActuate property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Boolean }
	 *     
	 */
	public boolean isCanActuate() {
		if (canActuate == null) {
			return false;
		} else {
			return canActuate;
		}
	}

	/**
	 * Sets the value of the canActuate property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Boolean }
	 *     
	 */
	public void setCanActuate(Boolean value) {
		this.canActuate = value;
	}

	/**
	 * Gets the value of the hasOwnNode property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Boolean }
	 *     
	 */
	public boolean isHasOwnNode() {
		if (hasOwnNode == null) {
			return false;
		} else {
			return hasOwnNode;
		}
	}

	/**
	 * Sets the value of the hasOwnNode property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Boolean }
	 *     
	 */
	public void setHasOwnNode(Boolean value) {
		this.hasOwnNode = value;
	}

	/**
	 * Gets the value of the transducerTypeName property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getTransducerTypeName() {
		return transducerTypeName;
	}

	/**
	 * Sets the value of the transducerTypeName property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setTransducerTypeName(String value) {
		this.transducerTypeName = value;
	}

	/**
	 * Gets the value of the manufacturer property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Sets the value of the manufacturer property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setManufacturer(String value) {
		this.manufacturer = value;
	}

	/**
	 * Gets the value of the partNumber property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getPartNumber() {
		return partNumber;
	}

	/**
	 * Sets the value of the partNumber property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setPartNumber(String value) {
		this.partNumber = value;
	}

	/**
	 * Gets the value of the serialNumber property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Sets the value of the serialNumber property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setSerialNumber(String value) {
		this.serialNumber = value;
	}

	/**
	 * Gets the value of the minValue property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Float }
	 *     
	 */
	public Float getMinValue() {
		return minValue;
	}

	/**
	 * Sets the value of the minValue property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Float }
	 *     
	 */
	public void setMinValue(Float value) {
		this.minValue = value;
	}

	/**
	 * Gets the value of the maxValue property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Float }
	 *     
	 */
	public Float getMaxValue() {
		return maxValue;
	}

	/**
	 * Sets the value of the maxValue property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Float }
	 *     
	 */
	public void setMaxValue(Float value) {
		this.maxValue = value;
	}

	/**
	 * Gets the value of the resolution property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Float }
	 *     
	 */
	public Float getResolution() {
		return resolution;
	}

	/**
	 * Sets the value of the resolution property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Float }
	 *     
	 */
	public void setResolution(Float value) {
		this.resolution = value;
	}

	/**
	 * Gets the value of the precision property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Float }
	 *     
	 */
	public Float getPrecision() {
		return precision;
	}

	/**
	 * Sets the value of the precision property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Float }
	 *     
	 */
	public void setPrecision(Float value) {
		this.precision = value;
	}

	/**
	 * Gets the value of the accuracy property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Float }
	 *     
	 */
	public Float getAccuracy() {
		return accuracy;
	}

	/**
	 * Sets the value of the accuracy property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Float }
	 *     
	 */
	public void setAccuracy(Float value) {
		this.accuracy = value;
	}

}
