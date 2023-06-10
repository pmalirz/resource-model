package pl.malirz.resourcemodel;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;

public abstract class ResourceModelGeneratorTask extends DefaultTask {

    @OutputDirectory
    abstract RegularFileProperty getGeneratedFileDir();

    public ResourceModelGeneratorTask() {
        super();
    }

    @TaskAction
    public void generateResourceModel() {
        System.out.println("ResourceModelGeneratorTask.generate()");
    }

}
