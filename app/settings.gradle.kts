rootProject.name = "app"

val extDir = File(rootDir, "ext")
if (extDir.exists()) {
    extDir.listFiles().filter { it.isDirectory }.forEach { dir ->
        if (File(dir, "build.gradle.kts").exists() || File(dir, "build.gradle").exists()) {
            logger.trace("found ext module: " + dir.name)

            val prjName = ":${dir.name}"
            logger.lifecycle("include ext project: $prjName")
            include(prjName)
            project(prjName).projectDir = dir
            project(prjName).name = "ext-${dir.name}"
        }
    }
}

