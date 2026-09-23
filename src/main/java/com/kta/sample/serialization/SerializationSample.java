package com.kta.sample.serialization;

import com.kta.sample.dto.Employee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationSample {

    public static void main(String[] args) {

        Employee employee = new Employee(20L, "Kaps", "M");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.ser.file"))) {
            out.writeObject(employee);

            System.out.println("Object serialized successfully!");
            System.out.println("Serialized object: " + employee);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
