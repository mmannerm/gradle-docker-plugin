package de.gesellix.gradle.docker.tasks

import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class DockerStopTask extends DockerTask {

  private static Logger logger = LoggerFactory.getLogger(DockerStopTask)

  @Input
  def containerId

  def result

  DockerStopTask() {
    description = "Stop a running container"
    group = "Docker"
  }

  @TaskAction
  def stop() {
    logger.info "docker stop"
    result = getDockerClient().stop(getContainerId())
    return result
  }
}
