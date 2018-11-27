import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Date;
import java.math.BigInteger;

public class GeneratorID
{
    private String id;

  private GeneratorID()
{
    this.id="";
    SimpleDateFormat formatForDateNow=new SimpleDateFormat("F D W dd MM yyyy HH mm ss SS");
    String partOneId=(String) formatForDateNow.format(new Date());
    partOneId=partOneId.replaceAll("\\s+","");
    //andNot(x) — операция побитовой дизъюнкции с дополнением this & (~x);
    BigInteger bigInteger=new BigInteger(128,10,new Random()).andNot(new BigInteger(128,10,new Random()));
    String partTwoId=new String(bigInteger.toString());
    this.id=this.id.concat(partOneId).concat(partTwoId);
}
     public static String getId()
     {
      GeneratorID Id=new GeneratorID();
      return Id.id;
     }
}
