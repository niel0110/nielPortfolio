/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genealogy_israel;

/**
 *
 * @author Niel Patick
 */
public class GenealogyChild extends HumanExistData{

    GenealogyChild next;
    GenealogyChild prev;
    
    GenealogyChild(){
        super();
        next = null;
        prev = null;
    }
    GenealogyChild(HumanExistData hd){
        super(hd);
        next = null;
        prev = null;
    }
    GenealogyChild(HumanExistData gd, GenealogyChild N, GenealogyChild P){
        super(gd);
        next = N;
        prev = P;
    }
    
    //setters
    public void setNext(GenealogyChild n){next = n;}
    public void setPrev(GenealogyChild p){prev = p;}
    public void setPointers(GenealogyChild n, GenealogyChild p){
        next = n;
        prev = p;
    }
    
    //getters
    public GenealogyChild getNext(){return next;}
    public GenealogyChild getPrev(){return prev;}
    
    public String toString(){
        return super.toString();
    }
}
