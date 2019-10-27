package Medium;

import java.util.*;

import static java.lang.Math.min;

public class Q_56 {
    public static void main(String[] args) {
        int[][]intervals={{2,3},{4,6},{5,7}};
        Q_56 m=new Q_56();
        m.merge(intervals);
    }
    public int[][] merge2(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0]!=o2[0])return o1[0]-o2[0];
                else return o1[1]-o2[1];
            }
        });
        Stack<int[]>m1=new Stack<>();
        Stack<int[]>m2=new Stack<>();
        for(int i=intervals.length-1;i>=0;i--)
            m1.push(intervals[i]);
        int M=2;
        while (!m1.empty()){
            if(m1.size()==1){
                m2.push(m1.pop());
                break;
            }
            int[]prev=m1.pop();
            int[]next=m1.pop();
            if(next[0]<=prev[1]){
                int[]temp=new int[2];
                temp[0]=Math.min(prev[0],next[0]);
                temp[1]=Math.max(next[1],prev[1]);
                m1.push(temp);
            }
            else {
                m2.push(prev);
                m1.push(next);
            }
        }

        int N=m2.size();
        int[][] res=new int[N][2];
        for(int i=0;i<N;i++){
            res[i]=m2.pop();
        }

        return res;
        //return intervals;
    }

    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0]!=o2[0])return o1[0]-o2[0];
                else return o1[1]-o2[1];
            }
        });
        Stack<int[]>m1=new Stack<>();
        List<int[]> l=new ArrayList<>();
        for(int i=intervals.length-1;i>=0;i--)
            m1.push(intervals[i]);

        int M=2;
        while (!m1.empty()){
            if(m1.size()==1){
                l.add(m1.pop());
                break;
            }
            int[]prev=m1.pop();
            int[]next=m1.pop();
            if(next[0]<=prev[1]){
                int[]temp=new int[2];
                temp[0]=Math.min(prev[0],next[0]);
                temp[1]=Math.max(next[1],prev[1]);
                m1.push(temp);
            }
            else {
                l.add(prev);
                m1.push(next);
            }
        }

        int N=l.size();
        int[][] res=new int[N][2];
        for(int i=0;i<N;i++){
            res[i]=l.get(i);
        }
        return res;
        //return intervals;
    }


    //白给
    public int[][] merge1(int[][] intervals) {
        Stack<int[]>m1=new Stack<>();
        Stack<int[]>m2=new Stack<>();
        for(int i=0;i<intervals.length;i++)
            m1.push(intervals[i]);
        int M=2;
        while (!m1.empty()){
            if(m1.size()==1){
                m2.push(m1.pop());
                break;
            }
            int[]next=m1.pop();
            int[]prev=m1.pop();
            if(next[0]<=prev[1]){
                int[]temp=new int[2];
                temp[0]=Math.min(prev[0],next[0]);
                temp[1]=Math.max(next[1],prev[1]);
                m1.push(temp);
            }
            else {
                m2.push(next);
                m1.push(prev);
            }
        }
        int N=m2.size();
        int[][] res=new int[N][2];
        for(int i=0;i<N;i++){
            res[i]=m2.pop();
        }
        return res;
    }
}
