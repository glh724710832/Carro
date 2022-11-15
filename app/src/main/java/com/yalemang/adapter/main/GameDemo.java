package com.yalemang.adapter.main;

import android.util.Log;

/**
 * @author Administrator
 */
public class GameDemo {
    private static final String TAG ="number" ;

    public static void main(String[]args){
        int surviveNumber = 10000;
        int[] numberList = new int[10000];
        while (surviveNumber>1){
            int startNumber=1;
            for (int i:numberList) {
                if (i==0){
                    startNumber++;
                    if (startNumber==5){
                        numberList[i]=1;
                        surviveNumber--;
                    }
                }
                if (surviveNumber == 5){
                    /*
                    输出这五个数
                     */
                }




            }
        }



    }

    private static void startGame() {

         Thread thread = new Thread(new Runnable() {
             @Override
             public void run() {
                 Log.d(TAG, "run: 线程执行代码");
             }
         });
         thread.start();

    }





}
