package com.kta.sample.archtest;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

//@AnalyzeClasses(packages = "${package.name}", importOptions = ImportOption.DoNotIncludeTests.class)
@AnalyzeClasses(packages = "com.kta.sample", importOptions = ImportOption.DoNotIncludeTests.class)
public class NamingConventionArchTest {

    @ArchTest
    private static final ArchRule arch_rule_naming_convention_constants = classes()
            .that().resideInAPackage("..constants..")
            .should().haveSimpleNameEndingWith("Constants");

    @ArchTest
    private static final ArchRule arch_rule_naming_convention_listener = classes()
            .that().resideInAPackage("..listener..")
            .should().haveSimpleNameEndingWith("Listener");

    @ArchTest
    private static final ArchRule arch_rule_naming_convention_service = classes()
            .that().resideInAPackage("..service")
            .should().beInterfaces()
            .andShould().haveSimpleNameEndingWith("Service");

    @ArchTest
    private static final ArchRule arch_rule_naming_convention_service_impl = classes()
            .that().resideInAPackage("..service.impl")
            .should().haveSimpleNameEndingWith("ServiceImpl");
}
