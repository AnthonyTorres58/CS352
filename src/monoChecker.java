import java.text.DecimalFormat;
import java.util.Arrays;

public class monoChecker
{

    public static DecimalFormat df = new DecimalFormat("0.000");
    public static double[] charFreq = new double[26];
    public static double[] IceCharFreq = new double[32];
    private static String test = "vptnvffuntshtarptymjwzirappljmhhqvsubwlzzygvtyitarptyiougxiuydtgzhhvvmum" +
            "shwkzgstfmekvmpkswdgbilvjljmglmjfqwioiivknulvvfemioiemojtywdsajtwmtcgluy" +
            "sdsumfbieugmvalvxkjduetukatymvkqzhvqvgvptytjwwldyeevquhlulwpkt";
    private static String sE = "uvamqyfbmmturutrzjnzghrwimfbieksnzcyfcibglncbzsjaqibufgzinwizblfgynquanbyjmtfmqmgsnuuuopnpksdcvyxnmbgscnwhvrflaqwyerjcntkijvqzbcmbuijpmtfffqzuuypuqnmqzjblizinlpgsmqwxlcbmxfrmvuxwiaspxnpxpjxqtuxnpkgdncxfkobcfpizuvwxwxtlliscuywbfanpkpkmbgduyacfeyouucijownhwsbcnmxixqugohmsofbbibfoutrfw";
    private static String sI = "ýivéöfxþspiýötxðgæhekilærlðuipiiaþigpirð" +
            "lbgmlmrúvpæapaxýaoöttmrblþvötjfjabýtaivxöékójmggsggpxtóvöáoýéé" +
            "rvúóáóðímýuþoúiddrmérbéödrábáyyþrþbehójyuóáírójöiyípæapaxýajvteý" +
            "æásóihipggátóéyiiúííhgyaxðúlðhéææýíðdúiyæþðæggmyóýuþvéþkúbíðvbídánsí" +
            "yéarabíbáójðíiíövétdrhárgbtiæivípxúyæýaxsuipignoyæsðvvykrfjísúíkógðtmáíphp" +
            "íaúyöfðhfdfmúiæéeýæíyaréðaóinðraðaæhúffgtmmbagðþeaúbsyiatyuráxréeoxustvétpíþör" +
            "ðséaxýíovtthbháoréyxithoæfjtaíxóötaiiiííbépaxýrbæáiaxðkbgtaía";
//Split into lines cause I prefer code to be pretty.


    public static double findAvg(double[] array) {
        return Arrays.stream(array).average().orElse(Double.NaN);
    }
    public static int findSum(int[] array) {
        return Arrays.stream(array).sum();
    }

    public static void charFreqs(String s, int keyLength) { //ex KL:3
        int tempI = 0;
        char tempChar;
        for (int a = 0; a < keyLength; a++) {   // From a=0 to kl-1// 2
            int[] charCount = new int[26];
            for (int i = a; i < s.length(); i=i+(keyLength)) { //at A:1 - From i=0 to s.length-1; i=i+3
                tempChar = s.charAt(i);
                tempI = ((int) s.charAt(i) - 97);
                charCount[tempI % 97]++;
            }
            System.out.println("For Keylength " + keyLength + " : Sequence # " + (a) + "/n" ); //+":The I.C is : " + findAvg(IceCharCount));
            for (int j = 0; j < charCount.length; j++) {
                charFreq[j] = ((double)charCount[j] / findSum(charCount));
            }
            System.out.println(Arrays.toString(charCount));
            Arrays.stream(charFreq).forEach(e -> System.out.print(df.format(e) + " /n" ));
           // System.out.println("Average IC: " + findAvg(charFreq));
        }
    }
    public static void IceCharFreqs(String s, int keyLength) {
        double tempC = 0;
        for (int a = 0; a < keyLength; a++){
            int[] IceCharCount = new int[32];
            for (int i = a; i < s.length(); i=i+(keyLength)) { //gonna have a lot of if statements
                if (s.charAt(i) == 'ö') IceCharCount[20]++;
                else if (s.charAt(i) == 'þ') IceCharCount[31]++;
                else if (s.charAt(i) == 'ý') IceCharCount[30]++;
                else if (s.charAt(i) == 'y') IceCharCount[29]++;
                else if (s.charAt(i) == 'x') IceCharCount[28]++;
                else if (s.charAt(i) == 'v') IceCharCount[27]++;
                else if (s.charAt(i) == 'ú') IceCharCount[26]++;
                else if (s.charAt(i) == 'u') IceCharCount[25]++;
                else if (s.charAt(i) == 't') IceCharCount[24]++;
                else if (s.charAt(i) == 's') IceCharCount[23]++;
                else if (s.charAt(i) == 'r') IceCharCount[22]++;
                else if (s.charAt(i) == 'p') IceCharCount[21]++;
                else if (s.charAt(i) == 'ó') IceCharCount[19]++;
                else if (s.charAt(i) == 'o') IceCharCount[18]++;
                else if (s.charAt(i) == 'n') IceCharCount[17]++;
                else if (s.charAt(i) == 'm') IceCharCount[16]++;
                else if (s.charAt(i) == 'l') IceCharCount[15]++;
                else if (s.charAt(i) == 'k') IceCharCount[14]++;
                else if (s.charAt(i) == 'j') IceCharCount[13]++;
                else if (s.charAt(i) == 'í') IceCharCount[12]++;
                else if (s.charAt(i) == 'i') IceCharCount[11]++;
                else if (s.charAt(i) == 'h') IceCharCount[10]++;
                else if (s.charAt(i) == 'g') IceCharCount[9]++;
                else if (s.charAt(i) == 'f') IceCharCount[8]++;
                else if (s.charAt(i) == 'é') IceCharCount[7]++;
                else if (s.charAt(i) == 'e') IceCharCount[6]++;
                else if (s.charAt(i) == 'ð') IceCharCount[5]++;
                else if (s.charAt(i) == 'd') IceCharCount[4]++;
                else if (s.charAt(i) == 'b') IceCharCount[3]++;
                else if (s.charAt(i) == 'æ') IceCharCount[2]++;
                else if (s.charAt(i) == 'á') IceCharCount[1]++;
                else if (s.charAt(i) == 'a') IceCharCount[0]++;
            }
           // tempC += findAvg(IceCharCount);
            System.out.println("For Keylength " + keyLength + " : Sequence # " + (a) ); //+":The I.C is : " + findAvg(IceCharCount));

            for (int j = 0; j < IceCharCount.length; j++) {
                IceCharFreq[j] = ((double)IceCharCount[j] / findSum(IceCharCount));
            }
            Arrays.stream(IceCharFreq).forEach(e -> System.out.print(df.format(e) + " " ));
            System.out.println("Average IC: " + findSum(IceCharCount));
        }

        //System.out.println("Average IC: " + (tempC/keyLength));
    }

    public static void main (String args[])
    {
        IceCharFreqs(sI, 11);
    //    IceCharFreqs(sI, 10);
       /* for (int j = 0; j < IceCharCount.length; j++) {
            IceCharFreq[j] = ((double)IceCharCount[j] / sI.length());
        }
        System.out.println(Arrays.toString(IceCharCount));
        System.out.println(sI.length());
        DecimalFormat df = new DecimalFormat("0.0000000");
        Arrays.stream(IceCharFreq).forEach(e -> System.out.print(df.format(e) + " " ));
*/
     //   System.out.println(Arrays.toString(charCount));
     //   System.out.println( Arrays.toString(charFreq));
      //  DecimalFormat df = new DecimalFormat("0.000");
      //  Arrays.stream(charFreq).forEach(e -> System.out.print(df.format(e) + " " ));

    }

}
