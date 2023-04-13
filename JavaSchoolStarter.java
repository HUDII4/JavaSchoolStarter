package com.digdes.school;


import java.util.*;
import java.util.stream.Stream;

public class JavaSchoolStarter {
   public JavaSchoolStarter(){

   }

  public List<Map<String, Object>> execute(String request)throws Exeption{
       Map<String, Object> row = new HashMap<>();
        List<Map<String, Object>> data = new ArrayList<>();
        Set<Map.Entry<String, Object>> entryRow = row.entrySet();
        if (req.startsWith("INSERT VALUES")){
            req = req.substring(14, req.length());
            for (String pair : req.split(", ")){
                String[] kv = pair.split("=");
                Object obj = kv[1];
                row.put(kv[0], obj);
            }
            data.add(row);
       } else if (request.startsWith("UPDATE VALUES")) {
           int index = request.indexOf("Where");
           request = request.substring(14, index);
           if (data.contains(row.containsKey("'active'")) && data.contains(row.containsValue(("true")))){
           for (String pair1 : request.split(", ")) {
               String[] keyValue = pair1.split("=");
                  row.replace(keyValue[0], String.valueOf(keyValue[1]));
               }
               }
       }else if (request.startsWith("DELETE")) {
           int index = request.indexOf("Where");
           request = request.substring(7, index);
           if (data.contains(row.containsKey("'active'")) && data.contains(row.containsValue(("true")))){
           for (String pair1 : request.split(", ")) {
               String[] keyValue = pair1.split("=");
                  row.remove(keyValue[0], String.valueOf(keyValue[1]));
               }
               }
       }
     return data;
  }
}

class Gag {
   public static void main(String[] args) {
  try {
         JavaSchoolStarter start = new JavaSchoolStarter();

         List<Map<String, Object>> map1 = start.execute("INSERT VALUES 'id' = 7, 'lastname' = 'Pasentsyan', 'age' = 18, 'cost' = 2.18, 'active' = false");
       List<Map<String, Object>> map2 = start.execute("INSERT VALUES 'id' = 7, 'lastname' = 'Ttov', 'age' = 18, 'cost' = 21.18, 'active' = true");
       List<Map<String, Object>> map3 = start.execute("INSERT VALUES 'id' = 72, 'lastname' = 'Карпов', 'age' = 27, 'cost' = 5.5, 'active' = true");
       List<Map<String, Object>> map4 = start.execute("DELETE 'id'=33, 'age'=34 Where 'active'=true ");
       List<Map<String, Object>> map5 = start.execute("UPDATE VALUES 'id'=33, 'age'=34 Where 'active'=true ");
       System.out.println(map1);
       System.out.println(map2);
       System.out.println(map3);
       System.out.println(map4);
       System.out.println(map4);
  }catch(Exeption w) throw new RuntimeExeption(e);
   }
}
