package com.kta.sample.serialization;

import com.kta.sample.dto.Employee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationSample {

    public static void main(String[] args) {

        // version 1
        Employee employee1 = new Employee(20L, "Kaps", "M");

        // version 2
        //Employee employee2 = new Employee(30L, "Abhi", "K", "abhi@kta.com");


        //Serialize employee 1

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee1.ser.file"))) {
            out.writeObject(employee1);

            System.out.println("Object serialized successfully!");
            System.out.println("Serialized object: " + employee1);

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        //Serialize employee 2

        /*try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee2.ser.file"))) {
            out.writeObject(employee2);

            System.out.println("Object employee 2 serialized successfully!");
            System.out.println("Serialized object: " + employee2);

        } catch (IOException exception) {
            exception.printStackTrace();
        }*/
    }
}
