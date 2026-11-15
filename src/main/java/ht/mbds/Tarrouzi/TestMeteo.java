package ht.mbds.Tarrouzi;

import ht.mbds.Tarrouzi.outil.meteo.MeteoTool;

public class TestMeteo {

    public static void main(String[] args) {

        MeteoTool outil = new MeteoTool();

        boolean pluie = outil.isPluiePrevue(
                48.85,
                2.35,
                2,
                3
        );

        System.out.println("Seuil de pluie dépassé : " + pluie);

        if (pluie) {
            System.out.println("Prenez un parapluie., sauf si vous voulez prendre une douche");
        } else {
            System.out.println(
                    "Aucune journée ne dépasse le seuil"
            );
        }
    }
}