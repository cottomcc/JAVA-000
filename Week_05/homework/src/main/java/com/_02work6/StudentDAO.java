package com._02work6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAO {
    private PreparedStatement statement;
    private ResultSet resultSet;

    public Student getById(int id) {

        try {
            Student result = new Student();
            Connection connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement("select id, name from student where id=?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
              result.setId(resultSet.getInt(1));
              result.setName(resultSet.getString(2));
            }
            return result;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteById(int id) {
        try {
            Connection connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement("delete from student where id=?");
            statement.setInt(1, id);
            statement.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void add(Student student) {
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "insert into student(name)values(?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void batchAdd(List<Student> students) {
        Connection connection = null;
        boolean autoCommit = false;
        try {

            connection = JDBCUtil.getConnection();
            autoCommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            String sql = "insert into student(name)values(?)";
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                statement.setString(1, student.getName());
                statement.addBatch();
            }

            statement.executeBatch();
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (null != connection) {
                try {
                    connection.setAutoCommit(autoCommit);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public void update(Student student) {
        try {
            String sql = "update student set name=? where id=?";
            Connection connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getId());
            statement.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
