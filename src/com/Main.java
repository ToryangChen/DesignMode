package com;

import com.abstractfactory.example.FemaleFactory;
import com.abstractfactory.example.MaleFactory;
import com.builder.example.Director;
import com.command.example.AddRequirementCommand;
import com.command.example.Command;
import com.command.example.DeleteRequirementCommand;
import com.command.example.Invoker;
import com.decorator.example.ForthGradeSchoolReport;
import com.decorator.example.HighScoreDecorator;
import com.decorator.example.SchoolReport;
import com.decorator.example.SortDecorator;
import com.factorymethod.example.*;
import com.mediator.*;
import com.prototype.example.AdvTemplate;
import com.prototype.example.Mail;
import com.proxy.example.GamePlayer;
import com.proxy.example.GamePlayerProxy;
import com.proxy.example.IGamePlayer;
import com.responsibility.example.*;
import com.singleton.example.Emperor;
import com.strategy.example.BackDoor;
import com.strategy.example.BlockEnemy;
import com.strategy.example.Context;
import com.strategy.example.GivenGreenLight;
import com.templatemethod.example.HummerH1Model;
import com.templatemethod.example.HummerH2Model;
import com.templatemethod.example.HummerModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by toryang on 7/11/16.
 */
public class Main {
    private static int MAX_COUNT = 6;

    public static void main(String[] args) {
//        singleton();
//        nvWa();
//        updatenvWa();
//        car();
//        builder();
//        proxy();
//        prototype();
//        mediator();
//        command();
//        responsibility();
//        decorator();
        strategy();
    }

    /**
     * singleton pattern
     */
    private static void singleton(){
        int ministerNum = 5;
        for (int i=0;i<ministerNum;i++) {
            Emperor emperor = Emperor.getInstance();
            System.out.print("第" + (i + 1) + "个大臣参拜的是:");
            emperor.say();
        }
    }

    /**
     * Factory Method Pattern
     */
    private static void nvWa(){
        AbstractHumanFactory yingyanglu = new HumanFactory();

        System.out.println("----造出白色人种----");
        Human whiteman = yingyanglu.createHuman(WhiteHuman.class);
        whiteman.getColor();
        whiteman.talk();

        System.out.println("-----造出黑色人种-----");
        Human blackman = yingyanglu.createHuman(BlackHuman.class);
        blackman.getColor();
        blackman.talk();

        System.out.println("-----造出黄色人种------");
        Human yellowHuman = yingyanglu.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();

    }

    /**
     * Abstract Method Pattern
     */
    private static void updatenvWa(){
        com.abstractfactory.example.HumanFactory maleHumanFactory = new MaleFactory();
        com.abstractfactory.example.HumanFactory femaleHumanFactory = new FemaleFactory();

        com.abstractfactory.example.Human maleYellowHuman = maleHumanFactory.createYellowHuman();
        com.abstractfactory.example.Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();
        System.out.println("----生产黄人女性-----");
        femaleYellowHuman.getColor();
        femaleYellowHuman.getSex();;
        femaleYellowHuman.talk();
        System.out.println("----生产黄人男性------");
        maleYellowHuman.getColor();
        maleYellowHuman.getSex();
        maleYellowHuman.talk();

        /**
         * 继续生产
         */

    }

    /**
     * Template Method Pattern
     */
    private static void car(){
        HummerModel h1 = new HummerH1Model();
        h1.run();

        HummerModel h2 = new HummerH2Model();
        h2.run();
    }

    /**
     * Builder Pattern
     */
    private static void builder(){
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("engine boom");
//        arrayList.add("stop");
//        arrayList.add("start");
//        BenzBuilder builder = new BenzBuilder();
//        builder.setSequence(arrayList);
//        BenzModel model = (BenzModel) builder.getCarModel();
//        model.run();

        Director director = new Director();

        for (int i=0;i<10000;i++){
            director.getABenzModel().run();
        }
        for (int i=0;i<100000;i++){
            director.getABMWModel().run();
        }
        //.......
    }

    /**
     * Proxy Pattern
     */
    private static void proxy(){
        IGamePlayer player = new GamePlayer("san");
        GamePlayerProxy playerProxy = new GamePlayerProxy(player);

        System.out.println("开始时间:10:22");
        playerProxy.login("zhangsan","password");
        playerProxy.killBoss();
        playerProxy.upgrade();
        System.out.println("结束时间:12:20");
    }

    /**
     * Prototype Pattern
     */
    private static void prototype(){
        int i=0;
        Mail mail = new Mail(new AdvTemplate());

        mail.setTail("Toryang's");

        while (i<MAX_COUNT){
            Mail cloneMail = mail.clone();
            cloneMail.setAppellation("Mr/Ms: "+getRandString(5));
            cloneMail.setReceiver(getRandString(8)+"@.com");
            sendMail(cloneMail);
            i++;
        }

    }

    private static void sendMail(Mail mail){
        System.out.println("titla:"+mail.getSubject()+"  receiver:"+mail.getReceiver()+"\t...send success");
    }

    private static String getRandString(int maxLength){
        String source = "abcdefghiJklmnopqrstuvwkyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random rand = new Random();
        for (int i=0;i<maxLength;i++){
            sb.append(source.charAt(rand.nextInt(source.length())));
        }

        return sb.toString();
    }


    /**
     * Mediator Pattern
     */

    private static void mediator(){
        AbstractMediator mediator = new Mediator();

        System.out.println("-----采购人员采购电脑------");
        Purchase purchase = new Purchase(mediator);
        purchase.buyIBMcomputer(100);

        System.out.println("-----销售人员销售电脑------");
        Sale sale = new Sale(mediator);
        sale.sellIBMComputer(100);

        System.out.println("------库房人员清理库存------");
        Stock stock = new Stock(mediator);
        stock.clearStock();


    }


    /**
     * Command Pattern
     */

    private static void command(){
        Invoker invoker = new Invoker();
        System.out.println("-----增加需求------");
        Command command = new AddRequirementCommand();
        invoker.setCommand(command);
        invoker.action();

        System.out.println("-----删除需求-------");
        Command deleteCommand = new DeleteRequirementCommand();
        invoker.setCommand(deleteCommand);
        invoker.action();
    }


    /**
     * Chain of Responsibility Pattern
     */
    private static void responsibility(){
        Random random = new Random();
        ArrayList<IWomen> arrayList = new ArrayList();
        for (int i=0;i<5;i++){
            arrayList.add(new Women(random.nextInt(4),"出去逛街"));
        }
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();

        father.setNext(husband);
        husband.setNext(son);
        for (IWomen women: arrayList ){
            father.handleMessage(women);
        }

    }

    /**
     * Decorator Pattern
     */
    private static void decorator(){
        SchoolReport sr;
        sr = new ForthGradeSchoolReport();
        sr = new HighScoreDecorator(sr);
        sr = new SortDecorator(sr);

        sr.report();

        sr.sign("Sam");
    }

    /**
     * Strategy Pattern
     */
    private static void strategy(){
        Context context;
        System.out.println("---one---");
        context = new Context(new BackDoor());
        context.operate();
        System.out.println("---two---");
        context = new Context(new GivenGreenLight());
        context.operate();
        System.out.println("---three---");
        context = new Context(new BlockEnemy());
        context.operate();

    }
}
