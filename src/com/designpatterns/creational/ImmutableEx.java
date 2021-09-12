package com.designpatterns.creational;

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
/*
 1. Use a constructor to set all properties of the object.
 2. Mark all of the instance variables private and final .
 3. Don’t define any setter methods.
 4. Don’t allow referenced mutable objects to be modified or accessed directly.
 5. Prevent methods from being overridden
 */
final class Singer{
    private final Date dob;

    public Singer(Date dob) {
        this.dob = (Date) dob.clone();
    }
    public Date getDob(){
        return (Date)this.dob.clone();
    }
}
