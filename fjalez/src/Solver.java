import java.text.*;
import javax.swing.*;

import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solver {

    public static String alfabeti = "abcçdeëfghijklmnopqrstuvxyz";
    public static String[] listaP;// lista e plote
    public static ArrayList<String> lista2;
    public fjalet klasafjalet;
    public static String parashikimi;

    public Solver() {
        parashikimi = "po";
        klasafjalet = new fjalet();
        listaP = new String[klasafjalet.fjalet.length];
        for (int i = 0; i < klasafjalet.fjalet.length; i++) {
            listaP[i] = klasafjalet.fjalet[i];
        }
        lista2 = new ArrayList<String>();

    }

    public void listambetur(int one, int two, int three, int four, int five) {

        // lista merr te gjitha fjalet ne momentin e inicializimit(tentativen e pare)
        if (one == -1) {

            for (int i = 0; i < listaP.length; i++) {
                lista2.add(listaP[i]);
            }
        } else {

      /*      // futen te gjithe antaret e listes
            for (int i = 0; i < listaP.length; i++) {
                lista2.add(listaP[i]);
            }   */
            //  fshihen anetaret qe nuk fillojne me shkronjen e pare

            if (one == 2) {
                for (int i = lista2.size() - 1; i > -1; i--) {

                    if (!(lista2.get(i).charAt(0) == parashikimi.charAt(0))) {
                        lista2.remove(i);
                    }

                }

            } else if (one == 1) {

                for (int i = lista2.size() - 1; i > -1; i--) {
                    if (!(lista2.get(i).contains(parashikimi.charAt(0) + ""))) {
                        lista2.remove(i);
                    }
                }
            } else if (one == 0) {

                for (int i = lista2.size() - 1; i > -1; i--) {
                    if ((lista2.get(i).contains(parashikimi.charAt(0) + ""))) {
                        lista2.remove(i);
                    }
                }
            }

            if (two == 2) {
                for (int i = lista2.size() - 1; i > -1; i--) {

                    if (!(lista2.get(i).charAt(1) == parashikimi.charAt(1))) {
                        lista2.remove(i);
                    }

                }

            } else if (two == 1) {

                for (int i = lista2.size() - 1; i > -1; i--) {
                    if (!(lista2.get(i).contains(parashikimi.charAt(1) + ""))) {
                        lista2.remove(i);
                    }
                }
            } else if (two == 0) {

                for (int i = lista2.size() - 1; i > -1; i--) {
                    if ((lista2.get(i).contains(parashikimi.charAt(1) + ""))) {
                        lista2.remove(i);
                    }
                }
            }

            if (three == 2) {
                for (int i = lista2.size() - 1; i > -1; i--) {

                    if (!(lista2.get(i).charAt(2) == parashikimi.charAt(2))) {
                        lista2.remove(i);
                    }

                }

            } else if (three == 1) {

                for (int i = lista2.size() - 1; i > -1; i--) {
                    if (!(lista2.get(i).contains(parashikimi.charAt(2) + ""))) {
                        lista2.remove(i);
                    }
                }
            } else if (three == 0) {

                for (int i = lista2.size() - 1; i > -1; i--) {
                    if ((lista2.get(i).contains(parashikimi.charAt(2) + ""))) {
                        lista2.remove(i);
                    }
                }
            }

            if (four == 2) {
                for (int i = lista2.size() - 1; i > -1; i--) {

                    if (!(lista2.get(i).charAt(3) == parashikimi.charAt(3))) {
                        lista2.remove(i);
                    }

                }

            } else if (four == 1) {

                for (int i = lista2.size() - 1; i > -1; i--) {
                    if (!(lista2.get(i).contains(parashikimi.charAt(3) + ""))) {
                        lista2.remove(i);
                    }
                }
            } else if (four == 0) {

                for (int i = lista2.size() - 1; i > -1; i--) {
                    if ((lista2.get(i).contains(parashikimi.charAt(3) + ""))) {
                        lista2.remove(i);
                    }
                }
            }

            if (five == 2) {
                for (int i = lista2.size() - 1; i > -1; i--) {

                    if (!(lista2.get(i).charAt(4) == parashikimi.charAt(4))) {
                        lista2.remove(i);
                    }

                }

            } else if (five == 1) {

                for (int i = lista2.size() - 1; i > -1; i--) {
                    if (!(lista2.get(i).contains(parashikimi.charAt(4) + ""))) {
                        lista2.remove(i);
                    }
                }
            } else if (five == 0) {

                for (int i = lista2.size() - 1; i > -1; i--) {
                    if ((lista2.get(i).contains(parashikimi.charAt(4) + ""))) {
                        lista2.remove(i);
                    }
                }
            }

        }

    }

    public String enthropy() {
        
        double[] probabiliteti = new double[alfabeti.length()];

        // llogarit propabilitetin qe nje shkronje te jete ne nje fjale  
       
        for (int i = 0; i < alfabeti.length(); i++) {

            int letterN = 0;

            for (int j = 0; j < lista2.size(); j++) {

// Nese fjala e rradhes ne liste j e ka shkronjen ne i atehere rritet numri i fjaleve qe kane ate shkronje
               if ((lista2.get(j).contains(alfabeti.charAt(i) + ""))){
                    letterN++;
                }
            }
// gjendet propabiliteti i prezences se nje shkronje te caktuar ne fjale duke pjestuar numrin e fjaleve me numrin e pergjithshem te listes
          probabiliteti[i] = ((letterN*1.0) / lista2.size());
        }

        // mbledhja  e propabilitetit te seciles fjale
        
        
        //entropia maksimale dhe indeksi i fjales qe 
        double max = 0;
        int indexMax=0;

        for (int i = 0; i < lista2.size(); i++) {

            double entropiaN = 0;

            for (int j = 0; j < 5; j++) {

                // merrr indeksin e shkronjes ne nje fjale - prej 1 deri ne 5 per secilen fjale per te kalkuluar probabilitetin me pas
                int letterIndex = alfabeti.indexOf(lista2.get(i).charAt(j));
                //                 
                entropiaN += probabiliteti[letterIndex] * ((Math.log(1/(probabiliteti[letterIndex])))/Math.log(2));
                
                if (entropiaN > max) {

                    max = entropiaN;
                     indexMax = i;
                }

            }

        }

        return lista2.get(indexMax);
    }

    public void dritarja() {

        for (int j = 0; j < 6; j++) {

            if (j == 0) {
                listambetur(-1, 0, 0, 0, 0);
                JOptionPane.showMessageDialog(null, "Fjale e parashikuar :" + enthropy());
            } else {
// nese deshirojme qe fjala te shkruhet manualisht
                // String fjala = JOptionPane.showInputDialog("Shtypni fjalen e provuar: ");
                //parashikimi = fjala;
                String numrat = JOptionPane.showInputDialog("Shtypni vlerat e fjales: ");

                int s1 = new Integer(numrat.charAt(0) + "").intValue();  // convert  input  into an int
                int s2 = new Integer(numrat.charAt(1) + "").intValue();  // convert  input  into an int
                int s3 = new Integer(numrat.charAt(2) + "").intValue();  // convert  input  into an int
                int s4 = new Integer(numrat.charAt(3) + "").intValue();  // convert  input  into an int
                int s5 = new Integer(numrat.charAt(4) + "").intValue();  // convert  input  into an int
                 // nese dojme qe fjala te shkruhet automatikisht
                parashikimi = enthropy();

                if(s1==2&&s2==2&&s3==2&&s4==2&&s5==2){
                JOptionPane.showMessageDialog(null, "Fjale e sakte ishte " + enthropy());
                j=5;
                }else{
                
                
                    listambetur(s1, s2, s3, s4, s5);
                    JOptionPane.showMessageDialog(null, "Fjale e parashikuar " + enthropy());
                }
                }

            }

        }

        
    public void fshij() {

        lista2.clear();
    }
    
    
    }


    





