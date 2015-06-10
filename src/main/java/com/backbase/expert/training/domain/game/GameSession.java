package com.backbase.expert.training.domain.game;

import com.backbase.expert.training.domain.player.Player;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * User: bartv
 * Date: 11-07-14
 * Time: 11:02
 */

@Entity
public class GameSession implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    @ManyToOne
    private Player player;
    private Date startDate;
    private Date endDate;

    private String game;

    @Column(columnDefinition = "TEXT")
    private String lastGameState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastGameState() {
        return lastGameState;
    }

    public void setLastGameState(String lastGameState) {
        this.lastGameState = lastGameState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


}
