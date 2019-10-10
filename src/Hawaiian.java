public class Hawaiian {
    public static void isHawaiian(String s){
        Letter letter = new Letter();
        for (int i = 0; i < s.length(); i++){
            letter= new Letter(s.charAt(i));
            if ( letter.isConsonant() || i != (s.length()-1) ){
                Letter temp = new Letter(s.charAt(i+1));
                if (temp.isConsonant()) return false;
            }
        }
    }


    public static void main(String[] args){
        //Let's assume we have a String of decrypts together...
        //Divide them by the decrypt string length, into the different strings to test.
        String decrypts = "allTHEdecryptsGOhere";
        isHawaiian(decrypts);

    }
}
