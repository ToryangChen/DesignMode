package com.builder.example;

/**
 * Created by toryang on 7/12/16.
 */
public class BMWModel extends CarModel {

    @Override
    protected void start() {
        System.out.println("BMW start");
    }

    @Override
    protected void alarm() {
        System.out.println("BMW alarm");
    }

    @Override
    protected void engineBoom() {
        System.out.println("BMW engine boom ");
    }

    @Override
    protected void stop() {
        System.out.println("BMW stop");
    }
}
