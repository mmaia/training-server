package com.backbase.expert.training.dto.game;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * User: bartv
 * Date: 11-07-14
 * Time: 11:02
 */

@XmlRootElement(name = "GameSessionList")
public class GameSessionListTO implements Serializable {

    private List<GameSessionTO> gameSessions;

    public List<GameSessionTO> getGameSessions() {
        return gameSessions;
    }

    public void setGameSessions(List<GameSessionTO> gameSessions) {
        this.gameSessions = gameSessions;
    }
}
