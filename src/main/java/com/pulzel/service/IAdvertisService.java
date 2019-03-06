package com.pulzel.service;

import com.pulzel.entity.Advertis;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IAdvertisService {
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     List<Advertis> getAllAdvertises();
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     Advertis getAdvertisById(int advertisId);
	 @Secured ({"ROLE_ADMIN"})
     boolean addAdvertis(Advertis advertis);
	 @Secured ({"ROLE_ADMIN"})
     void updateAdvertis(Advertis advertis);
	 @Secured ({"ROLE_ADMIN"})
     void deleteAdvertis(int advertisId);
}
