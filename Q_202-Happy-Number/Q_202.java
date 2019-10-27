import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Happy_Number_202 {
    public static void main(String[] args) {
        int n = 2;
        Happy_Number_202 h = new Happy_Number_202();
        boolean a = h.isHappy4(n);
        System.out.println(a);
    }

    public boolean isHappy(int n) {

        Map<Integer, Integer> record = new HashMap<>();
        int resultf = n;
        int resultp = 0;
        while (resultf != 1) {
            if (resultf == 0) return false;
            for (int c : String.valueOf(resultf).toCharArray()) {
                c = c - 48;
                resultp += c * c;
            }

            if (record.containsKey(resultp) && record.get(resultp) >= 1) {
                return false;
            } else
                record.put(resultp, 1);
            resultf = resultp;
            resultp = 0;
        }
        return true;
    }

    public boolean isHappy2(int n) {
        int[] record = new int[730];
        int resultf = n;
        int resultp = 0;
        while (resultf != 1) {
            if (resultf == 0) return false;
            for (int c : String.valueOf(resultf).toCharArray()) {
                c = c - 48;
                resultp += c * c;
            }

            if (record[resultp - 1] >= 1) {
                return false;
            } else
                record[resultp - 1] = 1;
            resultf = resultp;
            resultp = 0;
        }
        return true;
    }

    public boolean isHappy3(int n) {

        List<Integer> record = new ArrayList<>();
        int resultf = n;
        int resultp = 0;
        while (resultf != 1) {
            if (resultf == 0) return false;
            for (int c : String.valueOf(resultf).toCharArray()) {
                c = c - 48;
                resultp += c * c;
            }
            if (resultp == 1) return true;
            if (record.contains(resultp)) {
                return false;
            } else {
                record.add(resultp);
                resultf = resultp;
                resultp = 0;
            }
        }
        return true;
    }

    public boolean isHappy4(int n){
        //int resultp=0;
        int resultf=n;
        while(resultf!=1&&resultf!=4){
            int resultp=0;
            for (int c : String.valueOf(resultf).toCharArray()) {
                c = c - 48;
                resultp += c * c;
            }
            if (resultp == 1) return true;
            else resultf=resultp;
        }
        return resultf==1;
    }

}
