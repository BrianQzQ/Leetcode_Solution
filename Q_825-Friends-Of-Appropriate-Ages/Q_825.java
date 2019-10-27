package Medium;

import java.util.Arrays;

public class Q_825 {
    public static void main(String[] args) {
        int[]ages={73,106,39,6,26,15,30,100,71,35,46,112,6,60,110};
        Q_825 f=new Q_825();
        int a=f.numFriendRequests(ages);
        System.out.println(a);
    }
    public int numFriendRequests(int[] ages) {
        int res=0;
        int[]m=new int[121];
        for(int i:ages)
            m[i]++;
        for(int ageA=1;ageA<=120;ageA++){
            int freqA=m[ageA];
            if (freqA==0)continue;
            //res+=freqA*(freqA-1);
            int temp=0;
            int l= (int) (0.5*ageA+7-1);
            for (int ageB=l;ageB<=ageA;ageB++){
                int freqB=m[ageB];
                if (freqB==0)continue;
                if(ageB<= 0.5 * ageA + 7)
                    continue;
                //else if(ageB > ageA)continue;
                //else if(ageB > 100 && ageA< 100)continue;
                //else if(ageA==ageB)continue;
                temp+=freqB;
            }
            if(temp!=0)
                res+=freqA*temp-freqA;
        }
        return res;
    }

    public int numFriendRequests2(int[] ages) {
        int res=0;
        Arrays.sort(ages);
        for(int i=1;i<ages.length;i++){
            double V=0.5*ages[i]+7;
            for(int j=i-1;j>=0;j--){
                if(ages[j]<=V){
                    res++;
                    if (ages[j]==ages[i])res++;}
                else {
                    break;
                }
            }
        }
        return res;
    }
    public boolean request(int A,int B){
        double V=0.5*A+7;
        if(B<=V)
            return false;
        //if(B>A)return false;
        else return true;
    }
}
