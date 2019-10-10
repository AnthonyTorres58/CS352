public class Letter extends Object{
    private char character;
    private boolean consonant;

    public boolean isConsonant() {return consonant;}

    public Letter(){ }
    public Letter(Character c){
        this.character = c;
        //if this character is a,A,e,E,i,I,o,O,u,U
        //  this.consonant = false;
        //else  this.consonant = true;
    }


}
