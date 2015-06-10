package com.backbase.expert.training.services;

import com.backbase.expert.training.business.PlayerManagement;
import com.backbase.expert.training.domain.player.Player;
import com.backbase.expert.training.domain.player.PlayerSession;
import com.backbase.expert.training.dto.player.PlayerListTO;
import com.backbase.expert.training.dto.player.PlayerSessionTO;
import com.backbase.expert.training.dto.player.PlayerTO;
import com.backbase.expert.training.services.exceptions.BadRequestException;
import com.backbase.expert.training.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;


/**
 * User: bartv
 * Date: 13-07-14
 * Time: 18:10
 */
@Component("playerManagementService")
public class PlayerManagementServiceImpl implements PlayerManagementService {

    @Autowired
    private PlayerManagement playerManagement;
    private Player login;

    public PlayerTO createPlayer(PlayerTO playerTO) throws Exception {
        try {
            Player newPlayer = new Player(playerTO);
            Player player = playerManagement.createPlayer(newPlayer);
            return new PlayerTO(player);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public PlayerTO getPlayer(@WebParam(name = "username") String username) {
        Player player = playerManagement.getPlayer(username);
        if (player == null) {
            throw new NotFoundException("Cannot find player: " + username);
        }
        return new PlayerTO(player);
    }

    public PlayerListTO getAllPlayers() {
        PlayerListTO playerList = new PlayerListTO();

        for (Player player : playerManagement.getAllPlayers()) {
            playerList.getPlayers().add(new PlayerTO(player));
        }
        return playerList;
    }

    public PlayerListTO getAllPlayersByHighScore() {
        PlayerListTO playerList = new PlayerListTO();

        for (Player player : playerManagement.getAllPlayersByHighScore()) {
            playerList.getPlayers().add(new PlayerTO(player));
        }
        return playerList;

    }

    public PlayerSessionTO[] getAllActiveSessions() {
        List<PlayerSessionTO> playerSessionTOs = new ArrayList<PlayerSessionTO>();
        for (PlayerSession s : playerManagement.getAllActiveSessions()) {
            playerSessionTOs.add(new PlayerSessionTO(s));
        }
        return playerSessionTOs.toArray(new PlayerSessionTO[playerSessionTOs.size()]);
    }

    public PlayerTO login(@WebParam(name = "sessionId") String sessionId, @WebParam(name = "username") String username, @WebParam(name = "password") String password) throws NotFoundException {
        login = playerManagement.login(sessionId, username, password);
        return new PlayerTO(login);
    }

    public void logout(@WebParam(name = "sessionId") String sessionId) {
        playerManagement.logout(sessionId);

    }

    public int getBestScore(@WebParam(name = "playerId") String username) {
        return playerManagement.getBestScore(username);
    }

    public void setBestScore(@WebParam(name = "playerId") String username, @WebParam(name = "score") int score) {
        playerManagement.setBestScore(username, score);
    }

    public PlayerTO updatePlayer(String username, PlayerTO player) throws Exception {
        Player updatedPlayer =  playerManagement.updatePlayer(username, player);
        return new PlayerTO(updatedPlayer);
    }

    public void removePlayer(String username) {
        Player player = playerManagement.getPlayer(username);
        if(player != null)
            playerManagement.deletePlayer(player);

    }
}
