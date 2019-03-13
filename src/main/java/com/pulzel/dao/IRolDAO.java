package com.pulzel.dao;

import com.pulzel.entity.AppRole;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface IRolDAO extends PagingAndSortingRepository<AppRole, Long> {

}
