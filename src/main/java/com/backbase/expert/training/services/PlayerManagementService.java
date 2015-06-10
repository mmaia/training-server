package com.backbase.expert.training.services;

import com.backbase.expert.training.dto.player.PlayerListTO;
import com.backbase.expert.training.dto.player.PlayerSessionTO;
import com.backbase.expert.training.dto.player.PlayerTO;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.FormParam;


/**
 * User: bartv
 * Date: 13-07-14
 * Time: 18:09
 */
@WebService
public interface PlayerManagementService {

    public PlayerTO createPlayer(PlayerTO newPLayer) throws Exception;

    public PlayerTO getPlayer(@WebParam(name = "username") String username);

    public PlayerListTO getAllPlayers();

    public PlayerListTO getAllPlayersByHighScore();

    public PlayerSessionTO[] getAllActiveSessions();

    public PlayerTO login(@WebParam(name = "sessionId") String sessionId, @WebParam(name = "username") String username, @WebParam(name = "password") String password) throws Exception;

    public void logout(@WebParam(name = "sessionId") String sessionId);

    public int getBestScore(@WebParam(name = "username") String username);

    public void setBestScore(@WebParam(name = "username") String username, @WebParam(name = "score") int score);
}
