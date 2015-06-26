package com.backbase.expert.training.dto.game.twothousandfortyeight;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: bartv
 * Date: 25-07-14
 * Time: 13:33
 */
@XmlRootElement(name = "Grid")
@XmlAccessorType(XmlAccessType.FIELD)
public class GridTO implements Serializable {

    private Long id;

    private CellTO[][] cells;
    private int size;

    public CellTO[][] getCells() {
        return cells;
    }

    public void setCells(CellTO[][] cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
