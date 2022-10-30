package com.poly.edu.project.graduation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.poly.edu.project.graduation.model.UserRoleEntity;

@Repository
@Transactional
public class AppRoleDAO {

    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public List<String> getRoleNames(Long userId) {
        String sql = "Select ur.appRoleByRoleId.roleName from " + UserRoleEntity.class.getName() + " ur " //
                + " where ur.appUserByUserId.userId = :userId ";

        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

}
