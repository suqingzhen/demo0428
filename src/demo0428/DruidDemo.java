package demo0428;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

public class DruidDemo {
    public static DruidDataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/demo0428/properties"));
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ArrayList arrayList = queryStudent();
        for (Object o : arrayList) {
            System.out.println(o);
        }
        String name="黄晓飞";
        update(name,1);
        LocalDate d = LocalDate.now();
        String s = String.valueOf(d);

        add(5,"四黄","女",35,s,2);
        delete(2);
    }

    // 查询学生表所有数据,展示 s.*,c.cname
    public static ArrayList queryStudent() {
        //连接数据库
        DruidPooledConnection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<Student> st = new ArrayList<Student>();

        try {
            connection = dataSource.getConnection();
            //创建preparesStatement 接口，预编译sql语句
            pre = connection.prepareStatement("SELECT s.*,c.cname from student s,clazz c WHERE s.classid=c.cid;  ");
            //预编译，产生结果集
            rs = pre.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student = new Student(rs.getInt(1), rs.getString("name"), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7));
                st.add(student);
                // System.out.println("id:" + rs.getInt(1) + "\t name:" + rs.getString("name") + "\t sex:" + rs.getString(3) + "\t age:" + rs.getString(4)+"\t birthday:"+rs.getInt(5)+"\t classid:"+rs.getString(6)+"\t cname"+rs.getString(7));
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            try {

                if (rs != null) {
                    rs.close();
                }
                if (pre != null) {
                   pre.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        return st;
    }
    //修改id是1的同学的姓名,改为黄晓飞,其他不变
    public static void update(String name,int sid)  {
        //连接数据库
        DruidPooledConnection connection = null;
        PreparedStatement pre = null;
        ArrayList<Student> st = new ArrayList<Student>();


        try {
            connection = dataSource.getConnection();
            //创建preparesStatement 接口，预编译sql语句
            pre = connection.prepareStatement("update student set name = ? where id = ?");
             pre.setString(1,name);
             pre.setInt(2,sid);
            //预编译，产生结果集
            int i = pre.executeUpdate();
            if (i>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {


            try {
                if (pre != null) {
                    pre.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        }
    public static void add(int id ,String name, String sex, int age, String birthday, int classid)  {
        //连接数据库
        DruidPooledConnection connection = null;
        PreparedStatement pre = null;
        try {
            connection = dataSource.getConnection();
            //创建preparesStatement 接口，预编译sql语句
            pre = connection.prepareStatement("insert into student(id,name,sex,birthday,classid,age) values(?,?,?,?,?,?)");
            pre.setInt(1,id);
            pre.setString(2,name);
            pre.setString(3,sex);
            pre.setString(4,birthday);
            pre.setInt(5,classid);
            pre.setInt(6,age);
            //预编译，产生结果集
            int i = pre.executeUpdate();
            if (i>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {


            try {
                if (pre != null) {
                    pre.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
    public static void delete(int id)  {
        //连接数据库
        DruidPooledConnection connection = null;
        PreparedStatement pre = null;
        try {
            connection = dataSource.getConnection();
            //创建preparesStatement 接口，预编译sql语句
            pre = connection.prepareStatement("delete from student where id = ?");
            pre.setInt(1,id);

            //预编译，产生结果集
            int i = pre.executeUpdate();
            if (i>0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {


            try {
                if (pre != null) {
                    pre.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
    }

