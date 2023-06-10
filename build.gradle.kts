plugins {
    `java-gradle-plugin`
    `maven-publish`
    `groovy`
    id("pl.malirz.intest")
}

group = "pl.malirz"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation("com.github.javaparser:javaparser-core:3.25.3")
    implementation("com.github.javaparser:javaparser-core-serialization:3.25.3")

    // groovy 4 and spock 2
    testImplementation("org.spockframework:spock-core:2.3-groovy-3.0")
    //testImplementation("org.apache.groovy:groovy-all:4.0.12")

    // junit
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.getByName<Test>("intest") {
    dependsOn("test")
    shouldRunAfter("test")
    useJUnitPlatform()
}

gradlePlugin {
    plugins {
        create("resourcemodelPlugin") {
            id = "pl.malirz.resource-model"
            displayName = "Resource Model Plugin"
            description = "Generates types safe classes from resources"
            tags.set(listOf("source", "generator", "model", "type-safe"))
            implementationClass = "pl.malirz.resourcemodel.SourceModelPlugin"
        }
    }
}