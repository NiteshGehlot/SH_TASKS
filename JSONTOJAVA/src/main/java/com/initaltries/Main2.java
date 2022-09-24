/*
Java code and jdbc operations,
for converting one json to string and then etching the details from the json string using objectmapper
which converts the converted string into java objects which will help to fetch th data from the json.
After fetching the required data compare with the databse and give the expected output to the user.
*/


package com.initaltries;

import com.database.Employee;
import com.database.SelectOperationDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.Condition;
import com.task.Criteria;
import com.task.Rule;

import java.io.IOException;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {

        String str = "{\"id\":\"3\",\"rules\":[{\"field_name\":\"state\",\"field_type\":\"string\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"Maharashtra\"}},{\"field_name\":\"city\",\"field_type\":\"string\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"Pune\"}},{\"field_name\":\"age\",\"field_type\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"lt\",\"value\":\"30\"}},{\"field_name\":\"rank\",\"field_type\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"3\"}}]}";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value");
        String inStr = sc.next();

        HashMap<String, Object> map = new LinkedHashMap<>();

        if (inStr.indexOf(",") > 1) {
            String[] arr = inStr.split(",");
            for (String s : arr) {
                String[] varArr = s.split("=");
                map.put(varArr[0], varArr[1]);
            }
        }else System.out.println("Insuffiecient data");

        ObjectMapper objectmapper = new ObjectMapper();
        Criteria criteria = objectmapper.readValue(str, Criteria.class);

        List list = new ArrayList();

        boolean validated;
        for (Rule r : criteria.getRules()) {
            for (String inKey : map.keySet()) {
                if (inKey.equals(r.getFieldName())) {
                    Condition condition = r.getCondition();
                    validated = validate(map.get(inKey).toString(), r.getFieldType(), condition);
                    list.add(validated);
                    //checkValidatedData(validated);
                }
            }
        }

        /*System.out.println(list.size());
        for (Object b:list) {
            System.out.println(b);
        }*/

       int i=0;
       int id;
       try {
           while (i < list.size()) {
               System.out.println(list.get(i));
               if(!(list.get(i).equals(false))) {
                       id = Integer.parseInt(criteria.getId());
                       if(id != 0) {
                           pass(id);
                           break;
                       }
                   } else System.out.println("False");
               i++;
           }
       }
       catch (IndexOutOfBoundsException e){
           System.out.println("");
       }
    }

    public static void pass(int id){
        SelectOperationDAO dao = new SelectOperationDAO();
        Employee emp1 =	dao.selectEmployeeById(id);
        System.out.println(emp1);
    }



    public static boolean validate(String input, String type, Condition condition) {
        if(condition.getOperator().equals("gt")) {
            return Integer.parseInt(input) > Integer.parseInt(condition.getValue());
        }
        if(condition.getOperator().equals("lt")) {
            return Integer.parseInt(input) < Integer.parseInt(condition.getValue());
        }
        if(condition.getOperator().equals("eq")) {
            System.out.println(input.equals(condition.getValue()));
            return input.equals(condition.getValue());
        }
        if(condition.getOperator().equals("gteq")) {
            return Integer.parseInt(input) >= Integer.parseInt(condition.getValue());
        }
        return false;
    }

}






       /* ListIterator<Rule> ir = criteria.getRules().listIterator();
        while (ir.hasNext()) {
            Rule iterator = ir.next();
            if((key.equals(iterator.getFieldName()))) {
                if (iterator.getCondition().getOperator().equals("gt")) {
                    if (Integer.parseInt(value) > Integer.parseInt(iterator.getCondition().getValue())) {
                        System.out.println(criteria);
                    }
                } else if (iterator.getCondition().getOperator().equals("eq")) {
                    if (Integer.parseInt(value) == Integer.parseInt(iterator.getCondition().getValue())) {
                        System.out.println(criteria);
                    }
                } else if (iterator.getCondition().getOperator().equals("lt")) {
                    if (Integer.parseInt(value) < Integer.parseInt(iterator.getCondition().getValue())) {
                        System.out.println(criteria);
                    }

                }else if (iterator.getCondition().getOperator().equals("gteq")){
                    if (Integer.parseInt(value) >= Integer.parseInt(iterator.getCondition().getValue())) {
                        System.out.println(criteria);
                    }
                }else
                    System.out.println("False");
            }else
                System.out.println("False");*/



