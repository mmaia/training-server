package com.backbase.expert.training.repository;

import com.backbase.expert.training.domain.game.GameSession;
import com.backbase.expert.training.domain.player.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bartv on 23/03/15.
 */
@Repository
public interface GameSessionRepository extends CrudRepository<GameSession, Long> {
}
