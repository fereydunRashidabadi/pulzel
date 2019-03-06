package com.pulzel.service;

import com.pulzel.dao.IAdvertisDAO;
import com.pulzel.entity.Advertis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisService implements IAdvertisService {
	@Autowired
	private IAdvertisDAO advertisDAO;
	@Override
	public Advertis getAdvertisById(int advertisId) {
		Advertis obj = advertisDAO.getAdvertisById(advertisId);
		return obj;
	}	
	@Override
	public List<Advertis> getAllAdvertises(){
		return advertisDAO.getAllAdvertises();
	}
	@Override
	public synchronized boolean addAdvertis(Advertis advertis){

    	   advertisDAO.addAdvertis(advertis);
    	   return true;

	}
	@Override
	public void updateAdvertis(Advertis advertis) {
		advertisDAO.updateAdvertis(advertis);
	}
	@Override
	public void deleteAdvertis(int advertisId) {
		advertisDAO.deleteAdvertis(advertisId);
	}
}
