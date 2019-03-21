package com.pulzel.dao;

import com.pulzel.entity.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ICompanyDAO extends PagingAndSortingRepository<Company , Long> {
}
