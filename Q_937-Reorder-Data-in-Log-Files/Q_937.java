import java.util.*;

//https://leetcode.com/problems/reorder-data-in-log-files/
public class Q_937 {
    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        Q_937 q=new Q_937();
        logs=q.reorderLogFiles(logs);
        //System.out.println(logs[0].charAt(logs[0].indexOf(" ")));
        for(int i=0;i<logs.length;i++)
            System.out.println(logs[i]);
    }
    public String[] reorderLogFiles(String[] logs) {

        //List<String>l=new ArrayList<>();
        Vector<String>v=new Vector<>();
        LinkedList<String>d=new LinkedList<>();
        for(String s:logs){
            char t=s.split(" ")[1].charAt(0);
            if(t>='0'&&t<='9'){
                d.addLast(s);
            }
            else {
                //int N=s.split(" ")[0].length();
                //int num=Integer.valueOf(s.split(" ")[0].substring(3,N));
                //dig.put(num,s);
                v.add(s);

            }
        }

        Collections.sort(v,new Comparator<String>(){
            public int compare(String o1,String o2){
               int space1=o1.indexOf(" ");
               String id1=o1.substring(0,space1);
                String letter1=o1.substring(space1+1);
                int space2=o2.indexOf(" ");
                String id2=o2.substring(0,space2);
                String letter2=o2.substring(space2+1);
                if(letter1.equals(letter2)){
                    int i=0;
                    while(i<id1.length()||i<id2.length()){
                        if(i==id1.length())return -1;
                        if (i==id2.length())return 1;
                        if(id1.charAt(i)==id2.charAt(i)){
                            i++;
                            continue;
                        }
                        if (id1.charAt(i)>id2.charAt(i))return 1;
                        else return -1;
                    }
                    //if(Integer.valueOf(letter1.substring(3))<=Integer.valueOf(letter2.substring(3))){
                    //return Integer.valueOf(id1.substring(3))-Integer.valueOf(id2.substring(3));
                }
                else {
                    int i=0;
                    while (i<letter1.length()||i<letter2.length()){
                        if(i==letter1.length()){return -1;}
                        if(i==letter2.length()){return 1;}
                        if(letter1.charAt(i)==letter2.charAt(i)){
                            i++;
                            continue;
                        }
                        else if(letter1.charAt(i)>letter2.charAt(i)){
                            return 1;
                        }
                        else {
                            return -1;
                        }
                    }
                }
                    return 0;
                }
        });

        int ll=v.size();
        for(int i=0;i<ll;i++)
            logs[i]=v.get(i);
        int lr=d.size();
        for(int i=0;i<lr;i++)
            logs[ll+i]=d.get(i);
        return logs;
    }
}
