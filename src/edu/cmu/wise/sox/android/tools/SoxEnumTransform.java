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

package edu.cmu.wise.sox.android.tools;

import org.jabber.protocol.sox.AllowedUnits;
import org.jabber.protocol.sox.DeviceType;
import org.simpleframework.xml.transform.Transform;


public class SoxEnumTransform implements Transform<Enum> {
	private final Class type;

	public SoxEnumTransform(Class type) {
		this.type = type;
	}

	public Enum read(String value) throws Exception {
		for (Object o : type.getEnumConstants()) {
			if(o instanceof DeviceType){
				return ((DeviceType) o).fromValue(value);
			}else if(o instanceof AllowedUnits){
				return ((AllowedUnits)o).fromValue(value);
			}

		}
		return null;
	}

	public String write(Enum value) throws Exception {

		for (Object o : type.getEnumConstants()) {
			if(o instanceof DeviceType){
				if(((DeviceType) o).name().equals(value.toString())){
					return ((DeviceType)o).value();
				}
			}else if(o instanceof AllowedUnits){
				if(((AllowedUnits) o).name().equals(value.toString())){
					return ((AllowedUnits)o).value();
				}
			}
		}

		return value.toString();
	}
}