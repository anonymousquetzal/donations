/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donations.telus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author 
 */
@Data
@Entity
@Table(name = "profile")
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "profileSet")
    private Set<Users> userSet;

    @OneToMany(mappedBy = "profile")
    private Set<ProfileRole> profileRoleSet;

    public Profile() {
    }

    public Profile(Long perfilId) {
        this.profileId = perfilId;
    }

}
