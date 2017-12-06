
public class Arenaaa {
	 private Bojovnik bojovnik1;
     private Bojovnik bojovnik2;
     private Kostka kostka;

     public Arenaaa(Bojovnik bojovnik1, Bojovnik bojovnik2, Kostka kostka) {
             this.bojovnik1 = bojovnik1;
             this.bojovnik2 = bojovnik2;
             this.kostka = kostka;
     }
     private void vykresli() {
         System.out.println("-------------- Ar�na -------------- \n");
         System.out.println("Zdrav� bojovn�k�: \n");
         System.out.printf("%s %s\n", bojovnik1, bojovnik1.grafickyZivot());
         System.out.printf("%s %s\n", bojovnik2, bojovnik2.grafickyZivot());
 }
     private void vypisZpravu(String zprava) {
         System.out.println(zprava);
         try {
             Thread.sleep(500);
         } catch (InterruptedException ex) {
             System.err.println("Chyba, nepovedlo se uspat vl�kno");
         }
 }
     public void zapas() {
    	 Bojovnik b1 = bojovnik1;
         Bojovnik b2 = bojovnik2;
         System.out.println("V�tejte v ar�n�!");
         System.out.printf("Dnes se utkaj� %s s %s! \n\n", bojovnik1, bojovnik2);
         System.out.println("Z�pas m��e za��t...");
         
         boolean zacinaBojovnik2 = (kostka.hod() <= kostka.vratPocetSten() / 2);
         if (zacinaBojovnik2) {
                 b1 = bojovnik2;
                 b2 = bojovnik1;
         }
         System.out.printf("Za��nat bude bojovn�k %s! \n\nZ�pas m��e za��t...", b1);


         // cyklus s bojem
         while (b1.nazivu() && b2.nazivu()) {
             b1.utoc(b2);
             vykresli();
             vypisZpravu(b1.vratPosledniZpravu()); // zpr�va o �toku
             vypisZpravu(b2.vratPosledniZpravu()); // zpr�va o obran�
             if (b2.nazivu()) {
                     b2.utoc(b1);
                     vykresli();
                     vypisZpravu(b2.vratPosledniZpravu()); // zpr�va o �toku
                     vypisZpravu(b1.vratPosledniZpravu()); // zpr�va o obran�
             }
             System.out.println();
     }
   }
}
   
