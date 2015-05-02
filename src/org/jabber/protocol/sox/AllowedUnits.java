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

public enum AllowedUnits {

    METER("meter"),
    GRAM("gram"),
    SECOND("second"),
    AMPERE("ampere"),
    KELVIN("kelvin"),
    MOLE("mole"),
    CANDELA("candela"),
    RADIAN("radian"),
    STERADIAN("steradian"),
    HERTZ("hertz"),
    NEWTON("newton"),
    PASCAL("pascal"),
    JOULE("joule"),
    WATT("watt"),
    COULOMB("coulomb"),
    VOLT("volt"),
    FARAD("farad"),
    OHM("ohm"),
    SIEMENS("siemens"),
    WEBER("weber"),
    TESLA("tesla"),
    HENRY("henry"),
    LUMEN("lumen"),
    LUX("lux"),
    BECQUEREL("becquerel"),
    GRAY("gray"),
    SIEVERT("sievert"),
    KATAL("katal"),
    LITER("liter"),
    SQUARE_METER("square meter"),
    CUBIC_METER("cubic meter"),
    METER_PER_SECOND("meter per second"),
    METER_PER_SECOND_SQUARED("meter per second squared"),
    RECIPROCAL_METER("reciprocal meter"),
    KILOGRAM_PER_CUBIC_METER("kilogram per cubic meter"),
    CUBIC_METER_PER_KILOGRAM("cubic meter per kilogram"),
    AMPERE_PER_SQUARE_METER("ampere per square meter"),
    AMPERE_PER_METER("ampere per meter"),
    MOLE_PER_CUBIC_METER("mole per cubic meter"),
    CANDELA_PER_SQUARE_METER("candela per square meter"),
    KILOGRAM_PER_KILOGRAM("kilogram per kilogram"),
    VOLT_AMPERE_REACTIVE("volt-ampere reactive"),
    VOLT_AMPERE("volt-ampere"),
    WATT_SECOND("watt second"),
    PERCENT("percent"),
    ENUM("enum"),
    LAT("lat"),
    LON("lon"),
    OTHER("other");

    private final String value;

    AllowedUnits(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AllowedUnits fromValue(String v) {
        for (AllowedUnits c: AllowedUnits.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
