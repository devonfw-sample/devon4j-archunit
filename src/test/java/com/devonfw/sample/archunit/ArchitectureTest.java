package com.devonfw.sample.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

/**
 * JUnit test that validates the architecture of this application.
 */
@AnalyzeClasses(packages = "com.devonfw.sample.archunit", importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchitectureTest {

  @ArchTest
  private final ArchRule avoidCyclDep = AvoidCyclicDependenciesTest.no_cyclic_dependencies_are_allowed;

  // Comp rules test
  @ArchTest
  private final ArchRule c1 = ComponentRuleTest.noComponentsServiceLayerDependsOnTheServiceLayerOfAnotherComponent;
  @ArchTest
  private final ArchRule c2 = ComponentRuleTest.noComponentsServiceLayerDependsOnTheLogicLayerOfAnotherComponent;
  @ArchTest
  private final ArchRule c3 = ComponentRuleTest.noComponentsLogicLayerDependsOnTheDataaccessLayerOfAnotherComponent;
  @ArchTest
  private final ArchRule c4 = ComponentRuleTest.noComponentsDataaccessLayerDependsOnTheDataaccessLayerOfAnotherComponent;
  @ArchTest
  private final ArchRule c5 = ComponentRuleTest.noComponentsBatchLayerDependsOnTheLogicLayerOfAnotherComponent;
  @ArchTest
  private final ArchRule c6 = ComponentRuleTest.theDefaultProjectComponentDoesNotDependOnAnyOtherComponent;

  // Layer rules test
  @ArchTest
  private final ArchRule layerRules = LayerRulesTest.shouldOnlyAccessValidLayers;

  // Naming conventions test
  @ArchTest
  private final ArchRule n1 = NamingConventionTest.N1DevonNamingConventionCtoCheck;
  @ArchTest
  private final ArchRule n2 = NamingConventionTest.N3DevonNamingConventionEntityCheck;
  @ArchTest
  private final ArchRule n3 = NamingConventionTest.N4DevonNamingConventionEtoCheck;
  @ArchTest
  private final ArchRule n4 = NamingConventionTest.DevonAbstractUcCheck;
  @ArchTest
  private final ArchRule n5 = NamingConventionTest.DevonMapperCheck;
  @ArchTest
  private final ArchRule n6 = NamingConventionTest.DevonPathCheck;
  @ArchTest
  private final ArchRule n7 = NamingConventionTest.DevonJpaRepositoryCheck;
  @ArchTest
  private final ArchRule n8 = NamingConventionTest.N5DevonNamingConventionUcCheck;

  // Package Rules
  @ArchTest
  private final ArchRule packageRule = PackageRuleTest.shouldHaveValidLayers;

  // Security Rules
  @ArchTest
  private final ArchRule security1 = SecurityTest.shouldBeProperlyAnnotated;
  @ArchTest
  private final ArchRule security2 = SecurityTest.shouldnTUseCreateQuery;

  // Third-Party Rules
  @ArchTest
  private final ArchRule thirdparty1 = ThirdPartyRulesTest.check_object_dependency;
  @ArchTest
  private final ArchRule thirdparty2 = ThirdPartyRulesTest.check_converter_dependency;
  @ArchTest
  private final ArchRule thirdparty3 = ThirdPartyRulesTest.check_mysema_dependency;
  @ArchTest
  private final ArchRule thirdparty4 = ThirdPartyRulesTest.verifyingSpringframeworkTransactionalIsNotUsed;
  @ArchTest
  private final ArchRule thirdparty5 = ThirdPartyRulesTest.verifyingProperTransactionalUseFromJee;
  @ArchTest
  private final ArchRule thirdparty6 = ThirdPartyRulesTest.verifyingProperJpaUse;
  @ArchTest
  private final ArchRule thirdparty7 = ThirdPartyRulesTest.jpaIsUsedAsEncouraged;

  /*
   * @ArchTest
   * private final ArchTests CYCLIC_DEPENDENCIES_TEST =
   * ArchTests.in(AvoidCyclicDependenciesTest.class);
   * 
   * @ArchTest
   * private final ArchTests COMPONENT_RULES =
   * ArchTests.in(ComponentRuleTest.class);
   * 
   * @ArchTest
   * private final ArchTests LAYER_RULES = ArchTests.in(LayerRulesTest.class);
   * 
   * @ArchTest
   * private final ArchTests NAMING_CONVENTION_RULES =
   * ArchTests.in(NamingConventionTest.class);
   * 
   * @ArchTest
   * private final ArchTests PACKAGE_RULES = ArchTests.in(PackageRuleTest.class);
   * 
   * @ArchTest
   * private final ArchTests SECURITY_RULES = ArchTests.in(SecurityTest.class);
   * 
   * @ArchTest
   * private final ArchTests THIRD_PARTY_RULES =
   * ArchTests.in(ThirdPartyRulesTest.class);
   */
}
