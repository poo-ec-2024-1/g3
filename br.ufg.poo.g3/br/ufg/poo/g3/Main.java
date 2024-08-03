package br.ufg.poo.g3;
import java.util.Scanner;

/** 
 * @author (Ícaro Pereira) 

 */
public class Main
{
    public static void main (String[]args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Insira o seu nome:");
        String nome = sc.nextLine();
        System.out.println("Insira o seu saldo:");
        double saldo = sc.nextDouble();
        
        
        Usuario usuario1 = new Usuario(nome, "(62)99999-9999", saldo);
        //Usuario usuario2 = new Usuario("Sophia", "(62)98888-9999", 780);
        
        usuario1.processarPagamento(30.0);
        //usuario2.processarPagamento(30.0);
        //.out.println("Saldo atualizado: R$" + usuario1.getSaldo());
        //System.out.println("Saldo atualizado: R$" + usuario2.getSaldo());

        sc.close();
    }


}
