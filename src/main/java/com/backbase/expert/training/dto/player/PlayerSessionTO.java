package com.backbase.expert.training.dto.player;

import com.backbase.expert.training.domain.player.PlayerSession;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * User: bartv
 * Date: 16-07-14
 * Time: 19:10
 */
@XmlRootElement(name = "PlayerSession")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSessionTO implements Serializable {

    private Long id;
    private PlayerTO player;
    private String sessionId;
    private Date loginDate;
    private Date logoutDate;
    private boolean loggedIn;

    public PlayerSessionTO() {

    }

    public PlayerSessionTO(PlayerSession playerSession) {
        this.id = playerSession.getId();
        this.player = new PlayerTO(playerSession.getPlayer());
        this.sessionId = playerSession.getSessionId();
        this.loginDate = playerSession.getLoginDate();
        this.logoutDate = playerSession.getLogoutDate();
        this.loggedIn = playerSession.isLoggedIn();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerTO player) {
        this.player = player;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


}
