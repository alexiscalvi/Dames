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
public class NDames {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*
        TESTS
         */
       // int nb_conflit = plateau.getNbConflit(test);
       // List<int[]> voisins = plateau.getVoisins();

        /*
        List<Double> listBestT0 = new ArrayList<Double>();
        List<Integer> listBestN2 = new ArrayList<Integer>();
        List<Double> listBestNu = new ArrayList<Double>();
        List<Integer> listResult = new ArrayList<Integer>();

        for(int n=0; n<10; n++) {
            int best= 1000000;
            double bestT0 = 0;
            int bestN2 = 0;
            double bestNu = 0;
            for (double t0 = 1; t0 < 15; t0++) {
                t0 *= 5;
                for (int n2 = 5; n2 < 20; n2++) {
                    for (double nu = 80; nu > 50; nu--) {

                        Recuit recuit = new Recuit(20, t0, 1000, n2, nu / 100);
                        int result = recuit.start();
                        System.out.println(result);
                        if (result < best) {
                            best = result;
                            bestT0 = t0;
                            bestN2 = n2;
                            bestNu = nu;
                        }
                    }
                }
            }

           // System.out.println("La configuration idéale est " + best + " avec les parametres suivants: ");
            System.out.println("t0: " + bestT0);
            System.out.println("n2: " + bestN2);
            System.out.println("nu: " + bestNu);
            listBestT0.add(bestT0);
            listBestN2.add(bestN2);
            listBestNu.add(bestNu);
            listResult.add(best);

        }

        double t0Final = 0;
        for(Double t0 : listBestT0){
            t0Final += t0;
        }
        t0Final /= listBestT0.size();
        System.out.println("La moyenne du meilleur t0 est: " + t0Final);

        int n2Final = 0;
        for(Integer n2 : listBestN2){
            n2Final += n2;
        }
        n2Final /= listBestN2.size();
        System.out.println("La moyenne du meilleur n2 est: " + n2Final);

        double nuFinal = 0;
        for(Double nu : listBestNu){
            nuFinal += nu;
        }
        nuFinal /= (listBestNu.size()*100);
        System.out.println("La moyenne du meilleur nu est: " + nuFinal);

*/

        Recuit recuit = new Recuit(500, 50,50,50, 0.95);
        int[] result = recuit.start();


        System.out.println("Solution valable:");
        for(int i : result){
            System.out.println(i);
        }

        Tabou tabou = new Tabou(500, 50);
        int[] result = recuit.start();


        System.out.println("Solution valable:");
        for(int i : result){
            System.out.println(i);
        }
    }
    
}
