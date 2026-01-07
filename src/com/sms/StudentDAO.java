
	
	package com.sms;

	import java.sql.*;

	public class StudentDAO {

	    Connection con = DBConnection.getConnection();

	    // Insert Student
	    public void addStudent(Student s) {
	        try {
	            String sql = "INSERT INTO student(name,email,course) VALUES(?,?,?)";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, s.getName());
	            ps.setString(2, s.getEmail());
	            ps.setString(3, s.getCourse());
	            ps.executeUpdate();
	            System.out.println("✅ Student Added Successfully");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // View Students
	    public void viewStudents() {
	        try {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM student");

	            while (rs.next()) {
	                System.out.println(
	                        rs.getInt("id") + " | " +
	                        rs.getString("name") + " | " +
	                        rs.getString("email") + " | " +
	                        rs.getString("course")
	                );
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // Search Student
	    public void searchStudent(int id) {
	        try {
	            String sql = "SELECT * FROM student WHERE id=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                System.out.println(
	                        rs.getInt("id") + " | " +
	                        rs.getString("name") + " | " +
	                        rs.getString("email") + " | " +
	                        rs.getString("course")
	                );
	            } else {
	                System.out.println("❌ Student Not Found");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // Update Student
	    public void updateStudent(int id, String course) {
	        try {
	            String sql = "UPDATE student SET course=? WHERE id=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, course);
	            ps.setInt(2, id);
	            ps.executeUpdate();
	            System.out.println("✅ Student Updated");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // Delete Student
	    public void deleteStudent(int id) {
	        try {
	            String sql = "DELETE FROM student WHERE id=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            ps.executeUpdate();
	            System.out.println("✅ Student Deleted");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



