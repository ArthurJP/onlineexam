package com.jp.onlineexam.repo.sys;

import com.jp.onlineexam.entity.sys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * TODO:
 *
 * @author <a href="mailto:zhangtylord@gmail.com>张俊鹏</a>
 * @see
 * @since 5/17/2018
 */
@Repository
public class UserRepo extends SimpleJpaRepository<User,Long> {
    @Autowired
    public UserRepo(EntityManager em) {
        super(User.class,em);
    }
}
