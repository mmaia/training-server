package com.backbase.expert.training.dto.game.twothousandfortyeight;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: bartv
 * Date: 25-07-14
 * Time: 13:35
 */
@XmlRootElement(name = "Cell")
@XmlAccessorType(XmlAccessType.FIELD)
public class CellTO implements Serializable {


    private Long id;


    private PositionTO position;


    private int value;

    public PositionTO getPosition() {
        return position;
    }

    public void setPosition(PositionTO position) {
        this.position = position;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
