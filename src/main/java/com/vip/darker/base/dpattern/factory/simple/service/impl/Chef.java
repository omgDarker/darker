package com.vip.darker.base.dpattern.factory.simple.service.impl;


import com.vip.darker.base.dpattern.factory.simple.service.Behavior;

public class Chef implements Behavior {
    @Override
    public void eat() {
        System.out.println("----------Chef----------Eating");
    }

    @Override
    public void sleep() {
        System.out.println("----------Chef----------Sleeping");
    }
}