package com.basic;

import java.util.Calendar;
import java.util.Date;

public class ImmutableEx {
    public static void main(String[] args) throws InterruptedException {
        Date dob=Calendar.getInstance().getTime();
        Singer s = new Singer(dob);
        Thread.sleep(1000);
        dob.setTime(Calendar.getInstance().getTime().getTime());
        System.out.println(s.getDob());
        System.out.println(dob);
    }
}

final class Singer{
    private final Date dob;

    public Singer(Date dob) {
        this.dob = (Date) dob.clone();
    }
    public Date getDob(){
        return (Date)this.dob.clone();
    }
}
