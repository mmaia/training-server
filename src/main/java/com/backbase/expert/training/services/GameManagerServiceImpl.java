package com.backbase.expert.training.services;

import com.backbase.expert.training.business.GameManager;
import com.backbase.expert.training.domain.game.GameSession;
import com.backbase.expert.training.dto.game.GameSessionTO;
import com.backbase.expert.training.dto.game.twothousandfortyeight.GameStateTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * User: bartv
 * Date: 13-07-14
 * Time: 15:52
 */
@Component("gameManagerService")
public class GameManagerServiceImpl implements GameManagerService {

    private ObjectMapper objectMapper;

    @Autowired
    private GameManager gameManager;

    public GameManagerServiceImpl() {
    }

    public GameSessionTO createSession(GameStateTO gameState) throws Exception {
        GameSession session = gameManager.createSession(gameState);
        GameSessionTO gameSessionTO = new GameSessionTO(session);
        gameState.setSessionId(session.getId());
        gameSessionTO.setGameState(gameState);
        return gameSessionTO;
    }

    public void updateGameState(GameStateTO gameState)
            throws Exception {
        gameManager.updateGameState(gameState.getSessionId(), gameState);
    }

    public void updateGameState(@WebParam(name = "sessionId") Long sessionId, @WebParam(name = "gameState") GameStateTO gameState) throws Exception {
        gameManager.updateGameState(sessionId,gameState);
    }

    public GameSessionTO getGameSession(Long id) throws Exception {
        return new GameSessionTO(gameManager.getGameSession(id));
    }




}
