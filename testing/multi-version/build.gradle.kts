plugins {
    java
}

base {
    archivesName = "multi-version"
}
version = "1.0.0"

val testVersion = JavaVersion.toVersion(project.findProperty("testVersion") as String)

java {
    sourceCompatibility = testVersion
    targetCompatibility = testVersion
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(testVersion.majorVersion))
        vendor.set(JvmVendorSpec.AZUL)
    }
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

val removeLibs = tasks.register("removeLibs") {
    doLast {
        delete(fileTree("dir" to "build/libs", "include" to "**/*.jar"))
    }
}

tasks.jar {
    dependsOn(removeLibs)
}