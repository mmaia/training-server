package com.backbase.expert.training.business;

import java.util.Date;
import java.util.List;

import com.backbase.expert.training.domain.game.GameSession;
import com.backbase.expert.training.domain.player.Player;
import com.backbase.expert.training.dto.game.GameSessionTO;
import com.backbase.expert.training.dto.game.twothousandfortyeight.GameStateTO;
import com.backbase.expert.training.repository.GameSessionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * User: bartv
 * Date: 13-07-14
 * Time: 12:57
 */

@Component
public class GameManager {


    private ObjectMapper objectMapper = new ObjectMapper();

    @EndpointInject(uri = "seda://gamesession/updated")
    private ProducerTemplate highscoreUpdatedEndpoint;


    @Autowired
    private PlayerManagement playerManagement;

    @Autowired
    private GameSessionRepository gameSessionRepository;


    public GameSession createSession(GameStateTO gameState) throws Exception {
        Player player = playerManagement.getPlayer(gameState.getPlayerId());
        if(player == null) {
            player = new Player();
            player.setUsername(gameState.getPlayerId());
            player = playerManagement.createPlayer(player);
        }


        GameSession gameSession = new GameSession();
        gameSession.setPlayer(player);
        gameSession.setStartDate(new Date());
        gameState.setStep(0);
        gameSession.setLastGameState(objectMapper.writeValueAsString(gameState));
        return gameSessionRepository.save(gameSession);
    }

    public synchronized void updateGameState(Long sessionId, GameStateTO gameState) throws Exception {
        GameSession gameSession = gameSessionRepository.findOne(sessionId);

        GameStateTO currentGameStateTO = objectMapper.readValue(gameSession.getLastGameState(), GameStateTO.class);
        int currentStep = currentGameStateTO.getStep();
        gameState.setStep(currentStep + 1);
        gameSession.setLastGameState(objectMapper.writeValueAsString(gameState));
        gameSessionRepository.save(gameSession);
        highscoreUpdatedEndpoint.sendBody(gameSession);
    }


    public List<GameSession> getHighScores() {
        return IteratorUtils.toList(gameSessionRepository.findAll().iterator());
    }

    public List<GameSession> getPlayerGameSessions() {
        return IteratorUtils.toList(gameSessionRepository.findAll().iterator());
    }

    public synchronized GameSession getGameSession(Long id) throws Exception {

        return gameSessionRepository.findOne(id);
    }
}
