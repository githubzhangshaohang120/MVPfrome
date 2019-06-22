package com.example.tbdemo.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.tbdemo.bean.UserBean;
import com.example.tbdemo.bean.CartDaoBean;

import com.example.tbdemo.greendao.UserBeanDao;
import com.example.tbdemo.greendao.CartDaoBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userBeanDaoConfig;
    private final DaoConfig cartDaoBeanDaoConfig;

    private final UserBeanDao userBeanDao;
    private final CartDaoBeanDao cartDaoBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userBeanDaoConfig = daoConfigMap.get(UserBeanDao.class).clone();
        userBeanDaoConfig.initIdentityScope(type);

        cartDaoBeanDaoConfig = daoConfigMap.get(CartDaoBeanDao.class).clone();
        cartDaoBeanDaoConfig.initIdentityScope(type);

        userBeanDao = new UserBeanDao(userBeanDaoConfig, this);
        cartDaoBeanDao = new CartDaoBeanDao(cartDaoBeanDaoConfig, this);

        registerDao(UserBean.class, userBeanDao);
        registerDao(CartDaoBean.class, cartDaoBeanDao);
    }
    
    public void clear() {
        userBeanDaoConfig.clearIdentityScope();
        cartDaoBeanDaoConfig.clearIdentityScope();
    }

    public UserBeanDao getUserBeanDao() {
        return userBeanDao;
    }

    public CartDaoBeanDao getCartDaoBeanDao() {
        return cartDaoBeanDao;
    }

}