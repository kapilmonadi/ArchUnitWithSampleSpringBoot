package com.kta.sample.archtest;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;
import org.slf4j.Logger;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

//@AnalyzeClasses(packages = "${package.name}", importOptions = ImportOption.DoNotIncludeTests.class)
@AnalyzeClasses(packages = "com.kta.sample", importOptions = ImportOption.DoNotIncludeTests.class)

public class LoggingArchTest {

    @ArchTest
    public static final ArchRule no_classes_should_log_onto_std_console = GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

    @ArchTest
    public static final ArchRule classes_must_use_slf4j_logging = noClasses()
            .should().dependOnClassesThat()
            .resideInAnyPackage("java.util.logging..", "org.apache.log4j..", "org.apache.logging.log4j..")
            .as("Loggers must use the SLF4J facade");

    @ArchTest
    public static final ArchRule logger_variable_rule = fields()
    .that().haveRawType(Logger.class)
    .should().bePrivate()
    .andShould().beStatic()
    .andShould().beFinal()
    .andShould().haveName("log")
    .as("Logger fields must be declared as 'private static final Logger log;'");
}
