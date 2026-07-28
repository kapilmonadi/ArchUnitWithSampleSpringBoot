package com.kta.sample.archtest;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

//@AnalyzeClasses(packages = "${package.name}", importOptions = ImportOption.DoNotIncludeTests.class)
@AnalyzeClasses(packages = "com.kta.sample", importOptions = ImportOption.DoNotIncludeTests.class)
public class UtilsArchTest {
    @ArchTest
    ArchRule arch_rule_only_static_methods_in_util_classes = methods().that().
            areDeclaredInClassesThat().resideInAPackage("..util..").
            should().beStatic();

    @ArchTest
    ArchRule classes_residing_in_utils_package_should_end_with_utils = classes()
            .that().resideInAPackage("..util..")
            .should().haveSimpleNameEndingWith("Utils");

}
