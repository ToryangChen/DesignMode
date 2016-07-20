package com.decorator;

/**
 * Created by toryang on 7/15/16.
 */
public class Client  {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component = new ConcreteDecorator1(component);
        component = new ConcreteDecorator2(component);
        component.operate();
    }
}
