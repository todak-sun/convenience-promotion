plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    id("org.springframework.boot")
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
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}

//allOpen {
//    annotation("javax.persistence.Entity")
//    annotation("javax.persistence.MappedSuperclass")
//}
//
//noArg {
//    annotation("javax.persistence.Entity")
//}

//plugins {
//    id("org.springframework.boot") version "2.7.2"
//    id("io.spring.dependency-management") version "1.0.12.RELEASE"
//    kotlin("jvm")
//    kotlin("plugin.spring") version "1.6.21"
//    kotlin("plugin.jpa") version "1.6.21"
//
//}
//
//version = "0.0.1-SNAPSHOT"
//
//
//configurations {
//    compileOnly {
//        extendsFrom(configurations.annotationProcessor.get())
//    }
//}
//
//repositories {
//    mavenCentral()
//}
//
//extra["testcontainersVersion"] = "1.17.3"
//
//dependencies {
//
//    implementation("org.springframework.boot:spring-boot-starter")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("org.testcontainers:junit-jupiter")
//    testImplementation("org.testcontainers:postgresql")
//}
//
//dependencyManagement {
//    imports {
//        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
//    }
//}
//
//tasks.withType<KotlinCompile> {
//    kotlinOptions {
//        freeCompilerArgs = listOf("-Xjsr305=strict")
//        jvmTarget = "17"
//    }
//}
//
//tasks.withType<Test> {
//    useJUnitPlatform()
//}
//
//tasks.getByName<BootJar>("bootJar") {
//    enabled = false
//}
//
//tasks.getByName<Jar>("jar") {
//    enabled = true
//}

