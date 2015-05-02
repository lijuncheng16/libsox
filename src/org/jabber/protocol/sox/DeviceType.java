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



public enum DeviceType {

    INDOOR_WEATHER("indoor weather"),
    OUTDOOR_WEATHER("outdoor weather"),
    HVAC("hvac"),
    OCCUPANCY("occupancy"),
    MULTIMEDIA_INPUT("multimedia input"),
    MULTIMEDIA_OUTPUT("multimedia output"),
    SCALE("scale"),
    VEHICLE("vehicle"),
    RESOURCE_CONSUMPTION("resource consumption"),
    RESOURCE_GENERATION("resource generation"),
    OTHER("other");
    
    private final String value;

    DeviceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DeviceType fromValue(String v) {
        for (DeviceType c: DeviceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
