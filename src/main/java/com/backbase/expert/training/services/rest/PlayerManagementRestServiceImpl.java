package com.backbase.expert.training.services.rest;

import com.backbase.expert.training.business.PlayerManagement;
import com.backbase.expert.training.dto.player.PlayerListTO;
import com.backbase.expert.training.dto.player.PlayerSessionTO;
import com.backbase.expert.training.dto.player.PlayerTO;
import com.backbase.expert.training.services.PlayerManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import javax.ws.rs.*;


/**
 * User: bartv
 * Date: 13-07-14
 * Time: 18:10
 */
@WebService(name = "PlayerManagementService")
@Component
@Consumes("application/x-www-form-urlencoded")
@Produces("application/json")
@Path("/player")
public class PlayerManagementRestServiceImpl extends PlayerManagementServiceImpl {

    @Path("/")
    @Consumes("application/json")
    @POST
    public PlayerTO createPlayer(PlayerTO player) throws Exception {
        return super.createPlayer(player);
    }

    @Path("/{username}")
    @GET
    public PlayerTO getPlayer(@PathParam("username") String username) {
        return super.getPlayer(username);
    }


    @Path("/{username}")
    @Consumes("application/json")
    @PUT
    public PlayerTO updatePlayer(@PathParam("username") String username, PlayerTO player) throws Exception {
        return super.updatePlayer(username, player);
    }

    @Path("/{username}")
    @Consumes("application/json")
    @DELETE
    public void deletePlayer(@PathParam("username") String username) throws Exception {
        super.removePlayer(username);
    }

    @GET
    @Path("/{username}/highscore/")
    public int getBestScore(@PathParam("username") String username) {
        return super.getBestScore(username);
    }

    @PUT
    @Consumes("application/json")
    @Path("/{username}/highscore")
    public void setBestScore(@PathParam("username") String username, int score) {
        super.setBestScore(username, score);
    }

    @GET
    @Path("/players")
    public PlayerListTO getAllPlayers() {
        return super.getAllPlayers();
    }

    @GET
    @Path("/players/highscore")
    public PlayerListTO getAllPlayersByHighScore() {
        return super.getAllPlayersByHighScore();
    }

    @GET
    @Path("/players/active")
    public PlayerSessionTO[] getAllActiveSessions() {
        return super.getAllActiveSessions();
    }

    @POST
    @Path("/login")
    public PlayerTO login(@FormParam("sessionId") String sessionId, @FormParam("username") String username,
                          @FormParam("password") String password) throws NotFoundException {
        return super.login(sessionId, username, password);
    }

    @PUT
    @Path("/logout")
    public void logout(String sessionId) {
        super.logout(sessionId);

    }

}
