import java.text.SimpleDateFormat
import java.util.Date

plugins {
    id("groovy")
    idea
    `maven-publish`
    id("com.gradle.plugin-publish") version "0.9.7"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

group = "name.alenkov.habr.gradle-dynamic-dependency"

publishing {
    publications {
        register<MavenPublication>("mavenJava") {
            groupId = group.toString()

            version = SimpleDateFormat("yyyyMMddHHmm").format(Date())

            from(components["java"])
        }
    }
}

tasks {
    jar { baseName = "library" }
    publish { dependsOn(check) }
    publishPlugins { dependsOn(check) }
    publishToMavenLocal { dependsOn(check) }
}

dependencies {
    compile(gradleApi())

    testCompile(gradleTestKit())
}