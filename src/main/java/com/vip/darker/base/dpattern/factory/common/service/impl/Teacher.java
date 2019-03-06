package com.vip.darker.base.dpattern.factory.common.service.impl;


import com.vip.darker.base.dpattern.factory.common.service.Profession;

public class Teacher implements Profession {
    @Override
    public void teach() {
        System.out.println("teacher teaching");
    }

    @Override
    public void design() {
        System.out.println("teacher design");
    }
}
