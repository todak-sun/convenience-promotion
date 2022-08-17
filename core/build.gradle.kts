plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    kotlin("kapt")
}

version = "0.0.1-SNAPSHOT"

extra["testcontainersVersion"] = "1.17.3"

tasks.jar {
    enabled = true
}

tasks.bootJar {
    enabled = false
}

dependencies {
    val querydslVersion = "5.0.0"


    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    api("com.querydsl:querydsl-jpa:$querydslVersion")
    kapt("com.querydsl:querydsl-apt:$querydslVersion:jpa")
    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}