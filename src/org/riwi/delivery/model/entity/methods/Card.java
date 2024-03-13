package org.riwi.delivery.model.entity.methods;

public class Card implements Method{
    @Override
    public void pay() {
        System.out.println("Hello, you need to pay 1% more ");
    }
}
