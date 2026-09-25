package com.kta.sample.serialization;

import com.kta.sample.dto.Employee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

public class SerializationSample {

    public static void main(String[] args) {

        // version 1
        Employee employee1 = new Employee(20L, "Kaps", "M");
        //serializeObject(employee1, "employee1.ser.file");

        // version 2
        Employee employee2 = new Employee(30L, "Abhi", "K", "abhi@kta.com");
        serializeObject(employee2, "employee2.ser.file");

        // 8805629431670312713L  //serialization
        // 8805629431670312713L // deserialization

        //7121360786091773561L

        printSerialVersionUID();
    }

    private static void serializeObject(Employee employee, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(employee);

            System.out.println("Object serialized successfully!");
            System.out.println("Serialized object: " + employee);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void printSerialVersionUID() {
        ObjectStreamClass osc = ObjectStreamClass.lookup(Employee.class);
        if (osc != null) {
            long uid = osc.getSerialVersionUID();
            System.out.println("serialVersionUID: " + uid + "L");
        } else {
            System.out.println("Class is not serializable.");
        }
    }
}
