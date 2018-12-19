val extDir = rootDir
if (extDir.exists()) {
    extDir.listFiles().filter { it.isDirectory }.forEach { dir ->
        if (File(dir, "build.gradle").exists() || File(dir, "build.gradle.kts").exists()) {
            logger.trace("found ext plugin: " + dir.name)

            val prjName = ":${dir.name}"
            logger.lifecycle("include ext plugin: $prjName")
            include(prjName)
            project(prjName).projectDir = dir
            project(prjName).name = "ext-plugin-${dir.name}"
        }
    }
}
