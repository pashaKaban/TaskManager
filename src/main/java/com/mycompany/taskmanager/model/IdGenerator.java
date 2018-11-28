package com.mycompany.taskmanager.model;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IdGenerator {
    public static String identificator;
    private static volatile IdGenerator id=null;
    private IdGenerator()
    {
        this.identificator="";
        SimpleDateFormat formatForDateNow=new SimpleDateFormat("F D W dd MM yyyy HH mm ss SS");
        String partOneId=(String) formatForDateNow.format(new Date());
        partOneId=partOneId.replaceAll("\\s+","");
        //andNot(x) — операция побитовой дизъюнкции с дополнением this & (~x);
        BigInteger bigInteger=new BigInteger(128,10,new Random()).andNot(new BigInteger(128,10,new Random()));
        String partTwoId=new String(bigInteger.toString());
        this.identificator=this.identificator.concat(partOneId).concat(partTwoId);
    }
    public static String generateId(){
            synchronized (IdGenerator.class) {
                id = new IdGenerator();
        }
        return id.identificator;
    }
}


