package GmailPages;

import java.util.Map;
import java.util.Objects;

/**
 * Created by Juan_Rodriguez on 8/12/2015.
 */
public class MethodsForRestImprementations {

    public void forDisplayCookies(Map<String,String> cookies){

      for(int i=0;i<cookies.size();i++){
          System.out.println(cookies.get(i));
      }


    }
}
