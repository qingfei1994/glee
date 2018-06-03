package org.qingfei.glee.entity;/**
 * Created by ASUS on 5/30/2018.
 */

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Primary key for Follow
 *
 * @author Chenhaiqing
 * @create 2018-05-30 4:06 PM
 */
@Embeddable
public class FollowIdentity  implements Serializable {
    @Column
    private Long followerId;
    @Column
    private Long friendId;

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    @Override
    public String toString() {
        return "FollowIdentity{" +
                "followerId=" + followerId +
                ", friendId=" + friendId +
                '}';
    }
}
