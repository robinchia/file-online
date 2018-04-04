package com.venustech.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author robin(贾永伟)
 * @PackgeName: com.venustech.config
 * @Description: 请添加描述...
 * @date 18-4-2 13:21
 */
@ConfigurationProperties("jodconverter")
public class JodConverterProperties {
    private boolean enabled;
    private String officeHome;
    private String portNumbers = "2002";
    private String workingDir;
    private String templateProfileDir;
    private boolean killExistingProcess = true;
    private long processTimeout = 120000L;
    private long processRetryInterval = 250L;
    private long taskExecutionTimeout = 120000L;
    private int maxTasksPerProcess = 200;
    private long taskQueueTimeout = 30000L;

    public JodConverterProperties() {
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getOfficeHome() {
        return this.officeHome;
    }

    public void setOfficeHome(String officeHome) {
        this.officeHome = officeHome;
    }

    public String getPortNumbers() {
        return this.portNumbers;
    }

    public void setPortNumbers(String portNumbers) {
        this.portNumbers = portNumbers;
    }

    public String getWorkingDir() {
        return this.workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    public String getTemplateProfileDir() {
        return this.templateProfileDir;
    }

    public void setTemplateProfileDir(String templateProfileDir) {
        this.templateProfileDir = templateProfileDir;
    }

    public boolean isKillExistingProcess() {
        return this.killExistingProcess;
    }

    public void setKillExistingProcess(boolean killExistingProcess) {
        this.killExistingProcess = killExistingProcess;
    }

    public long getProcessTimeout() {
        return this.processTimeout;
    }

    public void setProcessTimeout(long processTimeout) {
        this.processTimeout = processTimeout;
    }

    public long getProcessRetryInterval() {
        return this.processRetryInterval;
    }

    public void setProcessRetryInterval(long procesRetryInterval) {
        this.processRetryInterval = procesRetryInterval;
    }

    public long getTaskExecutionTimeout() {
        return this.taskExecutionTimeout;
    }

    public void setTaskExecutionTimeout(long taskExecutionTimeout) {
        this.taskExecutionTimeout = taskExecutionTimeout;
    }

    public int getMaxTasksPerProcess() {
        return this.maxTasksPerProcess;
    }

    public void setMaxTasksPerProcess(int maxTasksPerProcess) {
        this.maxTasksPerProcess = maxTasksPerProcess;
    }

    public long getTaskQueueTimeout() {
        return this.taskQueueTimeout;
    }

    public void setTaskQueueTimeout(long taskQueueTimeout) {
        this.taskQueueTimeout = taskQueueTimeout;
    }
}