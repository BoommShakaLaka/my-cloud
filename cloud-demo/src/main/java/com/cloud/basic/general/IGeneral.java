package com.cloud.basic.general;

import java.util.Random;

public interface IGeneral<T> {
    public T getId();
}


class Generalintergerimpl implements IGeneral<Integer> {

    @Override
    public Integer getId() {
        Random random = new Random(100);
        return random.nextInt();
    }


    public static void main(String[] args) {
        Generalintergerimpl generalintergerimpl = new Generalintergerimpl();
        System.out.println(generalintergerimpl.getId());
    }
}