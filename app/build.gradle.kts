plugins {
    java
}

// We need this only because of dynamic version which is not supported by plugins block
// Instead for plugin development we can use composite builds
// This block is not requires is plugin is included to the project in settings.gradle.kts
buildscript {
    repositories { mavenLocal() }
    dependencies {
        classpath("name.alenkov.habr.gradle-dynamic-dependency:gradle-plugin:+")
    }
}

plugins.apply("name.alenkov.habr.gradle-plugin")

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenLocal()
}

dependencies {
    compile(findProject (":ext-library")
        ?: module(group = "name.alenkov.habr.gradle-dynamic-dependency", name = "library", version = "+"))
}

