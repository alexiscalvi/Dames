/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ndames;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author p1506625
 */
public class Recuit extends Algo{

    int i = 0;
    
    int size;
    int[] x0;
    double t0;
    int n1;
    int n2;
    double nu;
    
    public Recuit(int size, double t0, int n1, int n2, double nu){
        this.size = size;
        this.x0 = firstPlateau(size);
        this.t0 = t0;
        this.n1 = n1;
        this.n2 = n2;
        this.nu = nu;
    }
    
   // public int start(){
    public int[] start(){

        int[] xi = x0;
        int[] xmin = x0;
        int fxi = getNbConflit(xi);
        int fmin = fxi;
        double ti = t0;
        int changementTemp = 0;
        int cpt = 0;

        for(int k = 0; k < n1+1; k++){

            for(int l = 1; l < n2+1 ; l++ ){
                cpt++;
                List<int[]> neighbours = getVoisins(xi);

                int index = (int) (Math.random() * (neighbours.size() - 1));
                int[] y = neighbours.get(index);
                int fY = getNbConflit(y);
                int deltaF = fY - fxi;

                if(deltaF <= 0){
                    if(fY < fmin){
                        fmin = fY;
                        xmin = y;
                    }
                    fxi = fY;
                    xi = y;
                }
                else{
                    //tirage entre 0 et 1
                    double alea = (Math.random() * 1);
                    double param = -deltaF/ti;
                    if(alea <= Math.exp(param)){
                        fxi = fY;
                        xi = y;
                    }

                }
                if(fmin == 0){
                    System.out.println("Nombre de changement de température:" + changementTemp);
                    //return cpt;
                    System.out.println("Nombre d'ittérations: "+cpt);
                    return xmin;

                }
               // System.out.println(n2);
            }
            ti = nu * ti;
            changementTemp++;
          //  System.out.println("Nouvelle temperature: "+ ti);
        }

        return xmin;
       // return 0;
    }


}
