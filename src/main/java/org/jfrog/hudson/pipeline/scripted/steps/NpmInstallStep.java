package org.jfrog.hudson.pipeline.scripted.steps;

import hudson.Extension;
import org.jenkinsci.plugins.workflow.steps.AbstractStepDescriptorImpl;
import org.jfrog.hudson.pipeline.common.types.buildInfo.BuildInfo;
import org.jfrog.hudson.pipeline.common.types.builds.NpmBuild;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Created by Yahav Itzhak on 25 Nov 2018.
 */
@SuppressWarnings("unused")
public class NpmInstallStep extends NpmInstallCiStepBase {

    @DataBoundConstructor
    public NpmInstallStep(BuildInfo buildInfo, NpmBuild npmBuild, String javaArgs, String path, String args, String module) {
        super(buildInfo, npmBuild, javaArgs, path, args, module, false);
    }

    @Extension
    public static final class DescriptorImpl extends AbstractStepDescriptorImpl {

        public DescriptorImpl() {
            super(NpmInstallStep.Execution.class);
        }

        @Override
        public String getFunctionName() {
            return "artifactoryNpmInstall";
        }

        @Override
        public String getDisplayName() {
            return "Run Artifactory npm install";
        }

        @Override
        public boolean isAdvanced() {
            return true;
        }
    }
}
