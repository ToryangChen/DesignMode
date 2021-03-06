package com.responsibility.example;

/**
 * Created by toryang on 7/14/16.
 */
public abstract class Handler {

    public static final int FATHER_LEVEL_REQUEST = 1;

    public static final int HUSBAND_LEVEL_REQUEST = 2;

    public static final int SON_LEVEL_REQUEST = 3;

    private int level = 0;

    private Handler nextHandler;

    public Handler(int level) {
        this.level = level;
    }

    public final void handleMessage(IWomen women){
        if (women.getType() == this.level){
            this.response(women);
        }else {
            if (this.nextHandler == null){
                this.nextHandler.handleMessage(women);
            }else {
                System.out.println("no where to request, disagree");
            }
        }
    }

    public void setNext(Handler handler){
        this.nextHandler = handler;

    }

    protected abstract void response(IWomen women);
}
