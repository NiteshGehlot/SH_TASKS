/*
package com.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String str = "{\"id\":\"1\",\"rules\":[{\"field_name\":\"age\",\"field_type\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"gt\",\"value\":\"21\"}},{\"field_name\":\"rank\",\"field_type\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"3\"}}]}";



       */
/* Resource resource = new ClassPathResource("C:\\Users\\niteshmanish.gehlot\\Desktop\\course.json");
        JsonFactory jsonFactory = new JsonFactory();
        ObjectMapper objectMapper = new ObjectMapper(jsonFactory);

        JsonNode arrayNode = objectMapper.readTree(resource.getFile()).get("fieldName");
        if(arrayNode.isArray()){
            for(JsonNode jsonNode:arrayNode){
                String nameFieldNode = jsonNode.get("fieldType").asText();

            }
        }*//*


        List<String> input = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value");
        String value=sc.next();

       // String value = sc.next();
       // String keyvalue="";
        //String key[] = new String[0];
        //String value1[] = new String[0];
        String key="";
        String value1 ="";
        String[] keyvalue = new String[0];

            keyvalue = value.split("=");
            key = keyvalue[0];
            value1 = keyvalue[1];

       // String keyvalue[] = value.split("=");
       // String key = keyvalue[0];
       // String value1 = keyvalue[1];



        ObjectMapper objectmapper = new ObjectMapper();
        Criteria criteria = objectmapper.readValue(str, Criteria.class);
        //System.out.println(criteria);

        ListIterator<Rule> ir = criteria.getRules().listIterator();
        while (ir.hasNext()){
            Rule iterator = ir.next();
            if((value1.equals(iterator.getCondition().getValue())) && (key.equals(iterator.getFieldName()))){
                System.out.println(criteria);
            }else
                System.out.println("False");


            System.out.println(iterator.getCondition().getOperator());

            if(iterator.getCondition().getOperator().equals("gt")){
                if(Integer.parseInt(value1) > Integer.parseInt(iterator.getCondition().getValue())){
                    System.out.println("true");
                }


                System.out.println(value1.compareTo(iterator.getCondition().getValue()));
                System.out.println("true");
            }else
                System.out.println("false");

            //System.out.println(value1.equals(ir.next().getCondition().getValue()));
        }


        */
/*JsonNode jsonNode = new ObjectMapper().readValue(str,JsonNode.class);
        if(key.equals(jsonNode.findValue("field_name"))) {
            System.out.println("true");
        }
        else
            System.out.println("false");

        System.out.println(jsonNode.findValues("field_name"));
*//*




*/
/*   //     -------------------------Using jsonn object---------------------------------------------
        JSONObject obj = new JSONObject(str);
      //  System.out.println(obj.getString("id"));
        JSONArray rules = obj.getJSONArray("rules");
        int n = rules.length();
        for (int i = 0; i < n; ++i) {
            JSONObject person = rules.getJSONObject(i);

            if(key.equals(person.getString("field_name")) && value1.equals(person.getJSONObject("condition").getString("value"))){
                System.out.println(criteria);
            }
            else{
                System.out.println("false");
            }
     //       --------------------------------------------------------------------------------------------------
            *//*



          //  System.out.println(person.getString("field_name"));
          //  System.out.println(person.getJSONObject("condition").getString("value"));







        */
/*String str = "{\"id\":\"1\",\"rules\":[{\"field_name\":\"age\",\"field_type\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"gt\",\"value\":\"21\"}},{\"field_name\":\"rank\",\"field_type\":\"numeric\",\"condition\":{\"type\":\"validation\",\"operator\":\"eq\",\"value\":\"3\"}}]}";

        ObjectMapper objectMapper = new ObjectMapper();

        Criteria criteria;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value");
        String value = sc.next();
        String keyvalue[] = value.split("=");
        String key = keyvalue[0];
        String value1 = keyvalue[1];
        System.out.println(key);
        System.out.println(value1);

        Rule rule ;
        Condition condition;




        {
            try {

                criteria = objectMapper.readValue(str, Criteria.class);
                String criteria1 = criteria.toString();



    //            System.out.println(Arrays.asList(criteria).contains(key));

               *//*
*/
/* System.out.println(criteria.getId());
                if(value.contains(criteria.getId())){
                    System.out.println(criteria);
                }else
                    System.out.println("false");

                *//*
*/
/*
         *//*
*/
/*
                System.out.println(criteria.getRules());
                if(key.contains((CharSequence) criteria.getRules())){
                    System.out.println("true");
                }
                else {
                    System.out.println("false");
                }*//*
*/
/*

                if(criteria.getRules().listIterator().equals(key))
                {
                    System.out.println("true");
                }
                else
                    System.out.println("false");


            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

    }*//*

    }
}*/
