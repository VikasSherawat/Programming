package googlecodejam.sixteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vikas on 2/8/16.
 */
public class CloseMatch {
    Scanner in;
    PrintWriter pw;

    String PATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
    //String FILENAME = "B-large-practice";
    String FILENAME = "B-small-practice";
    String outString ="Case #";
    String semicolon = ": ";

    String INPUT = PATH + FILENAME + ".in";
    String OUTPUT = PATH + FILENAME + "-answer.in";

    public static void main(String[] args){
        new CloseMatch().run();
    }

    private void run() {
        configInput();
        configOutput();

        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            takeInput(i+1);
        }

        in.close();
        pw.flush();
        pw.close();

    }

    private void takeInput(int TURN) {

        int ans = 0;

        String C = in.next(),
               J = in.next();

        char Q = '?';

        int[] cArr = new int[C.length()];
        int[] jArr = new int[C.length()];

        Arrays.fill(cArr,-1);
        Arrays.fill(jArr,-1);

        for (int i = 0; i < C.length(); i++) {

            char c = C.charAt(i),
                 j = J.charAt(i);

            if(c == Q && j == Q){
                bothUnknown(C,J,cArr,jArr,i);
            }else if(c == Q && j!=Q){
                CIsUnknown(C,J,cArr,jArr,i,j);
            }else if(c != Q && j==Q){
            	CIsUnknown(J,C,jArr,cArr,i,c);
            }else{
                cArr[i] = Character.getNumericValue(c);
                jArr[i] = Character.getNumericValue(j);
            }


        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < cArr.length; i++) {
            sb.append(cArr[i]);
            sb1.append(jArr[i]);
        }

        //pw.println(outString+TURN+semicolon+sb.toString()+" "+sb1.toString());
        System.out.println(outString+TURN+semicolon+C+" "+J+"||"+sb.toString()+" "+sb1.toString());
    }

    private void CIsUnknown(String C, String J, int[] cArr, int[] jArr, int i,char value1) {
        int value = Character.getNumericValue(value1);
        if(i==0){
            if(C.length()==1){
                cArr[i] = jArr[i] = value;
                return;
            }else{
                char c = C.charAt(i+1);
                char j = J.charAt(i+1);
                
                if(c=='?' || j=='?'){
                	cArr[i] = jArr[i] = value;
                    return;
                }

                if(c > j){
                    if(c-j<=5){
                    	if(c-j<5)
                    		cArr[i] = jArr[i] = value;
                    	else{
                    		if(value!=0)
                                cArr[i] = value-1;
                            else
                            	cArr[i] = value;
	                    	jArr[i]=value;
                    	}
                        return;
                    }else{
                    	if(value!=0)
                        cArr[i] = value-1;
                    	else
                    		cArr[i] = value;
                        jArr[i] = value;
                        return;
                    }
                }else if(c < j){
                    if(j-c<=5){
                        cArr[i] = jArr[i] = value;
                        return;
                    }else{
                    	if(value!=9)
                    		cArr[i] = value+1;
                    	else
                    		cArr[i] = value;
                        jArr[i] = value;
                        return;
                    }
                }else{
                    cArr[i] = jArr[i] = value;
                    return;
                }
            }
        }else{
            int big =0;
            for (int j = 0; cArr[j]!=-1 && jArr[j]!=-1; j++) {

                int m = cArr[j];
                int n = jArr[j];

                if(m>n){
                    big = 1;
                    break;
                }else if(m <n){
                    big = 2;
                    break;
                }else{
                    big = 0;
                }
            }

            switch(big){
                case 1:
                    cArr[i] = 0;
                    jArr[i] = value;
                    return;
                case 2:
                    cArr[i] = 9;
                    jArr[i] = value;
                    return;
                default:
                    if(i==C.length()-1){
                        cArr[i] = jArr[i] = value;
                        return;
                    }else{
                        char c = C.charAt(i+1);
                        char j = J.charAt(i+1);
                        if(c=='?'||j=='?'){
                        	cArr[i] = jArr[i] = value;
                            return;
                        }
                        if(c > j){
                            if(c-j<=5){
                            	if(c-j==5){
                            		if(value!=0)
                                		cArr[i] = value-1;
                                	else
                                		cArr[i] = value;
                                    jArr[i] = value;
                            	}else
                            		cArr[i] = jArr[i] = value;
                                return;
                            }else{
                            	if(value!=0)
                            		cArr[i] = value-1;
                            	else
                            		cArr[i] = value;
                                jArr[i] = value;
                                return;
                            }
                        }else if(c < j){
                            if(j-c<=5){
                                cArr[i] = jArr[i] = value;
                                return;
                            }else{
                            	if(value!=9)
                            		cArr[i] = value+1;
                            	else
                            		cArr[i] = value;
                                jArr[i] = value;
                                return;
                            }
                        }else{
                            cArr[i] = jArr[i] = value;
                            return;
                        }
                    }
            }

        }
    }

    private void bothUnknown(String C, String J, int[] cArr, int[] jArr, int i) {
    	char Q = '?';
        if(i==0 ){
            if(C.length()==1){
                cArr[i] = jArr[i] = 0;
                return;
            }else{
                char c = C.charAt(i+1);
                char j = J.charAt(i+1);
                if(c==Q || j ==Q){
                	cArr[i] = jArr[i] = 0;
                    return;
                }

                if(c > j){
                    if(c-j<=5){
                        cArr[i] = jArr[i] = 0;
                        return;
                    }else{
                        cArr[i] = 0;
                        jArr[i] = 1;
                        return;
                    }
                }else if(c < j){
                    if(j-c<=5){
                        cArr[i] = jArr[i] = 0;
                        return;
                    }else{
                        cArr[i] = 1;
                        jArr[i] = 0;
                        return;
                    }
                }else{
                    cArr[i] = jArr[i] = 0;
                    return;
                }
            }
        }else{
            int big =0;
            for (int j = 0; cArr[j]!=-1 && jArr[j]!=-1; j++) {

                int m = cArr[j];
                int n = jArr[j];

                if(m>n){
                    big = 1;
                    break;
                }else if(m <n){
                    big = 2;
                    break;
                }else{
                    big = 0;
                }
            }

            switch(big){
                case 1:
                    cArr[i] = 0;
                    jArr[i] = 9;
                    return;
                case 2:
                    cArr[i] = 9;
                    jArr[i] = 0;
                    return;
                default:
                    if(i==C.length()-1){
                        cArr[i] = jArr[i] = 0;
                        return;
                    }else{
                        char c = C.charAt(i+1);
                        char j = J.charAt(i+1);
                        if(c=='?' || j=='?'){
                        	cArr[i] = jArr[i] = 0;
                            return;
                        }
                        if(c > j){
                            if(c-j<=5){
                                cArr[i] = jArr[i] = 0;
                                return;
                            }else{
                                cArr[i] = 0;
                                jArr[i] = 1;
                                return;
                            }
                        }else if(c < j){
                            if(j-c<=5){
                                cArr[i] = jArr[i] = 0;
                                return;
                            }else{
                                cArr[i] = 1;
                                jArr[i] = 0;
                                return;
                            }
                        }else{
                            cArr[i] = jArr[i] = 0;
                            return;
                        }
                    }
            }

        }
    }


    private void configOutput() {
        File file = new File(OUTPUT);
        if(file.exists()){
            file.delete();
        }
        try {
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void configInput() {
        File file = new File(INPUT);
        try {
            in = new Scanner(System.in);
            //in = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}