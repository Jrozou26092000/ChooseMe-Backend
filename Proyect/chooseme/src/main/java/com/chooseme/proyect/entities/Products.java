package com.chooseme.proyect.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;


@Entity(name = "Products")
@Table(name = "Products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
	private int product_id;
	
	@Column(name = "reviewer_id")
	private int reviewer_id;
	@Column(name = "photo")
	private String photo;
	@Column(name = "brand")
	private String brand;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private double price;
	@Column(name = "active")
	private int active;
	@Column(name = "verified")
	private int verified;
	@Column(name="created_at")
	private Timestamp created_at;
	@Column(name = "description")
	private String description;
	@Column(name = "score")
	private Double score;
	
	
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
	private List<Comments> comment = new ArrayList<>();
	
	public String getDescription() {
		return description;
	}
	public void setDescriptiono(String description) {
		this.description = description;
	}
	
	public Double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	
	
	@PrePersist
    public void prePersist() {
        Date date = new Date();
        long time = date.getTime();
        this.created_at = new Timestamp(time);
    }
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getReviewer_id() {
		return reviewer_id;
	}
	public void setReviewer_id(int reviewer_id) {
		this.reviewer_id = reviewer_id;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	public int getVerified() {
		return verified;
	}
	public void setVerified(int verified) {
		this.verified = verified;
	}
	
	public Timestamp getCreated_at(){
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
}
