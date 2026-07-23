package com.kta.sample.archtest;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

//@AnalyzeClasses(packages = "${package.name}", importOptions = ImportOption.DoNotIncludeTests.class)
@AnalyzeClasses(packages = "com.kta.sample", importOptions = ImportOption.DoNotIncludeTests.class)
@ArchTag("exception")
public class ExceptionsArchTest {
    @ArchTest
    private static final ArchRule no_generic_exceptions_should_be_thrown = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS
            .because("It is not a good practice. Always define and throw custom exceptions within the application !");
}
