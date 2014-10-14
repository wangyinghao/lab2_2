package wang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

//import model.Book;
//import util.DB;
import DBUtil.DBUtil;

public class BookService {
	public void add(Book b) {
		Connection conn = DBUtil.getConn();
		String sql = "insert into book values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = DBUtil.prepare(conn, sql);
		try {
			ps.setString(1, b.getISBN());
			ps.setString(2, b.getTitle());
			ps.setInt(3, b.getAuthorID());
			ps.setString(4, b.getPublisher());
			ps.setString(5, b.getPublishDate());
			ps.setFloat(6, b.getPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(ps);
		DBUtil.close(conn);
	}

	public List<Book> list(String name) {
		Connection conn = DBUtil.getConn();
		String sql;
		if (name != "")
			sql = "select * from author where name=" + "\"" + name + "\"";
		else
			sql = "";
		Author au = new Author();
		PreparedStatement ps = DBUtil.prepare(conn, sql);
		try {
			ResultSet rss = ps.executeQuery();
			if (rss.next()) {
				au.setAuthorID(rss.getInt(1));
				au.setName(rss.getString(2));
				au.setAge(rss.getInt(3));
				au.setCountry(rss.getString(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql="select * from book where authorid="+au.getAuthorID();
		ps = DBUtil.prepare(conn, sql);
		List<Book> books = new ArrayList<Book>();
		try {
			ResultSet rs = ps.executeQuery();
			Book b = null;
			while (rs.next()) {
				b = new Book();
				b.setISBN(rs.getString("ISBN"));
				b.setTitle(rs.getString("Title"));
				b.setAuthorID(rs.getInt("AuthorID"));
				b.setPublisher(rs.getString("Publisher"));
				b.setPublishDate(rs.getString("PublishDate"));
				b.setPrice(rs.getFloat("Price"));
				books.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.close(ps);
		DBUtil.close(conn);
		return books;
	}

	public void delete(Book b) {
		deleteByISBN(b.getISBN());
	}

	public void deleteByISBN(String ISBN) {
		Connection conn = DBUtil.getConn();
		String sql = "delete from Book where ISBN=?";
		PreparedStatement ps = DBUtil.prepare(conn, sql);
		try {
			ps.setString(1, ISBN);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.close(ps);
		DBUtil.close(conn);
	}
	
	
	public void detail(Book b) {
		detailByISBN(b.getISBN());
	}
	public  List<Book> detailByISBN(String ISBN) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from Book where ISBN=" + "\"" + ISBN + "\"";
		PreparedStatement pps = DBUtil.prepare(conn, sql);
		List<Book> books = new ArrayList<Book>();
		try {
			ResultSet rs1 = pps.executeQuery();
			Book b = null;
			if (rs1.next()) {
				b=new Book();
				b.setISBN(rs1.getString("ISBN"));
				b.setTitle(rs1.getString("Title"));
				b.setAuthorID(rs1.getInt("AuthorID"));
				b.setPublisher(rs1.getString("Publisher"));
				b.setPublishDate(rs1.getString("PublishDate"));
				b.setPrice(rs1.getFloat("Price"));
				books.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.close(pps);
		DBUtil.close(conn);
		return books;
	}
	public  List<Author> audetailByISBN(String ISBN) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from Book where ISBN=" + "\"" + ISBN + "\"";
		PreparedStatement pps = DBUtil.prepare(conn, sql);
		//List<Author> authors = new ArrayList<Author>();
		Book b =new Book();
		try {
			ResultSet rs1 = pps.executeQuery();
			
			if (rs1.next()) {
				
				b.setISBN(rs1.getString("ISBN"));
				b.setTitle(rs1.getString("Title"));
				b.setAuthorID(rs1.getInt("AuthorID"));
				b.setPublisher(rs1.getString("Publisher"));
				b.setPublishDate(rs1.getString("PublishDate"));
				b.setPrice(rs1.getFloat("Price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql="select * from author where authorid="+b.getAuthorID();
		pps = DBUtil.prepare(conn, sql);
		List<Author> authors = new ArrayList<Author>();
		try {
			ResultSet rs1 = pps.executeQuery();
			Author au = null;
			while (rs1.next()) {
				au=new Author();
				au.setAuthorID(rs1.getInt(1));
				au.setName(rs1.getString(2));
				au.setAge(rs1.getInt(3));
				au.setCountry(rs1.getString(4));
				authors.add(au);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.close(pps);
		DBUtil.close(conn);
		return authors;
	}
}
