package com.irct.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
@Table(name = "IRCTC_TICKETS")
@AllArgsConstructor
public class IRCTC {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketid;

	private String personname;
	
	private String gender;
	
	private Integer age;
	
	private String startingpoint;

	private String destination;

	private Long phoneNo;

	private Integer amount;

	public IRCTC() {

	}

	

	

}
