package com.eadydb.boot.swagger.repository;

import com.eadydb.boot.swagger.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dengbin on 16-11-14.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
}
