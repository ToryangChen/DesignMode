package com.decorator;

/**
 * Created by toryang on 7/15/16.
 */
public class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    private void method2(){
        System.out.println("method2 修饰");
    }

    @Override
    public void operate() {
        super.operate();
        this.method2();
    }
}
