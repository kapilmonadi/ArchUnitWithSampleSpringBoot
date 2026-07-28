package com.kta.sample.archtest;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.http.ResponseEntity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

//@AnalyzeClasses(packages = "${package.name}", importOptions = ImportOption.DoNotIncludeTests.class)
@AnalyzeClasses(packages = "com.kta.sample", importOptions = ImportOption.DoNotIncludeTests.class)
public class ReturnTypeArchTest {

    @ArchTest
    ArchRule return_type_for_controllers_should_be_response_entity = methods()
            .that().arePublic()
            .and().areDeclaredInClassesThat()
            .resideInAPackage("..controller..")
            .should().haveRawReturnType(ResponseEntity.class);
}
