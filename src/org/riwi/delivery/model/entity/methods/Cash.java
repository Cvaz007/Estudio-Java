package org.riwi.delivery.model.entity.methods;

public class Cash implements Method {
    @Override
    public void pay() {
        System.out.println("Hello!, you need to pay a normal price");
    }
}
