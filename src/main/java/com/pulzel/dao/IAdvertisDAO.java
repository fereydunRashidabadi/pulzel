package com.pulzel.dao;

import com.pulzel.entity.Advertis;

import java.util.List;

public interface IAdvertisDAO {
    List<Advertis> getAllAdvertises();

    Advertis getAdvertisById(int advertisId);

    void addAdvertis(Advertis advertis);

    void updateAdvertis(Advertis advertis);

    void deleteAdvertis(int advertisId);
}
 