import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.9.20"
    id("com.google.protobuf") version "0.9.4"
    id("build.buf") version "0.8.6"
}

repositories {
    mavenCentral()
}

val protobufVersion = "3.25.1"

dependencies {
    implementation("com.google.protobuf:protobuf-kotlin:$protobufVersion")
}

java.sourceCompatibility = JavaVersion.VERSION_11

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
            apiVersion = "1.6"
            languageVersion = "1.6"
        }
    }

    test {
        useJUnitPlatform()
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }

    generateProtoTasks {
        all().configureEach {
            builtins {
                create("kotlin")
            }
        }
    }
}
