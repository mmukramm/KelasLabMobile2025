package com.example.pertemuan3kelasa;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Cat> cats = generatePosts();
    public static ArrayList<Cat> generatePosts() {
        Cat bigPoo = new Cat("Big Poo", 2, "https://static.wikia.nocookie.net/silly-cat/images/0/08/Big_Poo.png/revision/latest?cb=20230930142918&format=original");
        Cat jinx = new Cat("Jinx", 1, "https://static.wikia.nocookie.net/silly-cat/images/d/d8/Jinx.png/revision/latest?cb=20231009175403&format=original");
        Cat theBeast = new Cat("The Beast", 3, "https://static.wikia.nocookie.net/silly-cat/images/2/29/The_Beast.png/revision/latest?cb=20231001184905&format=original");
        Cat adolfKitler = new Cat("Adolf Kitler", 3, "https://static.wikia.nocookie.net/silly-cat/images/0/08/Kitler.png/revision/latest?cb=20240107144727&format=original");
        Cat mrFresh = new Cat("MrFresh", 3, "https://static.wikia.nocookie.net/silly-cat/images/4/4d/Mr._Fresh.png/revision/latest?cb=20240117170647&format=original");
        Cat elGato = new Cat("El Gato", 3, "https://static.wikia.nocookie.net/silly-cat/images/f/fe/El_Gato.png/revision/latest?cb=20231010115301&format=original");
        Cat cuh = new Cat("Cuh", 2, "https://static.wikia.nocookie.net/silly-cat/images/3/35/Cuh.png/revision/latest?cb=20231019143206&format=original");
        Cat buh = new Cat("Buh", 2, "https://static.wikia.nocookie.net/silly-cat/images/5/5b/Buh.png/revision/latest?cb=20231019143736&format=original");
        Cat uncle = new Cat("Uncle", 1, "https://static.wikia.nocookie.net/silly-cat/images/8/86/Uncle.png/revision/latest?cb=20231013132411&format=original");
        Cat ethelTheCat = new Cat("Ethel the Cat", 1, "https://static.wikia.nocookie.net/silly-cat/images/c/c4/Ethel_the_cat.png/revision/latest?cb=20241231045202&format=original");
        ArrayList<Cat> dump = new ArrayList<>();
        dump.add(bigPoo);
        dump.add(jinx);
        dump.add(theBeast);
        dump.add(adolfKitler);
        dump.add(mrFresh);
        dump.add(elGato);
        dump.add(cuh);
        dump.add(buh);
        dump.add(uncle);
        dump.add(ethelTheCat);
        return dump;

    }
}
