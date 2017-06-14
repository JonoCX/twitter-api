package br.les.opus.twitter.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Database entity to store information about the
 * bot's interactions.
 *
 * @author Jonathan Carlton
 */
@Entity
@Table(name = "tweet_bot", schema = "twitter")
public class TweetBot {

    @Id
    private Long tweetId;

    private String screenName;

    private Date timePosted;

    private Date timeReplied;

    @Override
    public String toString() {
        return "Bot Entry [id=" + tweetId + ", screenName=" + screenName + ", timePosted=" +
                timePosted + ", timeReplied=" + timeReplied + "]";
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Date getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(Date timePosted) {
        this.timePosted = timePosted;
    }

    public Date getTimeReplied() {
        return timeReplied;
    }

    public void setTimeReplied(Date timeReplied) {
        this.timeReplied = timeReplied;
    }
}
