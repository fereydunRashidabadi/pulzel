package com.pulzel.entity;
import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="advertis")
@Data
public class Advertis implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private int Id;
	@Column(name="title")
    private String title;
	@Column(name="image")
	private String image;
	@Column(name="max_viwe")
    private int max_viwe;
	@Column(name="ads_price")
    private int ads_price;

} 