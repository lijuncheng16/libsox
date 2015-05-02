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
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;


@Root
public class Data {

	@ElementList (inline=true,required=false) 
	private List<TransducerValue> transducerValue;
	
	@ElementList (inline=true,required=false) 
    private List<TransducerSetValue> transducerSetValue;

	@ElementList (inline=true,required=false) 
    private List<DeviceID> deviceID;
	
    public List<TransducerValue> getTransducerValue() {
        if (transducerValue == null) {
            transducerValue = new ArrayList<TransducerValue>();
        }
        return this.transducerValue;
    }

    public List<TransducerSetValue> getTransducerSetValue() {
        if (transducerSetValue == null) {
            transducerSetValue = new ArrayList<TransducerSetValue>();
        }
        return this.transducerSetValue;
    }

	public List<DeviceID> getDeviceID() {
		if (deviceID == null) {
			deviceID = new ArrayList<DeviceID>();
		}
		return deviceID;
	}

}
