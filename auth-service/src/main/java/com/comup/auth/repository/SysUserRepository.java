package com.comup.auth.repository;

import com.comup.auth.entity.SysUser;
import com.comup.auth.repository.support.WiselyRepository;

import java.util.Optional;

/**
 * Created by wangyunfei on 2017/6/9.
 */
public interface SysUserRepository extends WiselyRepository<SysUser, Long> {
    Optional<SysUser> findOneWithRolesByUsername(String username);
}
