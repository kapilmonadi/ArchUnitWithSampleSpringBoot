package com.kta.sample.archtest;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

//@AnalyzeClasses(packages = "${package.name}", importOptions = ImportOption.DoNotIncludeTests.class)
@AnalyzeClasses(packages = "com.kta.sample", importOptions = ImportOption.DoNotIncludeTests.class)
@ArchTag("layered")
public class LayeredArchTest {

    private static final ArchRule arch_rule_layered_strucoture_for_rest_api =
            Architectures.layeredArchitecture().consideringAllDependencies()
                    .layer("Controller").definedBy("..controller..")
                    .layer("Facade").definedBy("..facade..")
                    .layer("Service").definedBy("..service..")
                    .layer("DAO").definedBy("..dao..")
                    .layer("repository").definedBy("..repository..")
                    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller, Facade")
                    .whereLayer("DAO").mayOnlyBeAccessedByLayers("Service")
                    .whereLayer("Repository").mayOnlyBeAccessedByLayers("DAO", "Service");

}
