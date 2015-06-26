package com.backbase.expert.training.dto.game;

import com.backbase.expert.training.domain.game.GameSession;
import com.backbase.expert.training.dto.game.twothousandfortyeight.GameStateTO;
import com.backbase.expert.training.dto.player.PlayerTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

/**
 * User: bartv
 * Date: 11-07-14
 * Time: 11:02
 */

@XmlRootElement(name ="GameSession")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameSessionTO implements Serializable {

    protected Long id;
    private PlayerTO player;
    private Date startDate;
    private Date endDate;

    private GameStateTO gameState;

    public GameSessionTO(GameSession s) {
        this.id = s.getId();
        this.player = new PlayerTO(s.getPlayer());
        this.endDate = s.getEndDate();
        this.startDate = s.getStartDate();
    }

    public GameSessionTO() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameStateTO getGameState() {
        return gameState;
    }

    public void setGameState(GameStateTO gameState) {
        this.gameState = gameState;
    }

    public PlayerTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerTO player) {
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
