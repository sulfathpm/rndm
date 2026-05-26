class exc extends RuntimeException{
    public exc(String message){
        super(message);
    }
}
public class p5_cs_runtime {
    static int withdraw(int amt,int blnc){
        if(amt>blnc) throw new exc("insufficient blnc");
        else{
            blnc-=amt;        return blnc;

        }
    }
    public static void main(String[] args) {
        int blnc=2000,amt=1500;
        try{
            blnc=withdraw(amt, blnc);
            System.out.println("withdrw successful. blnc ="+blnc);
        }catch(exc e){
            System.out.println(e.getMessage());
        }
    }
}

    

