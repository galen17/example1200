package com.family.ClassFanShe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: gzb
 * @date  : 2019年7月29日 下午3:17:10
 *
 */
public class JavaBeanTest {
    
    public static <T> List<T>  getBean(ResultSet rs, T object) throws Exception {
        Class<?> classType = object.getClass();
        ArrayList<T> objList = new ArrayList<T>();
        //SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
        Field[] fields = classType.getDeclaredFields();//得到对象中的字段
        while (rs.next()) {
            //每次循环时，重新实例化一个与传过来的对象类型一样的对象
            T objectCopy = (T) classType.getConstructor(new Class[] {}).newInstance(new Object[] {});
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldName = field.getName();
                Object value = null;
                //根据字段类型决定结果集中使用哪种get方法从数据中取到数据
                if (field.getType().equals(String.class)) {
                    value = rs.getString(fieldName);
                    if(value==null){
                        value="";
                    }
                }
                if (field.getType().equals(int.class)) {
                    value = rs.getInt(fieldName);
                }
                if (field.getType().equals(java.util.Date.class)) {
                    value = rs.getDate(fieldName);
                }
                // 获得属性的首字母并转换为大写，与setXXX对应
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String setMethodName = "set" + firstLetter
                        + fieldName.substring(1);
                Method setMethod = classType.getMethod(setMethodName,
                        new Class[] { field.getType() });
                setMethod.invoke(objectCopy, new Object[] { value });//调用对象的setXXX方法
            }
            
            objList.add(objectCopy);
        }
        if(rs != null){
            rs.close();
        }
        return objList;
    }
}
