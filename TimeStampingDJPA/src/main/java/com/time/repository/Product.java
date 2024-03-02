package com.time.repository;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Product_Details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@Column(name = "PRoduct_id")
	private Integer pid;
	
	@Column(name = "PRoduct_name")
	private String ppname;
	
	@Column(name = "PRoduct_price")
	private double pp;

	@CreationTimestamp
	@Column(name = "CRETAED_DATE", updatable = false)
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable = false)
	private LocalDateTime updatedDate;

}
