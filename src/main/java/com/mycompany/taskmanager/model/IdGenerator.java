package com.mycompany.taskmanager.model;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IdGenerator {
    private static String identificator="";
    private static final IdGenerator id=new IdGenerator();
    private IdGenerator() {}
    public static String generateId(){
            synchronized (IdGenerator.class) {
                //andNot(x) — операция побитовой дизъюнкции с дополнением this & (~x);
                id.identificator=id.identificator.concat((String) new SimpleDateFormat("FDWddMMyyyyHHmmssSS").format(new Date())).concat((new BigInteger(128,10,new Random()).andNot(new BigInteger(128,10,new Random()))).toString());
        }
        /// want to push and to commit number two
        return id.identificator;
    }
}


