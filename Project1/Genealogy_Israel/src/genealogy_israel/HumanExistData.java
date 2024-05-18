/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genealogy_israel;

/**
 *
 * @author Niel Patick
 */
public class HumanExistData {
   
    String generation;
    String father;
    String allyearslived;
    String yearsfromcreation;
    
    HumanExistData(){
        generation = "";
        father = "";
        allyearslived = "";
        yearsfromcreation = "";
    }
    HumanExistData(HumanExistData hd){
        generation = hd.getgeneration();
        father = hd.getfather();
        allyearslived = hd.getallyearslived();
        yearsfromcreation = hd.getyearsfromcreation();
        
    }
    HumanExistData(String g, String f, String ayl, String yfc){
        generation = g;
        father = f;
        allyearslived = ayl;
        yearsfromcreation = yfc;
    }
    public void setGeneration(String g){generation = g;}
    public void setFather(String f){father = f;}
    public void setTotalYearsLived(String ayl){allyearslived = ayl;}
    public void setYearFromCreation(String yfc){yearsfromcreation = yfc;}
    
    public String getgeneration(){return generation;}
    public String getfather(){return father;}
    public String getallyearslived(){return allyearslived;}
    public String getyearsfromcreation(){return yearsfromcreation;}
    public HumanExistData getHumanExistData(){return this;}
    
    public String toString(){
        return generation+","+father+","+allyearslived+","+yearsfromcreation;
    }
}

