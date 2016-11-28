# NB-SpringBoot

NetBeans IDE plugin supporting programming with [Spring Boot](http://projects.spring.io/spring-boot).


## Requirements and Installation

This plugin requires **NetBeans 8.1** or above running on **JDK 7** or above.

The plugin is available in the *Plugin Portal Update Center* thus it can be downloaded and installed trough *Tools > Plugins > Available Plugins*.

Alternatively download the desired `nbm` package from https://github.com/AlexFalappa/nb-springboot/releases , go to *Tools > Plugins > Downloaded* and click on *Add Plugins...* button. Choose the downloaded `nbm` package file then click *Install*.

## Features

* New _Spring Boot_ Maven project wizards:
    * Basic project
    * Project generated by _Spring Initializr_ service
* Enhanced properties file editor:
    * completion and documentation of configuration properties names
    * completion and documentation of configuration properties values (`hints` in configuration metadata)
* _Spring Boot_ file templates:
    * `CommandlineRunner` annotated classes
    * `ApplicationRunner` annotated classes
    * `application.properties` files
    * `ConfigurationProperties` annotated classes
    * `additional-spring-configuration-metadata.json` files
* Additional _Spring Framework_ file templates:
    * `Component` annotated classes
    * `Configuration` annotated classes
    * `Service` annotated classes
    * `Controller` annotated classes (Spring MVC)
    * `RestController` annotated classes (Spring MVC)
    * interfaces extending `Repository` (Spring Data)
* Additional code generators in `pom.xml` files:
    * Add spring configuration processor dependency
    * Add `spring-devtools` dependency
    * Add `spring-actuator` dependency
* Toolbar button to trigger _Spring Boot_ devtools reload
* Specific _Spring Boot_ project properties page to:
    * Specify command line run arguments
    * Enable/disable devtools reload trigger
* Additional navigator panel to show request URL mappings of a `Controller` / `RestController` class

## Issues and Documentation

Bug tracking: [GitHub Issues](https://github.com/AlexFalappa/nb-springboot/issues)

Documentation: [GitHub Wiki](https://github.com/AlexFalappa/nb-springboot/wiki)


## License

The plugin and its source code are licensed under [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0).


## Acknowledgements

Completion of Spring Boot configuration properties feature is based on [Keevosh plugin](https://github.com/keevosh/nb-springboot-configuration-support).

Template and code generator were inspired by those found on [Spring Boot Tools 4 NetBeans](https://github.com/GeertjanWielenga/SpringBootTools4NetBeans).

Requestmappings navigator panel feature contributed by [Michael Simons](https://github.com/michael-simons).

## Changelog

* __WIP__ (??? 2016): Work in Progress
    * File templates ignored a per project custom license
    * Reload action renamed to restart and shorcut changed to avoid conflict with new *Paste as Lines* command in editor multicaret
    * Visual improvements to request mappings navigator panel
    * Properly handle `Ctrl + Enter` configuration properties completion to overwrite the current property name
    * Initializr project wizard: removed option to add Spring Boot configuration processor as now it can be chosen in the Dependencies page and checked by default the 'Run/Debug with spring boot maven plugin' option

* __1.3__ (October 2016): Devtools and request mappings
    * Upgrade to Spring Boot version 1.4.1
    * Action to trigger devtools reload (trough toolbar button or `Ctrl + Shift + L` keyboard shortcut)
    * Spring boot dedicated panel in project properties dialog for specifying command line arguments and enabling devtools reload trigger
    * Moved some file templates to the default *Spring Framework* category
    * Navigator panel showing request URL mappings of a `Controller` / `RestController` class (contribution by [Michael Simons](http://michael-simons.eu))
    * [List of closed issues](https://github.com/AlexFalappa/nb-springboot/milestone/5?closed=1)

* __1.2__ (August 2016): File templates improvements
    * Upgrade to Spring Boot version 1.4
    * The file templates wizards that generate Java classes now use the standard NetBeans widgets (better name proposal, choice of source/test location and destination package)
    * The wizards for `application.properties` files, additional configuration metadata and Spring Data repository interfaces now offer specific customization options
    * The file templates are now shown only if the relevant dependencies are present (e.g. REST Controller Class is shown only if there is a dependency on spring-boot-starter-web)
    * Devtools restart and reload now work when the project is run/debugged trough the spring maven plugin
    * Fixed some UI glitches
    * Enhanced Controller and RestController templates
    * [List of closed issues](https://github.com/AlexFalappa/nb-springboot/milestone/4?closed=1)

* __1.1__ (June 2016): Refinements
    * Added missing `@Component` annotation to CommandLineRunner and ApplicationRunner file templates
    * No more NetBeans module implementation dependencies, this allows the plugin to be available from the Update Center
    * Improvements to New project wizard Spring Boot project (from Initializr):
        * Asynchronous querying of the web service
        * More paramenter validation
        * Filtering of dependencies
        * Show required boot version in tooltips of disabled dependencies
        * Options to remove the maven wrapper, add the spring configuration processor dependency and run/debug trough the maven spring plugin
    * [List of closed issues](https://github.com/AlexFalappa/nb-springboot/milestone/3?closed=1)

* __1.0__ (May 2016): Initial public release
