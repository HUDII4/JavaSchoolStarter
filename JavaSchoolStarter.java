package com.diget.school;

import java.util.*;

public class JavaSchoolStarter {

    public JavaSchoolStarter() {
    }

    public List<Map<String, Object>> execute(String req) throws Exception {
        List<Map<String, Object>> userLine = new ArrayList<>();
        Map<String, Object> userRow = new HashMap<>();
        int where = req.indexOf("Where");
        int from = req.indexOf("From");
        if (req.startsWith("INSERT VALUES")) {
            req = req.substring(14, req.length());
            try {
                for (String pair : req.split(", ")) {
                    String[] keyValue = pair.split("=");
                    Object obj = keyValue[1];
                    userRow.put(keyValue[0], obj);
                }
                userLine.add(userRow);
            } catch (NullPointerException e) {
                throw new RuntimeException();
            }
        } else if (req.startsWith("UPDATE VALUES")) {
            String res = req.substring(where - 1, req.length());
            req = req.substring(14, where);
            try{
                    for (Map.Entry<String, Object> entry : userRow.entrySet()){
                        if (entry.getKey().equals("'cost'") && entry.getValue().equals(12.5)){
                            for (String pair : req.split(", ")) {
                                String[] keyValue = pair.split("=");
                                Object obj = keyValue[1];
                                userRow = (Map<String, Object>) entry;
                                userRow.replace(keyValue[0], obj);
                        }
                    } else {
                            System.err.println(":)");
                        }
                }
                userLine.add(userRow);
            } catch (NullPointerException e) {
                throw new RuntimeException();
            }
        } else if (req.startsWith("DELETE")){
                req = req.substring(where, req.length());
                try{
                 for (Map.Entry<String, Object> entry : userRow.entrySet()){
                     for (String str : req.split(" ")){
                         String[] keyValue = str.split("=");
                         Object obj = keyValue[1];
                         if (entry.getKey().equals(keyValue[0]) && entry.getValue().equals(obj)) {
                             userRow = (Map<String, Object>) entry;
                             userRow.remove(keyValue[0], obj);
                         }
                     }
                 }
            } catch (NullPointerException e) {
                throw new RuntimeException();
            }
        } else if (req.startsWith("SELECT")){
            req = req.substring(where, req.length());
            try{
                for (Map.Entry<String, Object> entry : userRow.entrySet()){
                    for (String str : req.split(" ")){
                        String[] keyValue = str.split("=");
                        Object obj = keyValue[1];
                        if (entry.getKey().equals(keyValue[0]) && entry.getValue().equals(obj)) {
                            userRow = (Map<String, Object>) entry;
                            userRow.getOrDefault(keyValue[0], obj);
                        }
                    }
                }
            } catch (NullPointerException e) {
                throw new RuntimeException();
            }
        }
        return userLine;
    }
}

class Test{
    public static void main(String[] args) {
        try {
            Database dt = new Database();
            List<Map<String, Object>> user0 = dt.execute("INSERT VALUES 'ID'= 3, 'lastname' ='hello', 'age'=10, 'cost' = 56.5, 'active'=true ");
            List<Map<String, Object>> user1 = dt.execute("INSERT VALUES 'ID'= 12, 'lastname' ='Ttitov', 'age'=12, 'cost' = 12.5, 'active'=true ");
            List<Map<String, Object>> user2 = dt.execute("UPDATE VALUES 'ID'= 13, 'lastname' ='Ttitov', Where 'cost' = 12.5 ");
            List<Map<String, Object>> user3 = dt.execute("UPDATE VALUES 'ID'= 13, 'lastname' ='Ttitov', Where 'cost' like 12.5 ");
            List<Map<String, Object>> user4 = dt.execute("DELETE Where 'ID' = 3 ");
            List<Map<String, Object>> user5 = dt.execute("SELECT Where 'ID' = 12 ");

            System.out.println(user0);
            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);
            System.out.println(user5);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
