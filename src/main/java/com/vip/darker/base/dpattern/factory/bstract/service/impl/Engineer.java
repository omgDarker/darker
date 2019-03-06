package com.vip.darker.base.dpattern.factory.bstract.service.impl;


import com.vip.darker.base.dpattern.factory.bstract.service.Character;

public class Engineer implements Character {
    @Override
    public void testiness() {
        System.out.println("old is not testiness");
    }

    @Override
    public void blandness() {
        System.out.println("old can be blandness");
    }
}