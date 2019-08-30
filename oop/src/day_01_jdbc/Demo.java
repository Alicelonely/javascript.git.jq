package day_01_jdbc;

import utils.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) throws Exception {

        //加载驱动
        Connection c = DBUtils.getConnection();
        //Statement：接口，调用方法实际返回的是实现类的对象，只不过使用接口来进行接收
        Statement st = c.createStatement();
        //定义sql语句创建一张表
        String sql = "create table demo(id number(7),name varchar2(30))";
        //发送sql给数据库
        //如果方法返回true，代表有结果集，如果返回false，代表没有结果集，如果创建失败会抛出异常
        //如果没有出现异常就创建成功
        boolean b = st.execute(sql);
        System.out.println(b);

        //关闭资源
        c.close();


        /**
         * jdbc的使用步骤
         * 1.在项目中导入jdbc驱动包（jar包），oracle和mysql的jar包不一样，在项目中新建lib文件夹，将jar包复制进去，bulid path 加载进类库
         * 2.注册jdbc驱动
         *  Class.forName("驱动程序类名")；
         * 3.获取Connection对象，连接到数据库，需要提供三个参数，url，username，password
         * 4.创建Statement s = Connection对象.createStatement();
         * 5.处理sql执行结果
         *      execute:没有异常，则成功
         *      executeUpdate：返回数字，表示更新了“行”数量
         *      exexuteQuery：返回ResultSet代表查询结果，多行多列，使用for循环遍历处理，如果失败则抛出异常
         * 6.关闭数据库连接
         *  连接对象，close();
         */


        /**
         * 管理数据可连接：
         *      在程序中数据库连接使用非常频繁，如果每次都创建连接，写相同的代码
         *      会非常繁杂，
         *      常规的做法是建立数据库连接工具，封装数据库连接过程，简化数据库的连接过程，使用起来更加方便
         *
         * 属性配置文件：后缀名为.properties
         * key---value
         *
         *  properties类：为了读取*，properties文件而设计的，底层io，
         *  并且限定了值必须为字符串
         */


        /**
         *
         * 连接管理实现过程：
         *          1.创建数据可连接参数文件：jdbc.properties
         *          2.创建DBUtils.java封装数据库连接方法
         *                  利用properties对象读取配置文件中的连接数据库参数数据
         *                  创建getConnection封装数据连接信息
         *                  创建close()关闭资源连接
         *          3.使用getConnetion方法获取连接
         *          */




        /**
         *
         * 尽量减少sql语句的变更，让他重用执行计划
         *
         *      PreparedStatement:预编译语句对象，用于执行带参数的预编译执行计划
         *
         *    关于执行计划：
         *      1.任何sql执行过程都是先变异“执行计划”在执行“执行计划”
         *      2.数据库为了优化性能，在sql相同的时候，会重用执行计划，执行计划编译比较慢，重用执行计划可以提高数据库的性能
         *      3.数据库只在sql语句中完全一样的情况下才会重用执行计划，
         *      如果sql语句中有一个字符的改变，也会执行不同的执行计划
         *      包括空格和大小写的改变
         *
         *      PreparedStatement的好处：
         *            1.可以防止重复使用执行计划，提高数据库的性能
         *            2.防止sql注入
         */
    }
}
