package com.habibank.model;
import javax.persistence.*;
@Entity
@Table(name = "roles")
/**
Model for Authorization
 */ 
public class Role {
	
	
	//should i make a user role or just customer
    public enum ERole {
        ROLE_CUSTOMER, 
        ROLE_ADMIN
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
	@Column(length = 20)
    private ERole name;
    
    public Role() {

	}

	public Role(ERole name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

    
}
