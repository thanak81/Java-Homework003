FROM openjdk:21
# Install Maven using another package manager if needed, or download manually
RUN apt-get update && \
    apt-get install -y wget && \
    wget http://www-us.apache.org/dist/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.tar.gz && \
    tar -xzf apache-maven-3.8.6-bin.tar.gz -C /opt && \
    ln -s /opt/apache-maven-3.8.6 /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /opt/maven
ENV PATH $MAVEN_HOME/bin:$PATH
CMD ["bash"]