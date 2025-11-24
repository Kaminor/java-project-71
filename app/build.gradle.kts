plugins {
    id ("com.github.ben-manes.versions") version "0.52.0"
    application
    checkstyle
    id("org.sonarqube") version "6.2.0.5505"
}

application {
    mainClass = "hexlet.code.App"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
    implementation ("info.picocli:picocli:4.7.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.0")
    compileOnly ("org.projectlombok:lombok:1.18.32")
    annotationProcessor ("org.projectlombok:lombok:1.18.32")
    testCompileOnly ("org.projectlombok:lombok:1.18.32")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.32")
}

tasks.test {
    useJUnitPlatform()
}

sonar {
    properties {
        property("sonar.projectKey", "Kaminor_java-project-71")
        property("sonar.organization", "kaminor")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}