/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package redesneuronales;
import ANNs.*;
import basedatos.BDConector;

/**
 *
 * @author GAARA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        if(BDConector.conectar_bd()){
            BPN bp1=new BPN();
            String[] argss=new String[3];
            argss[0]="1";
            bp1.main(argss);
        }
        
        
    }

}
