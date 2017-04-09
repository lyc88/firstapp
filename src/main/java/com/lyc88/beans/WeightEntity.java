package com.lyc88.beans;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/23.
 */
@Entity
@Table(name = "weight")
public class WeightEntity {
    @GeneratedValue
    @Id
    private int id;
    @Column(name="kg")
    private double kg;
    @Column(name="userId")
    private int userId;
    @Column(name="teamId")
    private int teamId;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Column(name="time")
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }
}
