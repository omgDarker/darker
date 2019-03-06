package com.vip.darker.base.dpattern.factory.common.service.impl;

import com.vip.darker.base.dpattern.factory.common.service.Profession;

public class Student implements Profession {
    @Override
    public void teach() {
        System.out.println("student reading");
    }

    @Override
    public void design() {
        System.out.println("student designing");
    }
}
