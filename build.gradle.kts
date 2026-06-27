plugins {
    id("java")
    application
}

group = "org.dkbrazz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

val mockitoAgent: Configuration by configurations.creating {
    isTransitive = false
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:5.22.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.22.0")
    mockitoAgent("org.mockito:mockito-core:5.22.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass.set("org.dkbrazz.Main")
}

tasks.test {
    useJUnitPlatform()
    jvmArgumentProviders.add(CommandLineArgumentProvider {
        listOf("-javaagent:${mockitoAgent.singleFile.absolutePath}")
    })
}