package com.vishal.parkinglot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vishal.parkinglot.jsonobject.ParkingJSON;
import com.vishal.parkinglot.jsonobject.SlotFlag;
import com.vishal.parkinglot.service.ParkingService;

@RestController
public class ParkinglotController {

	@Autowired
	private ParkingService parkingService;

	@GetMapping("/greetings")
	public String greetings() {
		return "greetings";
	}

	@GetMapping("/slotDisplay")
	public List<SlotFlag> slotDisplay() {
		return parkingService.slotDisplay();
	}

	@GetMapping("/check-in/{slotNumber}/{vehicleNo}")
	public boolean checkIn(@PathVariable(value = "slotNumber") String slotNumber,
			@PathVariable(value = "vehicleNo") String vehicleNo) {

		return parkingService.checkIn(slotNumber, vehicleNo);
	}
	
	@GetMapping("/check-out/{vehicleNo}")
	public ParkingJSON checkOut(@PathVariable(value = "vehicleNo") String vehicleNo) {

		return parkingService.checkOut(vehicleNo);
		
	}
	
	@GetMapping("/paid/{vehicleNo}")
	public boolean paid(@PathVariable(value = "vehicleNo") String vehicleNo) {

		return parkingService.paid(vehicleNo);
	}

}
