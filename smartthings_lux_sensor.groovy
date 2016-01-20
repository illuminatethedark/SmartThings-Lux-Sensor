/**
 *  Arduino Lux Sensor
 *
 *  Copyright 2016 Daniel Marcus
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */

metadata {
	definition (name: "Arduino Lux Sensor", namespace: "illuminatethedark", author: "Daniel Marcus") {
        capability "Illuminance Measurement"
        }

	simulator {
    	}

	tiles {
		valueTile("illuminance", "device.illuminance", width: 2, height: 2, canChangeIcon: false, canChangeBackground: false) {
			state("illuminance", label: '${currentValue}', backgroundColors:[
					[value: 9, color: "#767676"],
					[value: 315, color: "#ffa81e"],
					[value: 1000, color: "#fbd41b"]
				]
                )
		}

        standardTile("refresh", "device.refresh", inactiveLabel: false, decoration: "flat") {
			state "default", icon:"st.secondary.refresh"
		}
	}
    
    main "illuminance"
    details "illuminance"
}

// Parse incoming device messages to generate events
def parse(String description) {
	log.trace description
	def result = createEvent(name: "illuminance", value: zigbee.parse(description)?.text as Double)
    log.debug result?.descriptionText
    return result
}