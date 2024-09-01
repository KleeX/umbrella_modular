enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TestApp"
include(":app")
//include(":shared")
include(":datasources")
include(":repositories")
include(":api")
include(":repositories_impl")
include(":usecases")
include(":usecases_impl")
include(":test_feature")
include(":storage")
include(":data")
