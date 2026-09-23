package com.kta.sample.archtest;

import com.kta.sample.annotations.AppListener;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.core.domain.JavaMethodCall;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(packages = "com.kta.sample", importOptions = ImportOption.DoNotIncludeTests.class)
@ArchTag("listener")
public class ListenerArchTest {

    @ArchTest
    public static final ArchRule methods_annotated_with_listener_must_have_log_statements = methods()
            .that().areAnnotatedWith(AppListener.class)
            .should(callALogger())
            .as("Critical APIs should log events");

    private static ArchCondition<JavaMethod> callALogger() {
        return new ArchCondition<>("Calling a Logger") {
            @Override
            public void check(JavaMethod method, ConditionEvents events) {
                // Analyzes bytecode to find calls to SLF4J Logger
                boolean callsLogger = method.getMethodCallsFromSelf().stream()
                        .map(JavaMethodCall::getTargetOwner)
                        .anyMatch(targetClass -> targetClass.isAssignableTo("org.slf4j.Logger"));

                if (!callsLogger) {
                    String message = String.format("Method %s.%s() does not use logging",
                            method.getOwner().getName(), method.getName());
                    events.add(SimpleConditionEvent.violated(method, message));
                }
            }
        };
    }
}
