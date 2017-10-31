package com.comup.user.repository;

import com.comup.user.entity.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Comup
 */
@Repository
public interface SysUserRepository extends CrudRepository<SysUser, Long> {
    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    Optional<SysUser> findFirstByUsername(String username);
}
