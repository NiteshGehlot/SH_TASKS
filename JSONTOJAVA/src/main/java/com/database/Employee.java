//EMPLOYEE POJO TO ACCESS /SET  IN THE DATABASE

package com.database;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@NoArgsConstructor
@ToString
public class Employee {

    private  int eid;
    private String ename;
    private double salary;
    private  String job;
    private Date doj;



}
