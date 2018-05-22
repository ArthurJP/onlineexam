package com.jp.onlineexam.service.sys;

import com.jp.onlineexam.entity.sys.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * TODO:
 *
 * @author <a href="mailto:zhangtylord@gmail.com>张俊鹏</a>
 * @see
 * @since 5/17/2018
 */
@Service
@Transactional(readOnly = true)
public class UserService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createUser(User user){
        user.preInsert();
        entityManager.persist( user );
    }

    @Transactional
    public void updateUser(User user){
        user.preUpdate();
        entityManager.persist( user );
    }

    @Transactional
    public void delete(User user){
        entityManager.remove( user );
    }
}
