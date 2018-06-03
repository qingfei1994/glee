package org.qingfei.glee.entity;/**
 * Created by ASUS on 5/30/2018.
 */

import org.qingfei.glee.annotation.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Entity User
 *
 * @author Chenhaiqing
 * @create 2018-05-30 4:10 PM
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotNull
    private String username;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
