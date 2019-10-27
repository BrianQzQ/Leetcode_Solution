package Easy;

public class Q_231 {
    public boolean isPowerOfTwo(int n) {
        if(n==0)return false;
        if(n==1||n==2)return true;
        while (n%2==0&&n>=2){
                n=n/2;
        }
        if(n==1)return true;
        return false;
    }
}
