package com.kta.sample.serialization;

import com.kta.sample.dto.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class DeSerializationSample {
    public static void main(String[] args) {

        deSerializeObject("employee1.ser.file"); // serialVersionUID = 1
        deSerializeObject("employee2.ser.file"); // serialVersionUID = 2
        printSerialVersionUID();
    }

    private static void deSerializeObject(String fileName) {
        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream(fileName))) {

            Employee employee1 = (Employee) in.readObject();

            System.out.println("Object deserialized successfully!");
            System.out.println("Deserialized object: " + employee1);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
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
