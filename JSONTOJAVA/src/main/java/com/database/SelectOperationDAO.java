//ALL CRUD OPERATIONS SHOULD BE DONE IN THIS CLASS

package com.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectOperationDAO {
    Connection conn = DBUtil.getDBConnection();

    public Employee selectEmployeeById(int eid) {

        String selectQuery = "select * from employee where eid = ?";

        PreparedStatement pstmt;

        Employee emp = new Employee();

        try {
            pstmt = conn.prepareStatement(selectQuery);

            pstmt.setInt(1, eid);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                emp.setEid(rs.getInt("eid"));
                emp.setEname(rs.getString("ename"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setDoj(rs.getDate("doj"));
                emp.setJob(rs.getString("job"));

            }
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return emp;

    }

}
