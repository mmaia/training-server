package com.backbase.expert.training.services.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.backbase.expert.training.business.PlayerManagement;
import com.backbase.expert.training.domain.player.Player;
import com.backbase.expert.training.domain.player.PlayerSession;
import com.backbase.expert.training.dto.player.PlayerListTO;
import com.backbase.expert.training.dto.player.PlayerSessionTO;
import com.backbase.expert.training.dto.player.PlayerTO;
import com.backbase.expert.training.services.PlayerManagementService;
import com.backbase.expert.training.services.PlayerManagementServiceImpl;
import com.backbase.expert.training.services.exceptions.BadRequestException;
import com.backbase.expert.training.services.exceptions.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * User: bartv
 * Date: 13-07-14
 * Time: 18:10
 */
@WebService(name = "PlayerManagementService")
@Component
public class PlayerManagementWebServiceImpl extends PlayerManagementServiceImpl {

    public PlayerTO createPlayer(@WebParam(name = "player") PlayerTO player) throws Exception {
        return super.createPlayer(player);
    }

    public PlayerTO getPlayer(@WebParam(name = "username") String username) {
        return super.getPlayer(username);
    }

    public PlayerListTO getAllPlayers() {
        return super.getAllPlayers();
    }

    public PlayerListTO getAllPlayersByHighScore() {
        return super.getAllPlayersByHighScore();

    }

    public PlayerSessionTO[] getAllActiveSessions() {
        return super.getAllActiveSessions();
    }

    public PlayerTO login(@WebParam(name = "sessionId") String sessionId, @WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        try {
            PlayerTO player = super.login(sessionId, username, password);
            return player;
        } catch (NotFoundException e) {
            return null;
        }
    }

    public void logout(@WebParam(name = "sessionId") String sessionId) {
        super.logout(sessionId);

    }

    public int getBestScore(@WebParam(name = "username") String username) {
        return super.getBestScore(username);
    }

    public void setBestScore(@WebParam(name = "username") String username, @WebParam(name = "score") int score) {
        super.setBestScore(username, score);
    }
}
