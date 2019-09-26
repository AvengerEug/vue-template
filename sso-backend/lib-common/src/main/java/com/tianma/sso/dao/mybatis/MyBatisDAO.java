package com.tianma.sso.dao.mybatis;

import com.tianma.sso.dao.BaseDAO;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class MyBatisDAO<T, K> extends SqlSessionDaoSupport implements BaseDAO<T, K> {

    private static final String NAME_SPACE_SEPARATOR = ".";
    private static final String CREATE = "create";
    private static final String UPDATE = "update";
    private static final String DELETE = "delete";
    private static final String GET_ALL = "getAll";
    private static final String GET_BY_ID = "getById";

    @SuppressWarnings("unchecked")
    private Class<T> getActuallClassType() {
        Class<T> classType = null;
        ParameterizedType parameterizedClass = (ParameterizedType) this
                .getClass().getGenericSuperclass();
        classType = (Class<T>) parameterizedClass.getActualTypeArguments()[0];
        return classType;
    }

    /**
     * 需要注入父类的sqlSessionTemplate, 所以新增@Autowired注解
     * @param sqlSessionTemplate
     */
    @Override
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    protected String getSqlNameSpace() {
        String sqlNameSpace = StringUtils.EMPTY;
        Class<T> classType = this.getActuallClassType();
        if (classType != null) {
            sqlNameSpace = classType.getName();
        }
        return sqlNameSpace + NAME_SPACE_SEPARATOR;
    }

    @Override
    public T create(T entity) {
        String insertStatement = this.getSqlNameSpace() + CREATE;
        this.getSqlSession().insert(insertStatement, entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        String updateStatement = this.getSqlNameSpace() + UPDATE;
        this.getSqlSession().update(updateStatement, entity);
        return entity;
    }

    @Override
    public List<T> getAll() {
        String selectStatement = this.getSqlNameSpace() + GET_ALL;
        List<T> entity = (List<T>) this.getSqlSession().selectList(selectStatement);
        return entity;
    }

    @Override
    public T getById(K id) {
        String selectStatement = this.getSqlNameSpace() + GET_BY_ID;
        T entity = (T) this.getSqlSession().selectOne(selectStatement, id);
        return entity;
    }

    @Override
    public void delete(K id) {
        String deleteStatement = this.getSqlNameSpace() + DELETE;
        this.getSqlSession().delete(deleteStatement, id);
    }

    public List<Map<String, Object>> selectResultAsListMap(String queryName,
                                                           Object parameter) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        String selectStatement = this.getSqlNameSpace() + queryName;
        result = this.getSqlSession().selectList(selectStatement, parameter);
        return result;
    }

}
