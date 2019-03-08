/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm_advanced;

/**
 *
 * @author Cahya
 */
public class Menu {
   private int noPilihan;
   private String keteranganPilihan;
   private boolean ForAdmin;
   private boolean ForSiswa;
   private boolean ForBisnis;
   private boolean ForMasaDepan;
   
   public Menu(int noPilihan, String keteranganPilihan, boolean ForAdmin, boolean ForSiswa, boolean ForBisnis, boolean ForMasaDepan){
       this.noPilihan = noPilihan;
       this.keteranganPilihan = keteranganPilihan;
       this.ForSiswa = ForSiswa;
       this.ForMasaDepan = ForMasaDepan;
       this.ForBisnis = ForBisnis;
       this.ForAdmin = ForAdmin;
   }
   public boolean getForSiswa(){
       return ForSiswa;
   }
   public boolean getForMasaDepan(){
       return ForMasaDepan;
   }
   public boolean getForBisnis(){
       return ForBisnis;
   }
   public boolean getForAdmin(){
       return ForAdmin;
   }
   public String getketeranganPilihan(){
       return keteranganPilihan;
   }   
   public int getNoPilihan(){
       return noPilihan;
   }   
}
