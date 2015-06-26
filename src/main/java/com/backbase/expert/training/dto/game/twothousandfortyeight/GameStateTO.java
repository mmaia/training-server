package com.backbase.expert.training.dto.game.twothousandfortyeight;

import com.backbase.expert.training.dto.player.PlayerTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: bartv
 * Date: 25-07-14
 * Time: 13:31
 */
@XmlRootElement(name = "GameState")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameStateTO implements Serializable {

    private Long sessionId;

    private GridTO grid;
    private String playerId;
    private boolean keepPlaying;
    private boolean over;
    private int score;
    private boolean won;
    private int step;


    public GameStateTO() {

    }



    public GridTO getGrid() {
        return grid;
    }

    public void setGrid(GridTO grid) {
        this.grid = grid;
    }

    public boolean isKeepPlaying() {
        return keepPlaying;
    }

    public void setKeepPlaying(boolean keepPlaying) {
        this.keepPlaying = keepPlaying;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }


    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }
}
