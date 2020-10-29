package com.company;

public class Cliente extends Thread {

    static Camarero c;

    public Cliente(Camarero c){
        this.c = c;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Main.list) {
                    if (!Main.list.isEmpty()){
                        System.out.println("Cliente - Voy a consumir un " + Main.list.get(0) + " 3 segundos");
                        Main.list.remove(0);
                        sleep(3000);


                    } else {
                        System.out.println("Cliente - Voy a esperar a que me traigan comida...");
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
