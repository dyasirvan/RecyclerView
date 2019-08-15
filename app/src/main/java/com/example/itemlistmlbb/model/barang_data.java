package com.example.itemlistmlbb.model;

import java.util.ArrayList;

public class barang_data {
    public static String[][] data = new String[][]{
            {"Berserker's Fury", "+65 Physical Attack. +25% Critical Strike Chance.",
                    "https://mobilelegendsbangbang.com/wp-content/uploads/2017/07/berserkers-fury.png", "2350", "Attack"},

            {"Scarlet Phantom", "+30 Physical Attack. +40% Attack Speed. +10% Critical Strike Chance.",
                    "https://mobilelegendsbangbang.com/wp-content/uploads/2016/12/118-copy-1.jpg", "2020", "Attack"},

            {"Rapid Boots", "+50 Movement SPD", "https://mobilelegendsbangbang.com/wp-content/uploads/2016/12/53-copy-1.jpg",
                    "850", "Movement"},

            {"Endless Battle", "+65 Physical Attack. +25 Magic Power. +250 HP. +300 Mana. +5% Movement Speed. +15% Lifesteal.",
                    "https://mobilelegendsbangbang.com/wp-content/uploads/2016/12/endless-battle.png", "2470", "Attack"},

            {"Haa's Claw", "+70 Physical Attack.", "https://mobilelegendsbangbang.com/wp-content/uploads/2017/07/haas-claws-1.png",
                    "1810", "Attack"},

            {"Golden Staff", "+65 Physical Attack. +30% Attack Speed.",
                    "https://mobilelegendsbangbang.com/wp-content/uploads/2019/02/golden-staff.png", "2100", "Attack"},

            {"Curse Sword", "+30% Damage to Monsters",
                    "https://mobilelegendsbangbang.com/wp-content/uploads/2016/12/83-copy-1.jpg", "750", "Jungle"},

            {"Concentrated Energy", "+70 Magic Power. +700 HP.",
                    "https://mobilelegendsbangbang.com/wp-content/uploads/2016/12/41-copy-1.jpg", "2020", "Magic"},

            {"Calamity Reaper", "+70 Magic Power. +400 Mana. +10% Cooldown Reduction.",
                    "https://mobilelegendsbangbang.com/wp-content/uploads/2016/12/42-copy-2.jpg", "1950", "Magic"},

            {"Blade Armor", "+90 Armor",
                    "https://mobilelegendsbangbang.com/wp-content/uploads/2016/12/77-copy-1.jpg", "1660", "Defense"},
    };

    public static ArrayList<barang> getListData(){
        ArrayList<barang> list = new ArrayList<>();
        for (String[] aData : data) {
            barang brg = new barang();
            brg.setName(aData[0]);
            brg.setExplain(aData[1]);
            brg.setImg(aData[2]);
            brg.setPrice(aData[3]);
            brg.setType(aData[4]);
            list.add(brg);
        }
        return list;
    }
}
