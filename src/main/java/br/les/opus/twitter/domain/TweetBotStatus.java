package br.les.opus.twitter.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * Database entity to store statuses posted by the
 * tweet bot.
 *
 * @author Jonathan Carlton
 */
@Entity
@Table(name = "tweet_bot_status", schema = "twitter")
public class TweetBotStatus {

    @Id
    private Long id;

    private String status;

    @Override
    public String toString() {
        return "Bot Status [id=" + id + ", status=" + status + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
