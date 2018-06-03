package org.qingfei.glee.entity;/**
 * Created by ASUS on 5/30/2018.
 */

import org.qingfei.glee.annotation.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Entity Message
 *
 * @author Chenhaiqing
 * @create 2018-05-30 4:12 PM
 */
@Entity
public class Message  implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotNull
    private String content;

    @Column
    @NotNull
    private Long userId;

    @Column
    @NotNull
    private String username;

    @Column
    private Timestamp createTimestamp = new Timestamp(System.currentTimeMillis());


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", createTimestamp=" + createTimestamp +
                '}';
    }
}
