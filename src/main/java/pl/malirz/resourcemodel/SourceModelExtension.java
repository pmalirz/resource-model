package pl.malirz.resourcemodel;

import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.tasks.OutputDirectory;

abstract public class SourceModelExtension {
    abstract public Boolean getMergeProperties();
    abstract public RegularFileProperty getGeneratedFileDir();
}
