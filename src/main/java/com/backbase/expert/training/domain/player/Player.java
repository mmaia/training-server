package com.backbase.expert.training.domain.player;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.backbase.expert.training.dto.player.PlayerTO;
import com.sun.istack.Nullable;
import org.apache.commons.lang.StringUtils;


/**
 * User: bartv
 * Date: 10-07-14
 * Time: 21:29
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"username"})})
public class Player  implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String uid;


    private String username;
    private String fullname;
    private String password;
    private String emailAddress;

    private String profileUrl;

    private String photoUrl;

    private String thumbnalUrl;
    private String gender;

    private Date birthDay;
    private String firstName;
    private String lastName;
    private String middleName;


    private int highScore;


    public Player(PlayerTO playerTO) {
        this.id = playerTO.getId();
        this.uid = playerTO.getUid();
        this.username = playerTO.getUsername();
        this.fullname = playerTO.getFullname();
        this.password = playerTO.getPassword();
        this.emailAddress = playerTO.getEmailAddress();
        this.profileUrl = playerTO.getProfileUrl();
        this.photoUrl = playerTO.getPhotoUrl();
        this.thumbnalUrl = playerTO.getThumbnalUrl();
        this.gender = playerTO.getGender();
        this.birthDay = playerTO.getBirthDay();
        this.firstName = playerTO.getFirstName();
        this.middleName = playerTO.getMiddleName();
        this.lastName = playerTO.getLastName();
    }

    public Player() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getThumbnalUrl() {
        return thumbnalUrl;
    }

    public void setThumbnalUrl(String thumbnalUrl) {
        this.thumbnalUrl = thumbnalUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
