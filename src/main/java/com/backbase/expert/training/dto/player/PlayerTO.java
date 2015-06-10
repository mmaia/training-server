package com.backbase.expert.training.dto.player;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.backbase.expert.training.domain.player.Player;


/**
 * User: bartv
 * Date: 10-07-14
 * Time: 21:29
 */
@XmlRootElement(name = "Player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerTO {

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

    public PlayerTO() {
        super();
    }

    public PlayerTO(Player player) {
        this.uid = player.getUid();
        this.id = player.getId();
        this.username = player.getUsername();
        this.fullname = player.getFullname();
        this.password = player.getPassword();
        this.emailAddress = player.getEmailAddress();
        this.profileUrl = player.getProfileUrl();
        this.photoUrl = player.getPhotoUrl();
        this.thumbnalUrl = player.getThumbnalUrl();
        this.gender = player.getGender();
        this.birthDay = player.getBirthDay();
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();
        this.middleName = player.getMiddleName();
        this.highScore = player.getHighScore();
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
