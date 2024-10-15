package konta.bai1_session12.dao.impl;

import konta.bai1_session12.dao.UserDAO;
import konta.bai1_session12.db.DatabaseUtility;
import konta.bai1_session12.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<User>();

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        con = DatabaseUtility.getConnection();
        try {
            pstmt = con.prepareStatement("select * from users");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setFullName(rs.getString("fullName"));
                u.setAddress(rs.getString("address"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));

                list.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DatabaseUtility.closeConnection(con);
        }
        return list;
    }

    @Override
    public User findById(Integer id) {
        User u = null;

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        con = DatabaseUtility.getConnection();
        try {
            pstmt = con.prepareStatement("select * from users where id=?");
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setFullName(rs.getString("fullName"));
                u.setAddress(rs.getString("address"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DatabaseUtility.closeConnection(con);
        }

        return u;
    }

    @Override
    public boolean add(User user) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DatabaseUtility.getConnection();
        try {
            pstmt = con.prepareStatement("insert into users(username,password,fullName,address,email,phone) values (?,?,?,?,?,?)");
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFullName());
            pstmt.setString(4, user.getAddress());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getPhone());

            int i = pstmt.executeUpdate();
            if(i>0)
                bl = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DatabaseUtility.closeConnection(con);
        }

        return bl;
    }

    @Override
    public boolean edit(User user) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DatabaseUtility.getConnection();
        try {
            pstmt = con.prepareStatement("update users set username=?,password=?,fullName=?,address=?,email=?,phone=? where id=?");
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFullName());
            pstmt.setString(4, user.getAddress());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getPhone());
            pstmt.setInt(7, user.getId());

            int i = pstmt.executeUpdate();
            if(i>0)
                bl = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DatabaseUtility.closeConnection(con);
        }

        return bl;
    }

    @Override
    public boolean delete(Integer id) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DatabaseUtility.getConnection();
        try {
            pstmt = con.prepareStatement("delete from users where id=?");
            pstmt.setInt(1,id);
            int i = pstmt.executeUpdate();
            if(i>0)
                bl = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DatabaseUtility.closeConnection(con);
        }

        return bl;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> list = new ArrayList<>();

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        con = DatabaseUtility.getConnection();
        try {
            if(name==null || name.isEmpty())
                name = "%";
            else
                name = "%"+name+"%";
            pstmt = con.prepareStatement("select * from users where fullName like ?");
            pstmt.setString(1,name);
            rs = pstmt.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setFullName(rs.getString("fullName"));
                u.setAddress(rs.getString("address"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                list.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DatabaseUtility.closeConnection(con);
        }

        return list;
    }
}
