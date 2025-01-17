package com.irct.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irct.entity.IRCTC;
import com.irct.service.IRCTCService;

@RestController
@RequestMapping("/IRCTC")
public class IRCTCController {
	@Autowired
	private IRCTCService irctcser;
	@PostMapping("/add")
	public ResponseEntity<String> saveIRCTCintoDB(@RequestBody IRCTC irctc){
		String addticket =irctcser.addTicket(irctc);
		return new ResponseEntity<>(addticket,HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<IRCTC> getticket(@PathVariable Integer id){
		IRCTC tickettbyId =irctcser.getTicketById(id);
		return new ResponseEntity<>(tickettbyId,HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<IRCTC>> getAllTicketById(@RequestParam(name="length", required = false)Long length){
		List<IRCTC>irctclist =irctcser.getAllTicketById(length);
		if(length==null) {
			return new ResponseEntity<>(irctclist.stream().limit(10).collect(Collectors.toList()),HttpStatus.OK);	
		}else {
			return new ResponseEntity<>(irctclist.stream().limit(length).collect(Collectors.toList()),HttpStatus.OK);	
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<IRCTC>upadteIRCTC(@RequestBody IRCTC irctc, @PathVariable Integer id){
		IRCTC updateTicket =irctcser.updateTicket(irctc,id);
		return new ResponseEntity<>(updateTicket,HttpStatus.ACCEPTED);
	}
	@PatchMapping("/update/{id}")
	public ResponseEntity<IRCTC> updateTicketByfield(@RequestBody Map<String, Object> fields,@PathVariable Integer id){
		IRCTC updateTicketByfield =irctcser.updateTicketByfield(fields, id);
		return new ResponseEntity<>(updateTicketByfield,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Integer> deleteTicket(@PathVariable Integer id){
		irctcser.deleteTicket(id);
		
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
