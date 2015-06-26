package com.backbase.expert.training.services.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.backbase.expert.training.business.GameManager;
import com.backbase.expert.training.domain.game.GameSession;
import com.backbase.expert.training.dto.game.GameSessionTO;
import com.backbase.expert.training.dto.game.twothousandfortyeight.GameStateTO;
import com.backbase.expert.training.services.GameManagerService;
import com.backbase.expert.training.services.webservice.GameManagerWebServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * User: bartv
 * Date: 13-07-14
 * Time: 15:52
 */
@Path("/game")
@Consumes("application/x-www-form-urlencoded")
@Produces("application/json")
public class GameManagerRestServiceImpl extends GameManagerWebServiceImpl {

    @POST
    @Consumes("application/json")
    @Path("/session")
    public GameSessionTO createSession(GameStateTO gameState) throws Exception {
        return super.createSession(gameState);
    }

    @PUT
    @Consumes("application/json")
    @Path("/session/{id}")
    public void updateGameState(@PathParam("id") Long sessionId, GameStateTO gameState) throws Exception {
        super.updateGameState(sessionId,gameState);
    }

    @GET
    @Path("/session/{id}")
    public GameSessionTO getGameSession(@PathParam("id") Long id) throws Exception {
        return super.getGameSession(id);
    }


}
