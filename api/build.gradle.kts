plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
//    kotlin("plugin.jpa") version "1.6.21"
//    kotlin("kapt") //version "1.7.10" // QueryDSL
}

version = "0.0.1-SNAPSHOT"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

//val querydslVersion = "5.0.0"

extra["testcontainersVersion"] = "1.17.3"

dependencies {
    implementation(project(":core"))

    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.querydsl:querydsl-jpa")

//    api("com.querydsl:querydsl-jpa")
//    kapt("com.querydsl:querydsl-apt")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    runtimeOnly("org.postgresql:postgresql")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}



//sourceSets.main {
//    withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
//        kotlin.srcDir("$buildDir/generated/source/kapt/main")
//    }
//}

//compile("com.querydsl:querydsl-jpa:${queryDslVersion}")
//
//kotlin.sourceSets.main {
//    setBuildDir("$buildDir/generated/source/kapt/main")
//}

