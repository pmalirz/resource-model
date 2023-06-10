package pl.malirz.resourcemodel;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class SourceModelPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        final SourceModelExtension sourceModelExtension =
            project.getExtensions().create("sourceModelExtension", SourceModelExtension.class);

        project.getTasks()
            .register("generateResourceModel", ResourceModelGeneratorTask.class, task -> {
                task.getGeneratedFileDir().set(sourceModelExtension.getGeneratedFileDir());
            });
    }

}
