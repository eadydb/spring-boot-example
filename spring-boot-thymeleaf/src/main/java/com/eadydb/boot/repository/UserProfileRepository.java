package com.eadydb.boot.repository;

import com.eadydb.boot.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 6/14/17 10:06 AM
 * <p/>
 * @DESCRIPTION
 **/
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {

    UserProfile findByName(String name);

}
