package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.NoSuchElementException;

import static java.lang.Math.abs;
import static java.lang.Math.cbrt;
import java.util.Arrays;
import static java.util.Arrays.binarySearch;


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

                }
            }
        System.out.println("Antall ombyttinger: " + antall); //FJERNES - teller antall ombyttinger it tester
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
                    if(tellerTemp < 1) {
                        tellerTemp++;
                    }
                }
            }
            antallForskjelligeVerdier = antallForskjelligeVerdier - tellerTemp;
            tellerTemp = -1;
        }

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

    ///// Oppgave 6 //////////////////////////////////for(int i = 0; i < a.length-1;i++){////
    public static void rotasjon(char[] a, int k) {
        if(a.length == 0){
            return;
        }

        int antallFlytt = k % a.length;
        char[] b = a.clone();

        if(k > 0){
            for(int i = 0; i < a.length; i++){
                if(i + antallFlytt < a.length){
                    a[i + antallFlytt] = b[i];
                }else{
                    a[i+antallFlytt - a.length] = b[i];
                }
            }
        }else if(k < 0){
            for(int i = a.length-1; i >= 0; i--){
                if(i + antallFlytt >= 0){
                    a[i + antallFlytt] = b[i];
                }else{
                    a[a.length+(i + antallFlytt)] = b[i];
                }
            }
        }
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        char[]sArray = s.toCharArray(); // caster til array
        char [] tArray = t.toCharArray();
        char[]kombinert = new char[sArray.length+tArray.length];

        int i= 0, j = 0, k=0;
        while(i<sArray.length && j<tArray.length){
            kombinert[k++] = sArray[i++]; // verdi fra sArray
            kombinert[k++] = tArray[j++]; //verdi fra tArray
        }
          while (i<sArray.length){kombinert[k++] = sArray[i++];}
          while (j<tArray.length){kombinert[k++] = tArray[j++];}

          String ut = new String (kombinert);
          return ut;

       /* String utString = "";
        int lengde = s.length() - t.length();
        if (lengde > 0) {
            for (int i = 0; i < t.length(); i++) {
                utString += s.charAt(i);
                utString += t.charAt(i);
            }
            for (int i = lengde; i < s.length(); i++) {
                utString += s.charAt(i);
            }
            return utString;
        } else {
            for (int i = 0; i < s.length(); i++) {
                utString += s.charAt(i);
                utString += t.charAt(i);
            }
            for (int i = Math.abs(lengde); i < t.length(); i++) {
                utString += t.charAt(i);
            }
            return utString;
        }*/
    }
    /// 7b)
    public static String flett(String... s) {
        if(s.length == 0){
            return "";
        }
        String ut = "";
        int [] lengderAvStrenger = new int[s.length];
        for(int i = 0; i < s.length; i++){
            lengderAvStrenger[i] = s[i].length();
        }


        int lengsteString = lengderAvStrenger[0];
        for(int i = 1; i < lengderAvStrenger.length; i++){
            if(lengderAvStrenger[i] > lengsteString){
                lengsteString = lengderAvStrenger[i];
            }
        }

        for (int j = 0; j < lengsteString; j++){
                for (int k = 0; k < s.length; k++){
                    if (j < lengderAvStrenger[k]) {
                        ut += s[k].charAt(j);
                    }
                }
            }

        return ut;
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int[] sortertIndeks = new int [a.length];

        if(a.length == 0){
            return sortertIndeks;
        }
        if(a.length == 1){
            return new int[]{0};
        }

        int[] b = a.clone();
        sort(b,0,a.length-1);

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                if(a[j] == b[i]){
                    sortertIndeks[i] = j;
                }
            }
        }
        return sortertIndeks;
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        if(a.length < 3){
            throw new NoSuchElementException("Du må ha en tabell som har 3 eller flere verdier");
        }

        int [] sortertIndeks;

        int [] b = new int[3];
        System.arraycopy(a,0,b,0,3);
        sortertIndeks = indekssortering(b);

        int minsteIndeks = sortertIndeks[0];
        int andreminsteIndeks = sortertIndeks[1];
        int tredjeminsteIndeks = sortertIndeks[2];

        int minsteVerdi = a[minsteIndeks];
        int andreminsteVerdi = a[andreminsteIndeks];
        int tredjeminsteVerdi = a[tredjeminsteIndeks];

        for(int i = 3; i < a.length; i++){
            if(a[i] < minsteVerdi){
                tredjeminsteVerdi = andreminsteVerdi;
                tredjeminsteIndeks = andreminsteIndeks;
                andreminsteVerdi = minsteVerdi;
                andreminsteIndeks = minsteIndeks;
                minsteVerdi = a[i];
                minsteIndeks = i;
            } else if(a[i] < andreminsteVerdi){
                tredjeminsteVerdi = andreminsteVerdi;
                tredjeminsteIndeks = andreminsteIndeks;
                andreminsteVerdi = a[i];
                andreminsteIndeks = i;
            } else if(a[i] < tredjeminsteVerdi){
                tredjeminsteVerdi = a[i];
                tredjeminsteIndeks = i;
            }
        }

        sortertIndeks[0] = minsteIndeks;
        sortertIndeks[1] = andreminsteIndeks;
        sortertIndeks[2] = tredjeminsteIndeks;
        return sortertIndeks;
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {


        return 0;
    }

    public static boolean inneholdt(String a, String b) {

        char[]aR = a.toCharArray();

        //TODO KJØRE SORT og kjøre binary Search
        //if (binarySearchForChar >0) return true
        //if (binarySearchForChar <0 return false
        return true;
    }
    public static int binarySearchForChar(char[]a, char bokstav){
        int lav = 0;
        int hoy = a.length-1;
        //kan evt teste lav/høy endepunkter: if (lav<0||høy>.length||lav>høy) ArrayOutOfBoundsException

        while (lav<hoy) {
        int m = (lav+hoy)/2;
        if (bokstav > a[m]) lav= m+1;
        else hoy=m;
        }
        if(hoy<lav||bokstav == a[lav]) return -(lav+1); //her er bokstaven IKKE funnet
        else if (bokstav == a[lav])return lav; // her er bokstaven FUNNET
        else return -(lav+2); // bokstaven er ikke funnnet
    }
    //recursive : legg til
    /*
        return binarySearchForChar(bokstav, a);
    }*/


    public static void sort(int[] a, int left, int right){
        if(left < right) {
            int partisjon = partition(a, left, right);

            sort(a, left, partisjon - 1);
            sort(a, partisjon, right);
        }
    }

    private static int partition(int[] a, int left, int right){
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

    public static void sort(char[] a, int left, int right){
        if(left < right) {
            int partisjon = partition(a, left, right);

            sort(a, left, partisjon - 1);
            sort(a, partisjon, right);
        }
    }

    private static int partition(char[] a, int left, int right){
        int pivot = a[(left + right)/2];

        while(left <= right){
            while (a[left] < pivot){
                left++;
            }
            while (a[right] > pivot){
                right--;
            }
            if(left <= right) {
                char temp = a[left];
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
        int[] c = {5, 4, 3, 2, 1};System.​out.println(a);
        int[] d = {1, 2, 3, 4, 5};*/

    public static void main(String[] args){
        String s = Oblig1.flett("AFK", "BGLP", "CHMQT", "DINRUW", "EJOSVXY");
        System.out.println(s);
    }}

  // Oblig1


//test commit