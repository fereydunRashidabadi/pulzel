package com.pulzel.dao;

import com.pulzel.entity.Advertis;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class AdvertisDAO implements IAdvertisDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Advertis getAdvertisById(int advertisId) {
		return entityManager.find(Advertis.class, advertisId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Advertis> getAllAdvertises() {
		String hql = "FROM Advertis as atcl ORDER BY atcl.Id";
		return (List<Advertis>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addAdvertis(Advertis advertis) {
		entityManager.persist(advertis);
	}
	@Override
	public void updateAdvertis(Advertis advertis) {
		Advertis ads = getAdvertisById(advertis.getId());
		ads.setTitle(advertis.getTitle());
		ads.setImage(advertis.getImage());
		ads.setMax_viwe(advertis.getMax_viwe());
		ads.setAds_price(advertis.getAds_price());
		entityManager.flush();
	}
	@Override
	public void deleteAdvertis(int advertisId) {
		entityManager.remove(getAdvertisById(advertisId));
	}

}
