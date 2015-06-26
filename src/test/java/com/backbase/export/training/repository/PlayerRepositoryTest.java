package com.backbase.export.training.repository;

import com.backbase.expert.training.domain.player.Player;
import com.backbase.expert.training.repository.PlayerRepository;
import com.backbase.expert.training.utils.DateUtil;
import com.backbase.export.training.BaseModelTest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by bartv on 23/03/15.
 */
public class PlayerRepositoryTest extends BaseModelTest {

    @Autowired
    private PlayerRepository playerRepository;


    @Test
    public void save() {
        Player player = new Player();
        player.setUsername("TestUser");
        player.setEmailAddress("test.backbase@gmail.com");
        player.setFullname("Test User");
        player.setHighScore(10000);
        player.setPassword("password");
        player.setGender("male");
        player.setBirthDay(DateUtil.stringToDate("4-4-1990", DateUtil.BIRHTDATE_FORMAT));
        player.setFirstName("Test");
        player.setLastName("User");
        playerRepository.save(player);


        Player bart = playerRepository.findByUsername("test");
        assertEquals("TestUser",player.getUsername());
        System.out.println(bart);
    }
}
