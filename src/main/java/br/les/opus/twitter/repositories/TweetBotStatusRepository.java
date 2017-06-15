package br.les.opus.twitter.repositories;

import br.les.opus.commons.persistence.HibernateAbstractRepository;
import br.les.opus.twitter.domain.TweetBotStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;


/**
 *
 * Repository for the various statuses posted by the
 * reactive tweet bot.
 *
 * @author Jonathan Carlton
 */
@Repository
public class TweetBotStatusRepository extends HibernateAbstractRepository<TweetBotStatus, Long> {

    @Override
    public TweetBotStatus findOne(Long id) {
        return super.findOne(id);
    }

    /**
     *
     * The ability to randomly select a status from
     * those that are stored in the database.
     *
     * @return  the random row.
     */
    public TweetBotStatus randomSelection() {
        Random random = new Random();
        List<TweetBotStatus> statuses = super.findAll();
        Integer index = random.nextInt(statuses.size());
        return statuses.get(index);
    }

}
