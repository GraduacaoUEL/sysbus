package DAO;

import beans.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDAO {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    public CarroDAO(){
        
    }
    
    private Connection getConnection() throws SQLException{
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
    
    
    public void add(Carro carro){
        try{
            String queryString = "INSERT INTO carro(codigo_carro, numero_passageiros) VALUES(?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, carro.getId());
            ptmt.setInt(2, carro.getNumeroDePassageiros());
            ptmt.executeUpdate();
            System.out.println("Sucesso");
            
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(ptmt != null)
                    ptmt.close();
                if(connection != null)
                    connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}

/*
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class StudentJDBCDAO {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    public StudentJDBCDAO() {
        
    }
    
    private Connection getConnection() throws SQLException{
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
    
    public void add(StudentBean studentBean){
        try{
            String queryString = "INSERT INTO student(RollNo, Name, Course, Address) VALUES(?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, studentBean.getRollNo());
            ptmt.setString(2, studentBean.getName());
            ptmt.setString(3, studentBean.getCourse());
            ptmt.setString(4, studentBean.getAddress());
            ptmt.executeUpdate();
            System.out.println("Data Added Successfully");
            
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(ptmt != null)
                    ptmt.close();
                if(connection != null)
                    connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void delete(int rollNo){
        try{
            String queryString = "DELETE FROM student WHERE RollNo=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, rollNo);
            ptmt.executeUpdate();
            
            System.err.println("Data deleted Successfully");
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(ptmt != null)
                    ptmt.close();
                if(connection != null)
                    connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }    
}

*/