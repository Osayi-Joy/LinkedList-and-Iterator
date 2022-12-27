package org.example;

import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance){
    @Override
    public String toString(){
        return String.format("%s (%d)", name, distance);
    }

}
public class LinkedListChallenge {


    public static void main(String[] args) {
        LinkedList<Place> placeLinkedList = new LinkedList<>();
        Place adelaide = new Place("Adelaide", 1374);
        addPlace(placeLinkedList, adelaide);
        addPlace(placeLinkedList, new Place("Adelaide", 1374));
        addPlace(placeLinkedList, new Place("Brisbane", 917));
        addPlace(placeLinkedList, new Place("Perth", 3923));
        addPlace(placeLinkedList, new Place("Alice Springs", 2771));
        addPlace(placeLinkedList, new Place("Darwin", 3972));
        addPlace(placeLinkedList, new Place("Melbourne", 877));
        System.out.println(placeLinkedList);

        var iterator = placeLinkedList.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;
        printMenu();
        while ((!quitLoop)){
            if(!iterator.hasPrevious()){
                System.out.println("Originating : " + iterator.next());
                forward = true;
            }
            if(!iterator.hasNext()){
                System.out.println("final : " + iterator.previous());
                forward = false;
            }
            System.out.println("Enter Value: ");
            String menuItem = scanner.nextLine().toUpperCase().substring(0,1);
            switch (menuItem){
                case "F":
                    System.out.println("User wants to forward");
                    if(!forward){   //Reversing Direction
                        forward = true;
                        if(iterator.hasNext()){
                            iterator.next();    //Adjust position forward
                        }
                    }
                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    break;
                case "B":
                    System.out.println("User wants to backwards");
                    if(forward){   //Reversing Direction
                        forward = false;
                        if(iterator.hasPrevious()){
                            iterator.previous();    //Adjust position backwards
                        }
                    }
                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                    break;
                case "M":
                    printMenu();
                    break;
                case "L":
                    System.out.println(placeLinkedList);
                    break;
                default:
                    quitLoop = true;
                    break;
            }
        }
    }



    private static void addPlace(LinkedList<Place> list, Place place){
        if(list.contains(place)){
            System.out.println("Found duplicate: " + place);
            return;
        }

        for(Place p: list){
            if(p.name().equalsIgnoreCase(place.name())){
                System.out.println("Found duplicate: " + place);
                return;
            }
        }
        int matchedIndex = 0;
        for(var listPlace: list){
            if(place.distance() < listPlace.distance()) {
                list.add(matchedIndex, place);
                return;
            }
            matchedIndex++;
        }

        list.add(place);
    }

    private static void printMenu(){
        System.out.println("""
                Availble actions (select word or letter):
                (F)orward
                (B)ackwords
                (L)ist Places
                (M)enu
                (Q)uit""");
    }



}
