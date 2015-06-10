package com.backbase.expert.training.services.webservice;

import com.backbase.expert.training.dto.game.GameSessionTO;
import com.backbase.expert.training.dto.game.twothousandfortyeight.GameStateTO;
import com.backbase.expert.training.services.GameManagerServiceImpl;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * User: bartv
 * Date: 13-07-14
 * Time: 15:52
 */
@WebService(name = "GameManagementService")
public class GameManagerWebServiceImpl extends GameManagerServiceImpl {


    public GameSessionTO createSession(@WebParam(name = "gameState") GameStateTO gameState) throws Exception {
        return super.createSession(gameState);
    }

    public void updateGameState(@WebParam(name = "sessionId") Long sessionId, @WebParam(name = "gameState") GameStateTO gameState)
            throws Exception {
        super.updateGameState(sessionId, gameState);
    }

    public GameSessionTO getGameSession(@WebParam(name = "id") Long id) throws Exception {
        return super.getGameSession(id);
    }


}
