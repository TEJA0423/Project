package com.irct.service;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.irct.entity.IRCTC;
import com.irct.repository.IRCTCRepository;

@Service
public class IRCTCServiceImp implements IRCTCService{
	@Autowired
  public IRCTCRepository ircrep;
	@Override
	public String addTicket(IRCTC irctc) {
		IRCTC irc = ircrep.save(irctc);
		if (irc.getTicketid() != null) {
			return "Ticket Booked Successfully";
		} else {
			return "Ticket Booked not created";
		}
	}

	@Override
	public IRCTC getTicketById(Integer id) {
		return ircrep.findById(id).orElseThrow(() -> new IllegalAccessError("IRCTC Record not created"));
	}

	@Override
	public List<IRCTC> getAllTicketById(Long length) {
		
		return ircrep.findAll();
	}

	@Override
	public IRCTC updateTicket(IRCTC irctc, Integer id) {
		IRCTC irctc1 = ircrep.findById(id).get();
		irctc1.setPersonname(irctc.getPersonname());
		irctc1.setGender(irctc.getGender());
		irctc1.setAge(irctc.getAge());
		irctc1.setStartingpoint(irctc.getStartingpoint());
		irctc1.setDestination(irctc.getDestination());
		irctc1.setPhoneNo(irctc.getPhoneNo());
		irctc1.setAmount(irctc.getAmount());
		return ircrep.save(irctc1);
		
	}

	@Override
	public IRCTC updateTicketByfield(Map<String, Object> fields, Integer id) {
		Optional<IRCTC> existingstudent = ircrep.findById(id);
		if (existingstudent.isPresent()) {
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findRequiredField(IRCTC.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingstudent, value);
			});

			return ircrep.save(existingstudent.get());
		}
		return null;
	}

	@Override
	public String deleteTicket(Integer id) {
		ircrep.deleteById(id);
		return "TICKET Booking Deleted Successfully";
		
	}


	
}
