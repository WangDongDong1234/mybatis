package com.atguigu.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: mybatis
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-12-02 00:14
 **/
public class Main {
    public static void main(String[] args) throws IOException {
      test();
    }

    /**
     * 1.根据mybatis-conf.xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
     *          (包括数据源，以及mapper.xml文件的位置)
     * 2.mapper.xml即sql映射文件，配置了每一个sql,以及sql的封闭规则
     * 3.将mapper.xml文件注册到全局配置文件中
     * 4.写代码
     *      1)根据全局配置文件得到SqlSessionFactroy
     *      2)使用sqlSession工厂，获取到sqlSession对象使用它来执行，一个sqlSession就代表和数据库的一次
     *          会话，用完关闭
     *      3）使用sql的唯一标识来告诉MyBatis执行那个sql，sql都是保存在Mapper.xml文件中
     * @throws IOException
     */
    public static void test() throws IOException{
        String resource = "mybatis-conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlSession实例，能直接执行已经映射的sql语句
        SqlSession openSession=sqlSessionFactory.openSession();
        try {
            Employee employee = openSession.selectOne("selectEmp", 1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }
}
