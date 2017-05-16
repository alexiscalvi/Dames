/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ndames;

import java.util.*;

/**
 *
 * @author p1506625
 */
public abstract class Algo {

    
    
    public int[] firstPlateau(int size){
        int[] plateau= new int[size];
        for(int i=0; i< size; i++){
            plateau[i] = i;
        }
        return plateau;
    }


    public int getNbConflit(int[] solution){

        int nb_conflits = 0;
        for(int i=0; i< solution.length; i++){
            for(int j=i+1; j< solution.length; j++){
                if(Math.abs(i-j) == Math.abs(solution[i]-solution[j])){
                    nb_conflits++;
                }
            }
        }
     //   System.out.println("nombre de conflits: "+ nb_conflits);
        return nb_conflits;
    }

    public List<int[]> getVoisins(int[] solution){

        List<int[]> neigboursList = new ArrayList<int[]>();
        int nb_voisins = 0;
        for(int i=0; i< solution.length; i++){
            for(int j=i+1; j< solution.length; j++){
                int[] tmp_tab = solution.clone();
                int tmp_data = tmp_tab[i];
                tmp_tab[i] = tmp_tab[j];
                tmp_tab[j] = tmp_data;
                nb_voisins++;

                neigboursList.add(tmp_tab);
            }
        }
     //   System.out.println(nb_voisins);
        for(int[] voisin : neigboursList){
            String string ="";
            for(int i=0; i< solution.length; i++){
                string += voisin[i]+" ";
            }
         //   System.out.println(string);
        }
        return neigboursList;

    }

    public List<int[]> getVoisinsNotTabou(int[] solution, List<Map> tabou){

        List<int[]> neigboursList = new ArrayList<int[]>();
        int[] index_tmp = new int[2];
        for(int i=0; i< solution.length; i++){
            for(int j=i+1; j< solution.length; j++){
                int[] tmp_tab = solution.clone();
                int tmp_data = tmp_tab[i];
                tmp_tab[i] = tmp_tab[j];
                tmp_tab[j] = tmp_data;
                index_tmp[0] = i;
                index_tmp[1] = j;
                if (isNotTabou(i, j, tabou)){
                    neigboursList.add(tmp_tab);
                }
            }
        }
        for(int[] voisin : neigboursList){
            String string ="";
            for(int i=0; i< solution.length; i++){
                string += voisin[i]+" ";
            }
        }
        return neigboursList;

    }

    public boolean isNotTabou(int i, int j, List<Map> tabou) {
        for (Map u : tabou) {
            Set cles = u.keySet();
            Iterator it = cles.iterator();
            while (it.hasNext()){
                int cle = (int) it.next(); // tu peux typer plus finement ici
                int valeur = (int) u.get(cle); // tu peux typer plus finement ici
                if ( (i == cle && j == valeur) || (j == cle && i == valeur)) {
                    return false;
                }
            }
        }
        return true;
    }

    
    
    
}
