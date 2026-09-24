package com.kta.sample.serialization;

import com.kta.sample.dto.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationSample {
    public static void main(String[] args) {

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream("employee1.ser.file"))) {

            Employee employee1 = (Employee) in.readObject();

            System.out.println("Object deserialized successfully!");
            System.out.println("Deserialized object: " + employee1);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream("employee2.ser.file"))) {

            Employee employee2 = (Employee) in.readObject();

            System.out.println("Object deserialized successfully!");
            System.out.println("Deserialized object: " + employee2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
