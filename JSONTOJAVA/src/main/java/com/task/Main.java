/*
Java code and jdbc operations,
for converting multiple json to string and then fetching the details from the json string using objectmapper
which converts the converted string into java objects which will help to fetch th data from the json.
After fetching the required data compare with the databse and give the expected output to the user.
*/

package com.task;

import com.database.Employee;
import com.database.SelectOperationDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        //converting the jso into string and storing them into str variables to access later

        String str1 ="{\"id\":\"1\",\"rules\":[{\"field_name\":\"age\",\"field_type\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"gt\",\"value\":\"21\"}},{\"field_name\":\"rank\",\"field_type\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"3\"}}]}";
        String str2 = "{\"id\":\"2\",\"rules\":[{\"field_name\":\"age\",\"field_type\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"gt\",\"value\":\"30\"}},{\"field_name\":\"rank\",\"field_type\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"gteq\",\"value\":\"5\"}}]}";
        String str3 = "{\"id\":\"3\",\"rules\":[{\"field_name\":\"state\",\"field_type\":\"string\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"Maharashtra\"}},{\"field_name\":\"city\",\"field_type\":\"string\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"Pune\"}},{\"field_name\":\"age\",\"field_type\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"lt\",\"value\":\"30\"}},{\"field_name\":\"rank\",\"field_type\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"3\"}}]}";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value");           //take usr input to jnow what to search in the json
        String inStr = sc.next();

        List<String> stringList = new ArrayList<>();        //initializing arraylist
        stringList.add(str1);                               //storing the strings in the stringList List
        stringList.add(str2);
        stringList.add(str3);

        HashMap<String, Object> map = new LinkedHashMap<>();         //initializing LinkedHashMap for storing the user input i key value pair
        int strListNo = 0;
        while (strListNo < stringList.size()) {                      //while loop to cotinue until all strings are checked
            if (inStr.indexOf(",") > 1) {                            //splitting the user input based on comma
                String[] arr = inStr.split(",");
                for (String s : arr) {
                    String[] varArr = s.split("=");            //splitting based on = sign
                    map.put(varArr[0], varArr[1]);                   //storing in key-value pair in the MAP
                }
            } else System.out.println("Insuffiecient data");

            ObjectMapper objectmapper = new ObjectMapper();         //it turns json string to objects and vice-versa
            Criteria criteria = objectmapper.readValue(stringList.get(strListNo), Criteria.class);   //to convert json string into objects

            List list = new ArrayList();               //initialized list to store the boolean values of the MAP

            boolean validated;
            for (Rule r : criteria.getRules()) {          //looping in the rules list
                //System.out.println(criteria.getRules());
                for (String inKey : map.keySet()) {       //looping till all the key-values are checked


                        if (inKey.equals(r.getFieldName())) {
                            Condition condition = r.getCondition();
                            validated = validate(map.get(inKey).toString(), r.getFieldType(), condition);
                            list.add(validated);            //add the boolean in the list
                            //checkValidatedData(validated);
                        }

                }
            }

        /*System.out.println(list.size());
        for (Object b:list) {
            System.out.println(b);
        }*/

            int i = 0;
            int id;
            try {
                while (i < list.size()) {              //looping till the end of thelist
                    if (!list.contains(false)) {             //if any value is false return
                        id = Integer.parseInt(criteria.getId());
                        if (id != 0) {                       //if value is true store in id and pass the id
                            pass(id);
                            break;
                        }
                    } else System.out.println("False");
                    i++;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("");
            }
            strListNo++;
        }
    }

    public static void pass(int id){                        //the passed id is then checked with db and the corresponding output is returned.
        SelectOperationDAO dao = new SelectOperationDAO();
        Employee emp1 =	dao.selectEmployeeById(id);
        System.out.println(emp1);
    }



    public static boolean validate(String input, String type, Condition condition) {      //validate method to check the key-value are true or false according to operators.
        if(condition.getOperator().equals("gt")) {
            return Integer.parseInt(input) > Integer.parseInt(condition.getValue());
        }
        if(condition.getOperator().equals("lt")) {
            return Integer.parseInt(input) < Integer.parseInt(condition.getValue());
        }
        if(condition.getOperator().equals("eq")) {
            return input.equals(condition.getValue());
        }
        if(condition.getOperator().equals("gteq")) {
            return Integer.parseInt(input) >= Integer.parseInt(condition.getValue());
        }
        return false;
    }

}
