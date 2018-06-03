package org.qingfei.glee.entity;/**
 * Created by ASUS on 5/30/2018.
 */

import org.qingfei.glee.annotation.NotNull;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.sql.Timestamp;

/**
 * Entity Follow
 *
 * @author Chenhaiqing
 * @create 2018-05-30 4:05 PM
 */
@Entity
public class Follow {

    @EmbeddedId
    @NotNull
    private FollowIdentity followIdentity;
    @Column
    private Timestamp createTimestamp = new Timestamp(System.currentTimeMillis());


    public FollowIdentity getFollowIdentity() {
        return followIdentity;
    }

    public void setFollowIdentity(FollowIdentity followIdentity) {
        this.followIdentity = followIdentity;
    }

    public Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
    }


    @Override
    public String toString() {
        return "Follow{" +
                "followIdentity=" + followIdentity +
                ", createTimestamp=" + createTimestamp +
                '}';
    }
}
