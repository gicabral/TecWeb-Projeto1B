package mvc.model;


import java.sql.Connection;

import java.time.LocalTime;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import mvc.*;



public class DAO {
	private Connection connection = null;
	String url = System.getenv("mysql_url");
	String user = System.getenv("mysql_user");
	String password = System.getenv("mysql_password");
	
	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(
					url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void register(Pessoas pessoa) throws SQLException {
		String usuario = pessoa.getUsuario();
		String senha = pessoa.getSenha();
		PreparedStatement ps = connection.prepareStatement("INSERT INTO usuarios (usuario, senha) VALUES (?,?)");
		ps.setString(1, usuario);
		ps.setString(2, senha);
		ps.execute();
		ps.close();
	}
	
	public void login(Pessoas pessoa) throws SQLException {
		String usuario = pessoa.getUsuario();
		String senha = pessoa.getSenha();		
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND senha = ?");
		ps.setString(1, usuario);
		ps.setString(2, senha);
		ps.execute();
		ps.close();
	}
	
	public static Connection getConnection(){  
	    Connection con=null;  
		String url = System.getenv("mysql_url");
		String user = System.getenv("mysql_user");
		String password = System.getenv("mysql_password");
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection(url,user,password);  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static int save(User u){  
	    int status=0;  
	    if (u.getName().isEmpty() || u.getQuestion().isEmpty() || u.getImportance().isEmpty()) {
	    	System.out.println("ta vazio");

	    }else {
	    	try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement("insert into register(name,question, importance) values(?,?,?)");  
		        ps.setString(1,u.getName());  
		        ps.setString(2,u.getQuestion()); 
		        ps.setString(3,u.getImportance());   
		        status=ps.executeUpdate();
		        System.out.print("oi");
		        
		    }catch(Exception e){System.out.println(e);}  
	    }
	    return status;
	    
	    
	}  
	public static int update(User u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("update register set name=?,question=?,importance=? where id=?");  
	        ps.setString(1,u.getName());  
	        ps.setString(2,u.getQuestion()); 
	        ps.setString(3,u.getImportance()); 
	        ps.setInt(4,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	 
	
	public static int delete(User u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from register where id=?");  
	        ps.setInt(1,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	public static List<User> getAllRecords(){  
	    List<User> list=new ArrayList<User>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from register");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            User u=new User();  
	            u.setId(rs.getInt("id"));  
	            u.setName(rs.getString("name"));  
	            u.setQuestion(rs.getString("question"));
	            u.setAnswer(rs.getString("answer"));  
	            u.setImportance(rs.getString("importance"));  

	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	

	public static User getRecordById(int id){  
	    User u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from register where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new User();  
	            u.setId(rs.getInt("id"));  
	            u.setName(rs.getString("name"));  
	            u.setQuestion(rs.getString("question")); 
	            u.setAnswer(rs.getString("answer")); 
	            u.setImportance(rs.getString("importance"));   

	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	} 
		
	
	public static int updateAnswer(User u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("update register set answer=? where id=?");  
	        ps.setString(1,u.getAnswer());  
	        ps.setInt(2,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	} 
	

	
	public static int deleteImportance(User u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from register where importance=?");  
	        ps.setString(1,u.getImportance());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	

	


	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


