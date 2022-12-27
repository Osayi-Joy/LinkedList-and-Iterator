package org.example;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        //  LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add(0,"Camnberra");
        System.out.println(placesToVisit);

        addMore(placesToVisit);
        System.out.println(placesToVisit);
//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

        gettingElements(placesToVisit);
        //printItinerary(placesToVisit);
        //printItinerary2(placesToVisit);
        printItinerary3(placesToVisit);
        testIterator(placesToVisit);

    }

    public static void addMore(LinkedList<String> list){
        list.addFirst("Darwin");
        list.addLast("Hobart");

        //Queue Methods
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowomba");

        //Stack Methods
        list.push("Alice Springs");
    }

    public static void removeElements(LinkedList<String> list){
        list.remove(4);
        list.remove("Brisbane");
        System.out.println(list);
        String s1 = list.remove(); //removes first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst(); //removes first element
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast(); //removes last element
        System.out.println(s3 + " was removed");

        //Queue/Deque poll methods
        String p1 = list.poll(); //removes first element
        System.out.println(p1 + "was removed");

        String p2 = list.pollFirst(); //removes first element
        System.out.println(p2 + "was removed");

        String p3 = list.pollLast(); //removes last element
        System.out.println(p3 + "was removed");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        String p4 = list.pop(); //removes last elements
        System.out.println(p4 + " was removed");

    }

    public static void gettingElements(LinkedList<String> list){
        System.out.println("Retrieved Element = " + list.get(4));
        System.out.println("first element = " + list.getFirst());
        System.out.println("last element = " + list.getLast());
        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " + list.lastIndexOf("Melbourne"));

        //Queue retrieval method
        System.out.println("Element from element() = " + list.element());
        //Stack retreival methods
        System.out.println("Element from peek() = " + list.peek());
        System.out.println("Element from peekFirst() = " + list.peekFirst());
        System.out.println("Element from peekLast() = " + list.peekLast());
    }

    public static void printItinerary(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        for(int i = 1; i < list.size(); i++){
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        String PreviousTown = list.getFirst();
        for(String town: list) {
            System.out.println("--> From: " + PreviousTown + " to " + town);
            PreviousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary3(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        String PreviousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while(iterator.hasNext()){
            var town = iterator.next();
            System.out.println("--> From: " + PreviousTown + " to " + town);
            PreviousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list){
        var iterator = list.listIterator();
        while(iterator.hasNext()){
            //System.out.println(iterator.next());
            if(iterator.next().equals("Brisbane")){
                iterator.add("Lake Wivenhoe");
            }
        }
         while(iterator.hasPrevious()){
            System.out.println(iterator.previous()                                                                                                                                                                                       );
        }

        System.out.println(list);
    }


}
