package com.hrms.pojos;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idstatus;
    
    private String statusname;

	public int getIdstatus() {
		return idstatus;
	}

	public void setIdstatus(int idstatus) {
		this.idstatus = idstatus;
	}

	public String getStatusName() {
		return statusname;
	}

	public void setStatusName(String statusname) {
		this.statusname = statusname;
	}

    
}
