package com.family.dataConnectionSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

/**
 * 测试C3P0数据源
 * @author: gzb
 * @date  : 2019年8月8日 下午5:33:33
 *
 */
public class DataSourceC3P0Test {
    
    @Test
    public void c3p0DataSourceTest() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            //获取数据库连接
            conn = JdbcUtils_C3P0.getConnection();
            String sql = "insert into test1(name) values(?)";
            st = conn.prepareStatement(sql);
            st.setString(1, "gacl");
            st.executeUpdate();
            //获取数据库自动生成的主键
            rs = st.getGeneratedKeys();
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            JdbcUtils_C3P0.release(conn, st, rs);
        }
    }
}
