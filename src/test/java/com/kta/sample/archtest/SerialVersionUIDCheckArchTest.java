package com.kta.sample.archtest;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaField;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.io.Serializable;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.kta.sample", importOptions = ImportOption.DoNotIncludeTests.class)
public class SerialVersionUIDCheckArchTest {

    private static class ValidSerialVersionUIDArchCondition extends ArchCondition<JavaClass> {

        public ValidSerialVersionUIDArchCondition() {
            super(" Has a valid serial version UID");
        }

        @Override
        public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
            String message = String.format("Class %s implements Serializable but lacks a valid serialVersionUID", javaClass.getName());
            try {
                JavaField field = javaClass.getField("serialVersionUID");
                boolean isSerialVersionUIDFieldPresent = field.getModifiers().contains(JavaModifier.STATIC)
                        && field.getModifiers().contains(JavaModifier.FINAL)
                        && field.getRawType().isEquivalentTo(long.class);

                conditionEvents.add(new SimpleConditionEvent(javaClass, isSerialVersionUIDFieldPresent, message));

            }
            catch(Exception exception) {
                conditionEvents.add(SimpleConditionEvent.violated(javaClass, message));
            }
        }
    }

    @ArchTest
   public static final ArchRule serial_version_uid_check_rule = classes()
            .that().implement(Serializable.class)
            .and().areNotInterfaces()
            .should(new ValidSerialVersionUIDArchCondition());
}
