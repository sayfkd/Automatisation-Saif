FROM selenium/standalone-chrome
USER root
RUN apt update && apt install -y maven
USER seluser  # Switch back to non-root user
