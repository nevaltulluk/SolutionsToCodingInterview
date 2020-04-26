import java.net.SocketPermission;
import java.util.LinkedList;

public class AnimalShelter{
    LinkedList<Integer> dogs;
    LinkedList<Integer> cats;
    int animalID;
    public AnimalShelter(){
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        animalID = 0;
    }
    public void enqueue( String type){
        this.animalID ++;
        if(type.toLowerCase().equals("cat")){
            cats.add(animalID);
        }
        else if(type.toLowerCase().equals("dog")){
            dogs.add(animalID);
        }
        else{
            animalID --;
            System.out.println("only cats or dogs");
        }
    }
    public int dequeue(){
        if(cats.isEmpty() && dogs.isEmpty()){
            animalID = 0;
            System.out.println("Shelter is empty");
            return 0;
        }
        else if(cats.isEmpty()){
            return dogs.getFirst();
        }
        else if(dogs.isEmpty()){
            return cats.getFirst();
        }
        else{
            return Math.min(dogs.getFirst(),cats.getFirst());
        }

    }
    public int dequeueCat(){
        if(cats.isEmpty()){
            return 0;
        }
        return cats.getFirst();
    }
    public int dequeueDog(){
        if(dogs.isEmpty()){
            return 0;
        }
        return dogs.getFirst();
    }
}