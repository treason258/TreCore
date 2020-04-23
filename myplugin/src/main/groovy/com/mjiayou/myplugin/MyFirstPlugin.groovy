package com.mjiayou.myplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

public class MyFirstPlugin implements Plugin<Project> {

    void apply(Project project) {
        log("******************************** apply-start ********************************");
        log("Hello MyFirstPlugin 1.0.9")
        log("******************************** apply-end ********************************");

        project.android.registerTransform(new MyFirstTransform(project))
    }

    private void log(String msg) {
        System.out.println("matengfei888 | MyFirstPlugin | " + msg);
    }
}