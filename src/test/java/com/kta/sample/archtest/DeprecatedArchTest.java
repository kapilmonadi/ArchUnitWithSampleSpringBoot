package com.kta.sample.archtest;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

//@AnalyzeClasses(packages = "${package.name}", importOptions = ImportOption.DoNotIncludeTests.class)
@AnalyzeClasses(packages = "com.kta.sample", importOptions = ImportOption.DoNotIncludeTests.class)
public class DeprecatedArchTest {

    @ArchTest
    // @ArchIgnore to skip running the arch rule
    private static final ArchRule arch_rule_classes_annotated_as_deprecated_should_not_be_used = noClasses()
            .should().dependOnClassesThat().areAnnotatedWith(Deprecated.class)
            .because("Deprecated classes will be removed in the upcoming releases.");

    @ArchTest
    // @ArchIgnore to skip running the arch rule
    private static final ArchRule arch_rule_methods_annotated_as_deprecated_should_not_be_used = GeneralCodingRules.DEPRECATED_API_SHOULD_NOT_BE_USED;

}
