package com.eadydb.boot.repository;

import com.eadydb.boot.entity.SysUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dengbin on 16-11-25.
 */
@Repository
public interface SysUserRepository extends PagingAndSortingRepository<SysUser, Long> {

    /**
     * 通过username查找用户信息
     *
     * @param username
     * @return
     */
    public SysUser findByUsername(String username);
}
