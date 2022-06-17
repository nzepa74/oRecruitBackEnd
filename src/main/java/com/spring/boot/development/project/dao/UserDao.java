package com.spring.boot.development.project.dao;

import com.spring.boot.development.project.dto.RoleDto;
import com.spring.boot.development.project.helper.BaseDao;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created By zepaG on 8/13/2021.
 */
@Repository
public class UserDao extends BaseDao {
    private final Environment environment;

    public UserDao(Environment environment) {
        this.environment = environment;
    }

    @Transactional
    public List<RoleDto> getAllRoles(String id) {
        String sqlQuery = environment.getProperty("UserDao.getAllRoles");
        List<RoleDto> roles = entityManager.createNativeQuery(sqlQuery).unwrap(SQLQuery.class)
                .setParameter("id", id).setResultTransformer(Transformers.aliasToBean(RoleDto.class)).getResultList();
        return roles;
    }

    @Transactional
    public List<RoleDto> getAssignedRoles(String id) {
        String sqlQuery = environment.getProperty("UserDao.getAssignedRoles");
        List<RoleDto> roles = entityManager.createNativeQuery(sqlQuery).unwrap(SQLQuery.class)
                .setParameter("id", id).setResultTransformer(Transformers.aliasToBean(RoleDto.class)).getResultList();
        return roles;
    }

}
