/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genealogy_israel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Niel Patick
 */
public class LinkedList {

    private static GenealogyChild head;
    private static GenealogyChild tail;
    public static int size;
    
    //Instantiation/Reset
    LinkedList(){
        MakeEmpty();
    }
    public static  void MakeEmpty(){ //serves as constructor as well
        head = new GenealogyChild();
        tail = new GenealogyChild();
        size = 0;
        head.setPointers(tail, null);
        tail.setPointers(null, head);
    }
    
    //Insertion
    public static void insert(GenealogyChild newgc){ //insertion at the end of list
        insert(newgc, size);
    }
    public static boolean insert(GenealogyChild newgc, int loc){ //insertion in beginning or anywhere in list
        GenealogyChild nav = findbyIndex(loc);
        if(nav != null){
            newgc.setNext(nav);
            newgc.setPrev(nav.getPrev());
            nav.getPrev().setNext(newgc);
            nav.setPrev(newgc);
            size++;
            return true;
        }
        if(loc == size){
            newgc.setNext(tail);
            newgc.setPrev(tail.getPrev());
            tail.getPrev().setNext(newgc);
            tail.setPrev(newgc);
            size++;
            return true;
        }
        return false;
    }
    
    //Searching through LinkedList
    public static int findbyValue(GenealogyChild gc){
        if(size > 0){
            int x = 0, y = size - 1;
            
            GenealogyChild nav1 = head.getNext();
            GenealogyChild nav2 = tail.getPrev();
            
            while(x <= y){
                if (nav1 != null && nav1.equals(gc)) {return x;}
                if (nav2 != null && nav2.equals(gc)) {return y;}

                nav1 = (nav1 != null) ? nav1.getNext() : null;
                nav2 = (nav2 != null) ? nav2.getPrev() : null;
                x++;
                y--;
            }
            
            if(nav1.getHumanExistData() == gc.getHumanExistData()){return x;}
            else if(nav2.getHumanExistData() == gc.getHumanExistData()){return y;}
            else {return -1;}
        }
        return -1;
    }
    public static GenealogyChild findbyIndex(int loc){
        if(size > 0 && loc < size){
            int x = 0, y = size - 1;
            
            GenealogyChild nav1 = head.getNext();
            GenealogyChild nav2 = tail.getPrev();
            
            while(nav1 != nav2){
                if(x == loc){return nav1;}
                if(y == loc){return nav2;}
                
                nav1 = nav1.getNext();
                nav2 = nav2.getPrev();
                x++;
                y++;
            }
        }
        return null;
    }
    
    //Deletion
    public static void deletebyIndex(int loc) {
        GenealogyChild temp = findbyIndex(loc);

        if (temp != null) {
            temp.getNext().setPrev(temp.getPrev());
            temp.getPrev().setNext(temp.getNext());
        }
    }
    public static void deletebyValue(GenealogyChild gc){
        int Temp = findbyValue(gc);
        deletebyIndex(Temp);
    }
    
    //Printing to String
    public static void PrintList(){
        if(size > 0){
            GenealogyChild nav = head.getNext();
            while(nav != tail){
                System.out.print(nav.toString());
                nav = nav.getNext();
            }
        }
        System.out.println();
    }
    
    public static String toStringList(){
        String result = "";
        GenealogyChild current = head.getNext();
        while (current != null) {
            result += current.toString();
            current = current.getNext();
        }
        return result;
    }

    
    static String fileName = "genealogy_Israel.csv";

    public static void readFile(){
      try{
        String path = "C:\\Users\\Niel Patick\\Documents\\NetBeansProjects\\Genealogy_Israel\\src\\genealogy_israel\\genealogy_Israel.csv";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine(); // skip the first line
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String generation = parts[0];
            String father = parts[1];
            String allyearslived = parts[2];
            String yearsfromcreation = parts[3];
            HumanExistData newHumanExistData = new HumanExistData (generation, father, allyearslived, yearsfromcreation);
            GenealogyChild newGenealogyChild = new GenealogyChild(newHumanExistData);
            LinkedList.insert(newGenealogyChild);
        }
        reader.close();
    } catch (Exception e){
        JOptionPane.showMessageDialog(null, "Failed to read data from file!");
    }
   }

    public static void writeToFile(){
       try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("Generation,Father,All Years Lived,Year From Creation/n");

            if(size > 0){
                GenealogyChild nav = head.getNext();
                while(nav != tail){
                    fileWriter.write(nav.toString()+ "\n");
                    nav = nav.getNext();
                }
            }
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
   }
}
