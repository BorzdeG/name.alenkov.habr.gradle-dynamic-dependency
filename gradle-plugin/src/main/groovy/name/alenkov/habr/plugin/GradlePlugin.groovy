package name.alenkov.habr.plugin

import org.gradle.api.Plugin
import org.gradle.api.internal.project.ProjectInternal

class GradlePlugin implements Plugin<ProjectInternal> {
    @Override
    void apply(ProjectInternal project) {
        project.logger.lifecycle('gradle plugin init (ver. 0)')
    }
}
