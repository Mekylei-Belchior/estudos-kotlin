plugins {
    kotlin("jvm") version "2.1.10"
}

group = "br.com.mekylei"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.12.0")
    implementation("org.postgresql:postgresql:42.7.5")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}