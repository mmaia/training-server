package com.backbase.expert.training.dto.game.twothousandfortyeight;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: bartv
 * Date: 25-07-14
 * Time: 13:36
 */
@XmlRootElement(name = "Position")
@XmlAccessorType(XmlAccessType.FIELD)
public class PositionTO implements Serializable {

    int x;
    int y;

    public PositionTO() {}

    public PositionTO(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
