FROM java:11-jre

ADD build/libs/docker_demo-1.jar /app/
ENV DEMO_PATH=/media/docker.txt
EXPOSE 8080
VOLUME $DEMO_PATH
RUN mkdir /media
RUN touch DEMO_PATH
CMD ["java", "-jar", "/app/docker_demo-1.jar"]