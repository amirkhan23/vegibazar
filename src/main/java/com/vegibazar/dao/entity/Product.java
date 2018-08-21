package com.vegibazar.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Product", uniqueConstraints = @UniqueConstraint(columnNames = "pName"))
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue
	private int pId;
	@NotNull
	@Size(min = 3, message = "Name must be 3 or more characters long")
	private String pName;
	@NotNull
	@Size(min = 1, message = "insert sufficent amt.")
	private String pPrice;

	@NotNull
	private String stock;
	
	@Transient
	private MultipartFile img;
	
	
	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpPrice() {
		return pPrice;
	}

	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}

}
