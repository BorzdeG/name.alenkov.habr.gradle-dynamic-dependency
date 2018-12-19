import java.text.SimpleDateFormat
import java.util.Date

plugins {
    java
    `maven-publish`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    publications {
        register<MavenPublication>("mavenJava") {
            groupId = "name.alenkov.habr.gradle-dynamic-dependency"
            version = SimpleDateFormat("yyyyMMddHHmm").format(Date())
            from(components["java"])
        }
    }
}

tasks {
    val demoTask by registering {
        doLast {
            logger.lifecycle("demo task")
        }
    }

    jar {
        dependsOn(demoTask)
        baseName = "library"
    }
}
