package com.backbase.expert.training.dto.player;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: bartv
 * Date: 13-07-14
 * Time: 23:07
 */
@XmlRootElement(name = "PlayerList")
public class PlayerListTO implements Serializable {

    public PlayerListTO() {

    }

    private List<PlayerTO> players = new ArrayList<PlayerTO>();

    public List<PlayerTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerTO> players) {
        this.players = players;
    }
}
