import java.math.*;

public class TestPoly{
   public static void main(String[] args){
      Polynomial p = new Polynomial();
      for(int k=0; k<=10; k++){
         p = p.times(new Polynomial(new BigInteger("" + k).negate()));
      }
      System.out.println(p);
	  
	  Polynomial pz = new Polynomial();
	  
      for(int k=0; k<=10; k++){
         pz = pz.plus(new Polynomial(new BigInteger("" + 1).negate(), k));
      }
      System.out.println(pz);
	  
   }
}