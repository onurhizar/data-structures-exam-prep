package datastructures.dictionary;

import datastructures.LinkedList;

public class HashMap {
    LinkedList<Student>[] database;
    int capacity; // a prime number is better as we use for modulo operation
    int DEFAULT_CAPACITY = 97;

    // Constructors
    public HashMap(){
        capacity = DEFAULT_CAPACITY;
        database = (LinkedList<Student>[]) new LinkedList[capacity];

    }
    public HashMap(int capacity) {
        this.capacity = capacity;
        database = (LinkedList<Student>[]) new LinkedList[capacity];
    }

    public void put(Student student){
        boolean studentExists = false;

        // 1: Get hash code
        int hashCode = hashCode(student.name);

        // 2: Compress with using modulo
        int compressedHash = hashCode % DEFAULT_CAPACITY;

        // 3: Check if LinkedList is initialized at database[index]
        LinkedList<Student> listAtIndex = database[compressedHash];
        if (listAtIndex == null) {
            listAtIndex = new LinkedList<>();
            database [compressedHash] = listAtIndex;
        }

        // 4: Add to LinkedList at given index
        if (listAtIndex.getLength() == 0) listAtIndex.add(student);
        else {
            // traverse to check if student already exists
            for (int i = 0; i < listAtIndex.getLength(); i++) {
                Student current = listAtIndex.get(i);
                if (current.name.equals(student.name)) {
                    studentExists = true;
                    current.grade = student.grade; // update its value
                }
            }
            if (!studentExists) listAtIndex.add(student);
        }
    }

    public Student get(String name){
        int hashCode = hashCode(name);
        int compressedHash = hashCode % DEFAULT_CAPACITY;
        LinkedList<Student> listAtIndex = database[compressedHash];

        if (listAtIndex!=null) { // if list is not empty, traverse
            for (int i = 0; i < listAtIndex.getLength(); i++) {
                Student current = listAtIndex.get(i);
                if (current.name.equals(name)) return current;
            }
        }
        return null;
    }

    public int hashCode(String nameKey){
        // also, you can use builtin hashCode method of Objects
        int hashValue = 0;
        char[] letters = nameKey.toCharArray();
        for (char letter: letters) {
            int asciiValue = Integer.valueOf(letter);
            hashValue += asciiValue;
            hashValue *= asciiValue;
        }
        return hashValue;
    }

    static class Student {
        String name; int grade;
        Student(String name, int grade)
        {this.name = name; this.grade=grade;}
    }

    public static void main(String[] args) {
        HashMap grades = new HashMap();
        Student stdOnur = new Student("Onur",90);
        Student stdBurak = new Student("Burak", 86);
        grades.put(stdOnur);
        grades.put(stdBurak);
        grades.put(new Student("Onur", 95)); // updates existing value
        System.out.println(grades.get("Onur").grade);
    }

}
