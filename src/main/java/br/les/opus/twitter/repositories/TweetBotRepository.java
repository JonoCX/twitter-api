package br.les.opus.twitter.repositories;

import br.les.opus.commons.persistence.HibernateAbstractRepository;
import br.les.opus.twitter.domain.TweetBot;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jonathan Carlton
 */
@Repository
public class TweetBotRepository extends HibernateAbstractRepository<TweetBot, Long> {

    @Override
    public TweetBot findOne(Long id) {
        return super.findOne(id);
    }

    public List<TweetBot> findAllBy(String screenName) {
        String hql = "from TweetBot where screenName = :screenName";
        Query query = getSession().createQuery(hql);
        query.setParameter("screenName", screenName);
        return query.list();
    }
}
