package com.example.demo_13_runnable;

public class RunnableTest {
    public static void main(String args[]){
        Banji banji = new Banji(50);
        BanZhuRen banZhuRen = new BanZhuRen(banji);
        System.out.println("the number of banji is :" + banZhuRen.addChabanSheng().toString());

        BanZhuRen fubanZhuRen = new BanZhuRen(banji);
        System.out.println("the number of banji is :" + fubanZhuRen.addChabanSheng().toString());
    }
}

class BanZhuRen{
    private Banji banji;
    public BanZhuRen(Banji banji){
        this.banji = banji;
    }

    public Banji addChabanSheng(){
        return banji.addChabanSheng();
    }
}

class Banji{
    private int numOfStudent  = 50;
    Banji(int numOfStudent){
        this.numOfStudent = numOfStudent;
    }

    public void setNumOfStudent(int numOfStudent) {
        this.numOfStudent = numOfStudent;
    }

    public int getNumOfStudent() {
        return numOfStudent;
    }

    public Banji addChabanSheng(){
        this.numOfStudent++;
        return this;
    }

    @Override
    public String toString() {
        return numOfStudent + "";
    }
}