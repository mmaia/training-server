package com.backbase.expert.training.business;

import java.util.Date;
import java.util.List;

import com.backbase.expert.training.dto.player.PlayerTO;
import com.backbase.expert.training.services.exceptions.NotFoundException;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backbase.expert.training.domain.player.Player;
import com.backbase.expert.training.domain.player.PlayerSession;
import com.backbase.expert.training.repository.PlayerRepository;
import com.backbase.expert.training.repository.PlayerSessionRepository;
import com.backbase.expert.training.utils.DateUtil;

/**
 * User: bartv
 * Date: 13-07-14
 * Time: 13:53
 */
@Component
public class PlayerManagement {

    @EndpointInject(uri = "seda://player/created")
    private ProducerTemplate playerCreated;

    @EndpointInject(uri = "seda://player/loggedIn")
    private ProducerTemplate playerLoggedIn;

    @EndpointInject(uri = "seda://player/loggedOut")
    private ProducerTemplate playerLoggedOut;

    @EndpointInject(uri = "seda://player/highScoreUpdated")
    private ProducerTemplate highScoreUpdated;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerSessionRepository playerSessionRepository;


    public Player createPlayer(Player newPlayer)
            throws Exception {

        if (StringUtils.isEmpty(newPlayer.getUsername())) {
            throw new Exception("You forgot something");
        }

        if (getPlayer(newPlayer.getUsername()) == null) {

            Player player = playerRepository.save(newPlayer);
            playerCreated.sendBody(player);

            return player;
        } else {
            throw new Exception("Player Already Exists");
        }
    }


    public Player getPlayer(Long id) {
        return playerRepository.findOne(id);
    }

    public Player getPlayer(String username) {
        return playerRepository.findByUsername(username);
    }


    public Player login(String sessionId, String username, String password) throws NotFoundException {
        Player player = getPlayer(username);
        if (player != null && player.getPassword() != null && player.getPassword().equals(password)) {
            PlayerSession playerSession = getPlayerSession(sessionId);
            if (playerSession == null) {
                playerSession = new PlayerSession();
            }
            playerSession.setLoggedIn(true);
            playerSession.setLoginDate(new Date());
            playerSession.setPlayer(player);
            playerSession = playerSessionRepository.save(playerSession);
            playerLoggedIn.sendBody(playerSession);
            return player;
        } else {
            throw new NotFoundException("Username or Password not correct");
        }
    }

    private PlayerSession getPlayerSession(String id) {

        return playerSessionRepository.findBySessionId(id);
    }

    public void logout(String sessionId) {
        PlayerSession playerSession = getPlayerSession(sessionId);
        playerSession.setLogoutDate(new Date());
        playerSession.setLoggedIn(false);
        playerSessionRepository.save(playerSession);
        playerLoggedOut.sendBody(playerSession);
    }

    public List<Player> getAllPlayers() {
        return IteratorUtils.toList(playerRepository.findAll().iterator());
    }

    public PlayerSession[] getAllActiveSessions() {


        List<PlayerSession> playerSessions =
                IteratorUtils.toList(playerSessionRepository.findAll().iterator());
        return playerSessions.toArray(new PlayerSession[playerSessions.size()]);
    }

    public int getBestScore(String username) {
        Player player = getPlayer(username);
        if (player == null) {
            return 0;
        }
        return player.getHighScore();
    }

    public synchronized void setBestScore(String username, int score) {
        Player player = getPlayer(username);
        player.setHighScore(score);
        player = playerRepository.save(player);
        highScoreUpdated.sendBody(player);
    }

    public List<Player> getAllPlayersByHighScore() {
        return getAllPlayers();
    }

    public Player updatePlayer(String username, PlayerTO to) throws Exception {
        Player player = getPlayer(username);
        if (player == null) {
            throw new Exception("Invalid username");
        }

        player = new Player(to);
        playerRepository.save(player);

        return player;
    }

    public void deletePlayer(Player player) {
        playerRepository.delete(player);
    }
}

