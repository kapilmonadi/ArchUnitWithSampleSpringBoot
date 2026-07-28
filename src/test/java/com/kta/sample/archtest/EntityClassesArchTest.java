package com.kta.sample.archtest;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

//@AnalyzeClasses(packages = "${package.name}", importOptions = ImportOption.DoNotIncludeTests.class)
@AnalyzeClasses(packages = "com.kta.sample", importOptions = ImportOption.DoNotIncludeTests.class)
public class EntityClassesArchTest {

    @ArchTest
    public static final ArchRule controllers_should_not_directly_access_entity_classes =  noClasses()
            .that().areMetaAnnotatedWith(RestController.class)
            .should().accessClassesThat()
            .areMetaAnnotatedWith(Entity.class)
            .because("Controllers should use DTOs instead of Entity classes");
}
