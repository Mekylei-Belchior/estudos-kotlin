plugins {
    kotlin("jvm") version "2.1.10"
    id("org.hibernate.orm") version "6.6.15.Final"
}

group = "br.com.mekylei"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.12.0")
    implementation("org.postgresql:postgresql:42.7.5")
    implementation("org.hibernate.orm:hibernate-core:6.6.15.Final")
    testImplementation(kotlin("test"))
}

hibernate {
    enhancement {
        enableLazyInitialization.set(true)
        enableDirtyTracking.set(true)
        enableAssociationManagement.set(true)
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}