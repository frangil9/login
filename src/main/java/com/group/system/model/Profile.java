package com.group.system.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Created by fran on 09/10/2017.
 */
@Entity
@Table(name="profile")
public class Profile implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="profile_id", nullable=false)
    private Integer profileId;

    @Column(name="type", nullable=false)
    private String type;

    public Profile() {
    }

	public Profile(Integer profileId, String type) {
		super();
		this.profileId = profileId;
		this.type = type;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
}
