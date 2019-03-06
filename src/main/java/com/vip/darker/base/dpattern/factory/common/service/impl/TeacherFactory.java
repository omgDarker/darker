package com.vip.darker.base.dpattern.factory.common.service.impl;


import com.vip.darker.base.dpattern.factory.common.PersonFactory;
import com.vip.darker.base.dpattern.factory.common.service.Profession;

public class TeacherFactory implements PersonFactory {
    @Override
    public Profession getProfession() {
        return new Teacher();
    }
}