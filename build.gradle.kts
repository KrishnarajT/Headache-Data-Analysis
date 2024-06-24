plugins {
    id("java")
}

group = "org.krishnaraj"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.jfree:jfreechart:1.5.3")
    implementation("org.apache.commons:commons-csv:1.9.0")
}

tasks.test {
    useJUnitPlatform()
}