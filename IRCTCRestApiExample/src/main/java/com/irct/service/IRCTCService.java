package com.irct.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.irct.entity.IRCTC;
@Service
public interface IRCTCService {

	String addTicket(IRCTC irctc);

	public IRCTC getTicketById(Integer id);

	public List<IRCTC> getAllTicketById(Long length);

	IRCTC updateTicketByfield(Map<String, Object> fields, Integer id);

	String deleteTicket(Integer id);

	IRCTC updateTicket(IRCTC irctc, Integer id);



}
