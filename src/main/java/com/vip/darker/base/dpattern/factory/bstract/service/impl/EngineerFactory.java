package com.vip.darker.base.dpattern.factory.bstract.service.impl;


import com.vip.darker.base.dpattern.factory.bstract.PersonAbstractFactory;
import com.vip.darker.base.dpattern.factory.bstract.service.Character;
import com.vip.darker.base.dpattern.factory.common.service.Profession;
import com.vip.darker.base.dpattern.factory.common.service.impl.Student;

public class EngineerFactory implements PersonAbstractFactory {
    @Override
    public Character getCharacter() {
        return new Engineer();
    }

    @Override
    public Profession getProfession() {
        return new Student();
    }
}