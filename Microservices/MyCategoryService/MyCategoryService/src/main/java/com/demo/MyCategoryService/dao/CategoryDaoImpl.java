package com.demo.MyCategoryService.dao;

import com.demo.MyCategoryService.beans.Category;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    //@Autowired
    private JdbcClient jdbcClient;

//    public CategoryImpl(DataSource dataSource) {
//        this.jdbcClient = JdbcClient.create(dataSource);
//    }
    public CategoryDaoImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    @Override
    public List<Category> findAll() {
        return jdbcClient.sql("select * from catagory")
                .query((rs,rownum)->{
                    Category c=new Category();
                    c.setCid(rs.getInt(1));
                    c.setCname(rs.getString(2));
                    c.setCdesc(rs.getString(3));
                    return c;
                }).list();

    }

    @Override
    public Optional<Category> findById(int cid) {
        return jdbcClient.sql("select * from catagory where id=?")
                .param(cid)
                .query(Category.class).
                optional();
    }

    @Override
    public boolean save(Category c) {
//       int n= jdbcClient.sql("insert into category values(?,?,?)")
//                .param(1,c.getCid())
//                .param(2,c.getCname())
//                .param(3,c.getCdesc())
//                .update();
        int n= jdbcClient.sql("insert into catagory values(:id,:cname,:cdesc)")
                .param("id",c.getCid())
                .param("cname",c.getCname())
                .param("cdesc",c.getCdesc())
                .update();
       return n>0;
    }

    @Override
    public boolean updateByID(Category c) {
       int n= jdbcClient.sql("update catagory set cname=?,cdesc=? where id=?")
                .param(1,c.getCname())
                .param(2,c.getCdesc())
                .param(3,c.getCid())
                .update();
        return n>0;
    }

    @Override
    public boolean deleteById(int cid) {
        int n= jdbcClient.sql("delete from  catagory where id=?")
                .param(1,cid)
                .update();
        return n>0;
    }

}
