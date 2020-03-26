public class LemonadeChange {

    public static void main(String[] args) {
        int[] a = {5,5,10,10,5};

        //-8,3,-5,-3,-5,-2
        // 8,5,5,3,2
        System.out.println(new LemonadeChange().lemonadeChange(a));
    }
    public boolean lemonadeChange(int[] bills) {
        int[] a = new int[2];
        for(int n: bills){
            int cash = n-5;
            while(a[1]>0 && cash>=10){
                cash -= 10;
                a[1]--;
            }

            while(a[0]>0 && cash>=5){
                cash -= 5;
                a[0]--;
            }

            if(n==5){
                a[0]++;
            }else if(n==10){
                a[1]++;
            }


            if(cash != 0){
                return false;
            }

        }


        return true;
    }
}
