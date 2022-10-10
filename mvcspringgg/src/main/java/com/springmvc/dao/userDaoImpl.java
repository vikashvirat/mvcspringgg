package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
//import javax.swing.tree.RowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springmvc.model.Login;
import com.springmvc.model.User;

public class userDaoImpl implements userDao
{
	@Autowired
DataSource datasource;
	@Autowired
JdbcTemplate jdbctemplate;



//   String name = registerBean.getname();

public void register(User user)
{
//	String Regdno = user.getRegdno();
//	String Sname= user.getSname();
//	String Userid = user.getUserid();
//	String Password = user.getPassword();
//	String Mobile = user.getMobile();
	String sql="insert into register values(?,?,?,?,?)";
	jdbctemplate.update(sql,new Object[] {user.getRegdno(),user.getSname(),user.getUserid(),user.getPassword(),user.getMobile()});
}
//public List<User> validateUser(Login login)
//{
//	String sql="select * from register where userid='" + login.getUserId() + "'and password='" + login.getPassword()+"'";
// //List<User> users=jdbctemplate.query(sql,new UserMapper());
////return users.size()>0? users.get(0):null;
// return jdbctemplate.query(sql,new RowMapper<User>)
//}
}
//class UserMapper implements RowMapper<User>
//{
//	public User mapRow(ResultSet rs,int argl) throws SQLException {
//		User user=new User();
//		user.setUserid(rs.getNString("uid"));
//		user.setSname(rs.getString("nm"));
//		user.setRegdno(rs.getString("regd"));
//		user.setPassword(rs.getString("pwd"));
//		user.setMobile(rs.getString("mob"));
//		return user;
//	}
//}
public User validateUser(Login login) {

    String sql = "select * from register where Userid ='" + login.getUserid() + "' and Password='" + login.getPassword()
    + "'";

    List<User> users = jdbctemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
    }

  }

class UserMapper implements RowMapper<User>
{
	public User mapRow(ResultSet rs,int argl) throws SQLException {
		User user=new User();
 	    user.setRegdno(rs.getString("Userid"));
		user.setPassword(rs.getString("Password"));
		
		return user;
	}
}

