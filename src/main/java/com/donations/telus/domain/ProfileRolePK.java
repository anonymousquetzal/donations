/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donations.telus.domain;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Leticia Boch
 */
@Embeddable
@Data
public class ProfileRolePK implements Serializable {

    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "role_id")
    private Long roleId;
    
}
