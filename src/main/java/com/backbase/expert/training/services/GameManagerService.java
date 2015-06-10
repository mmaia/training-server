package com.backbase.expert.training.services;

import com.backbase.expert.training.dto.game.GameSessionTO;
import com.backbase.expert.training.dto.game.twothousandfortyeight.GameStateTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


/**
 * User: bartv
 * Date: 13-07-14
 * Time: 17:53
 */
@WebService
public interface GameManagerService {

    @WebMethod
    public GameSessionTO createSession(@WebParam(name = "gameState") GameStateTO gameState) throws Exception;

    @WebMethod
    public GameSessionTO getGameSession(@WebParam(name = "sessionId") Long sessionId) throws Exception;


    @WebMethod
    public void updateGameState(@WebParam(name = "gameState") GameStateTO gameState) throws Exception;



    @WebMethod
    public void updateGameState(@WebParam(name = "sessionId") Long sessionId, @WebParam(name = "gameState") GameStateTO gameState) throws Exception;


}
