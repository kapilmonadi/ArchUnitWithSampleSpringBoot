package com.kta.sample.serialization;

import com.kta.sample.dto.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationSample {
    public static void main(String[] args) {

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream("employee.ser.file"))) {

            Employee employee = (Employee) in.readObject();

            System.out.println("Object deserialized successfully!");
            System.out.println("Deserialized object: " + employee);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
