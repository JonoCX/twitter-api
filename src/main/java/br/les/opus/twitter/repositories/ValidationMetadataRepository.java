package br.les.opus.twitter.repositories;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.les.opus.commons.persistence.HibernateAbstractRepository;
import br.les.opus.twitter.domain.TwitterUser;
import br.les.opus.twitter.domain.ValidationMetadata;


@Repository
public class ValidationMetadataRepository extends HibernateAbstractRepository<ValidationMetadata, Long>{

	public Long countPublishedTweetsFrom(TwitterUser user) {
		String hql = "select count(id) from Validation where user.id = :userId";
		Query query = getSession().createQuery(hql);
		query.setParameter("userId", user.getId());
		Object count = query.uniqueResult();
		return (Long)count;
	}
	
	public Long countNewsTweetsFrom(TwitterUser user) {
		String hql = "select count(id) from Tweet where user.id = :userId and classification.key = :label";
		Query query = getSession().createQuery(hql);
		query.setParameter("userId", user.getId());
		query.setParameter("label", "NEWS");
		Object count = query.uniqueResult();
		return (Long)count;
	}
	
	public Long countNoiseTweetsFrom(TwitterUser user) {
		String hql = "select count(id) from Tweet where user.id = :userId and classification.key = :label";
		Query query = getSession().createQuery(hql);
		query.setParameter("userId", user.getId());
		query.setParameter("label", "NOISE");
		Object count = query.uniqueResult();
		return (Long)count;
	}
	
	public Long countRelevantTweetsFrom(TwitterUser user) {
		String hql = "select count(id) from Tweet where user.id = :userId and classification.key = :label";
		Query query = getSession().createQuery(hql);
		query.setParameter("userId", user.getId());
		query.setParameter("label", "RELEVANT");
		Object count = query.uniqueResult();
		return (Long)count;
	}
	
	//TODO auto generate needs to be completed
	public double generateKeysOverAll(TwitterUser user) {
		Long total = this.countPublishedTweetsFrom(user);
		Long zika = this.countPublishedZika(user);
		
		double percentage = ((double)zika/(double)total)*100;
		return percentage;
	}
	
	//TODO auto generate needs to be completed
	public double generateRelevantOverKeys(TwitterUser user) {
		Long total = this.countPublishedZika(user);
		Long relevant = this.countRelevantTweetsFrom(user);
		
		double percentage = ((double)relevant/(double)total)*100;
		return percentage;
	}
	
	//TODO auto generate needs to be completed
	public double generateRelevantOverAll(TwitterUser user) {
		Long total = this.countPublishedTweetsFrom(user);
		Long relevant = this.countRelevantTweetsFrom(user);
		
		double percentage = ((double)relevant/(double)total)*100;
		return percentage;
	}
	
	public Long countPublishedZika(TwitterUser user) {
		String hql = "select count(id) from Tweet where user.id = :userId and classification.id is not null";
		Query query = getSession().createQuery(hql);
		query.setParameter("userId", user.getId());
		Object count = query.uniqueResult();
		return (Long)count;
	}
	
	public ValidationMetadata findOne(TwitterUser user) {
		String hql = "from ValidationMetadata where user.id = :userId";
		Query query = getSession().createQuery(hql);
		query.setParameter("userId", user.getId());
		return (ValidationMetadata)query.list().get(0);
	}
}

