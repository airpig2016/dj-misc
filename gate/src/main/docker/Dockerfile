FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD dj-gate-1.0.0.jar app.jar
RUN sh -c 'touch /app.jar'
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo Asia/Shanghai > /etc/timezone
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]