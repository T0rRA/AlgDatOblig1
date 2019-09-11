package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {

    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er for kort!");
        } else

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int midlertidig = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = midlertidig;
                }
            }
        return a[a.length - 1];
    }


    public static int ombyttinger(int[] a) {
        int antall = 0;

        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er for kort!");
        } else
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int midlertidig = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = midlertidig;
                    antall++;
                    System.out.println("Antall ombyttinger: " + antall);
                }
            }
        return antall;
    }



    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int antallForskjelligeVerdier = 1;

            for (int i = 1; i < a.length; i++){
                //Sjekker om listen er sortert
                if(a[i-1] > a[i]) {
                    throw new IllegalStateException("Listen er ikke sortert");
                }

                if(a[i-1] != a[i]){
                    antallForskjelligeVerdier++;
                }
            }

            if(a.length <= 0){
                antallForskjelligeVerdier = 0;
            }
        return antallForskjelligeVerdier;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int antallForskjelligeVerdier = a.length;
        int tellerTemp = -1;

        for(int i = 0; i < a.length; i++){
            for(int j = i; j < a.length; j++){
                if(a[i] == a[j]){
                    tellerTemp++;
                }
            }
            antallForskjelligeVerdier = antallForskjelligeVerdier - tellerTemp;
            tellerTemp = -1;
        }
        System.out.println(antallForskjelligeVerdier);

        return antallForskjelligeVerdier;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int left = 0;
        int right = a.length-1;

        while(left < right){
            while (a[left] % 2 != 0 && left < a.length-1){
                left++;
            }
            while (a[right] % 2 == 0 && right > 0){
                right--;
            }
            if(left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }

        }

        if(left != a.length-1) {
            sort(a, 0, left - 1);
            sort(a, left, a.length - 1);
        }else{
            sort(a, 0, a.length-1);
        }
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if(a.length == 0){
            return;
        }
        char sisteVerdi = a[a.length-1];
        for(int i = 1; i < a.length; i++){
            char temp = a[i];
            a[i] = a[0];
            a[0] = temp;
        }
        a[0] = sisteVerdi;
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

    public static void sort(int[] a, int left, int right){
        if(left < right) {
            int partisjon = partition(a, left, right);

            sort(a, left, partisjon - 1);
            sort(a, partisjon, right);
        }
    }

    public static int partition(int[] a, int left, int right){
        int pivot = a[(left + right)/2];

        while(left <= right){
            while (a[left] < pivot){
                left++;
            }
            while (a[right] > pivot){
                right--;
            }
            if(left <= right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
/*int[] a = {3};
        int[] b = {5, 2, 8, 4, 7, 6};
        int[] c = {5, 4, 3, 2, 1};
        int[] d = {1, 2, 3, 4, 5};*/

    public static void main(String[] args){
        int [] tall = {6,2,4};
        sort(tall, 0, tall.length-1);
        for(int nummere: tall){
            System.out.print(nummere);
        }

   /*     for(int nummer : tall){
        int [] tall = {324,2,7,8,3};
        int [] a = {1, 3, 5, 4, 2, 6};
        sort(a,3,a.length-1);
        sort(tall, 0, tall.length-1);
        for(int nummer : tall){
            System.out.print(nummer + " ");

        }

        }
        System.out.println("");
        for (int nummer : a){
            System.out.print(nummer + " ");
        }*/
    }
}
  // Oblig1


