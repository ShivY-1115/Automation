package Interview.API_Testing;

import java.util.HashMap;

public class Nested_Json {

    public static void main(String[] args)
    {
       /* {“space”:
            {
              “name”:”myspace”, ;
                “id”:”sidharth″;
            }
        }";  */



        HashMap<String,Object> mainObj = new HashMap<>();
        HashMap<String,String> subobj = new HashMap<>();
        subobj.put("name","vamsi");
        subobj.put("id","12345");
        mainObj.put("person",subobj);
    }
}
