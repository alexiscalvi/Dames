/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ndames;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author p1506625
 */
public class Tabou extends Algo {
    private int size;
    private int sizeT;
    private int[] x0;
    private List<Map> tabou;

    public Tabou(int size, int sizeT) {
        this.size = size;
        this.sizeT = sizeT;
        this.tabou = new ArrayList<>();
        this.x0 = firstPlateau(size);
    }

    public int[] start(){
        int[] xi = x0;
        int[] xmin = x0;
        int fxi = getNbConflit(xi);
        int fmin = fxi;
        int nbIter = 1;
        List<int[]> listVoisins;
        for (int i = 0; i < 1000 ; i++) {
            listVoisins = getVoisinsNotTabou(xi, this.tabou);
            int[] bestVoisin = new int[size];
            int fVoisin = -1;
            for (int[] voisin : listVoisins) {
                if (fVoisin == -1) {
                    bestVoisin = voisin;
                    fVoisin = getNbConflit(bestVoisin);
                } else {
                    if (getNbConflit(voisin) < fVoisin) {
                        fVoisin = getNbConflit(voisin);
                        bestVoisin = voisin;
                    }
                }
            }
            xi = bestVoisin;
            if (fVoisin > fxi) {

            }
            fxi = fVoisin;

            if(fmin == 0){
                System.out.println("Nombre d'ittérations: "+nbIter);
                return xmin;
            }
            nbIter++;
        }
        return xi;
    }

    public void addTabou()
}
