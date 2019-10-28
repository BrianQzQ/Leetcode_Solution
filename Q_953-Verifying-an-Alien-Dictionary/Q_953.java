package Easy;

import java.util.HashMap;
import java.util.Map;

public class Q_953 {
    public boolean isAlienSorted2(String[] words, String order) {
        Map<Character,Integer> alphabet=new HashMap<>();
        for(int i=0;i<order.length();i++){
            alphabet.put(order.charAt(i),i);
        }

        for(int i=1;i<words.length;i++){
            String former=words[i-1];
            String present=words[i];
            int j=0;
            while (j<former.length()||j<present.length()){
                if(j==former.length())break;
                if(j==present.length())return false;
                int l=alphabet.get(former.charAt(j));
                int r=alphabet.get(present.charAt(j));
                if(l==r)
                    j++;
                else if(l<r)
                    break;
                else
                    return false;
            }
        }
        return true;
    }
    public boolean isAlienSorted(String[] words, String order) {
       /** Map<Character,Integer> alphabet=new HashMap<>();
        for(int i=0;i<order.length();i++){
            alphabet.put(order.charAt(i),i);
        }
*/
        for(int i=1;i<words.length;i++){
            String former=words[i-1];
            String present=words[i];
            int j=0;
            while (j<former.length()||j<present.length()){
                if(j==former.length())break;
                if(j==present.length())return false;
                if(order.indexOf(former.charAt(j))==order.indexOf(present.charAt(j)))
                    j++;
                else if(order.indexOf(former.charAt(j))<order.indexOf(present.charAt(j)))
                    break;
                else
                    return false;
            }
        }
        return true;
    }
}
