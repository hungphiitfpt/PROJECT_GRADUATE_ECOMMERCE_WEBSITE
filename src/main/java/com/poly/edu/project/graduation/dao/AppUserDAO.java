package com.poly.edu.project.graduation.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.poly.edu.project.graduation.model.AppUserEntity;

@Repository
@Transactional
public class AppUserDAO extends HttpServlet{

    @Autowired
    private EntityManager entityManager;

    public AppUserEntity findUserAccount(String userName) {
        try {
            String sql = "Select e from " + AppUserEntity.class.getName() + " e " //
                    + " Where e.userName = :userName ";

            Query query = entityManager.createQuery(sql, AppUserEntity.class);
            query.setParameter("userName", userName);
            return (AppUserEntity) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
