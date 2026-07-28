package com.kta.sample.archtest;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaConstructor;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;

//@AnalyzeClasses(packages = "${package.name}", importOptions = ImportOption.DoNotIncludeTests.class)
@AnalyzeClasses(packages = "com.kta.sample", importOptions = ImportOption.DoNotIncludeTests.class)
@ArchTag("constants")
public class ConstantsArchTest {

    // all fields should be public, static and final
    @ArchTest
    public static final ArchRule constants_must_be_public_static_final = fields()
            .that().areDeclaredInClassesThat().resideInAPackage("..constants..")
            .should().bePublic()
            .andShould().beStatic()
            .andShould().beFinal()
            .because("Constant classes must only contain public static final fields.");

    // the classes that are supposed to be Constants should not be private
    @ArchTest
    public static final ArchRule constants_classes_should_not_be_private = classes()
            .that().haveSimpleNameEndingWith("Constants")
            .should().notBePrivate();

    // constants classes should have a private constructor so they can only static invocations
    @ArchTest
    public static final ArchRule constants_classes_must_have_private_constructor = classes()
            .that().haveSimpleNameEndingWith("Constants")
            .should(new ArchCondition<JavaClass>("have a single private constructor") {
                @Override
                public void check(JavaClass javaClass, ConditionEvents events) {
                    for (JavaConstructor constructor : javaClass.getConstructors()) {
                        if (!constructor.getModifiers().contains(JavaModifier.PRIVATE)) {
                            events.add(SimpleConditionEvent.violated(constructor,
                                    javaClass.getName() + " constructor is not private"));
                        }
                    }
                }
            });
}
