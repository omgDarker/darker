package com.vip.darker.base.dpattern.factory.simple.service.impl;


import com.vip.darker.base.dpattern.factory.simple.service.Behavior;

public class Cook implements Behavior {
    @Override
    public void eat() {
        System.out.println("----------Cook----------Eating");
    }

    @Override
    public void sleep() {
        System.out.println("----------Cook----------Sleeping");
    }
}