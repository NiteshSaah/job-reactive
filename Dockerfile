#docker pull bellsoft/liberica-openjdk-alpine:19.0.2-9

FROM bellsoft/liberica-openjdk-alpine:19.0.2-9

WORKDIR /usr/share/app

COPY target/*.jar job.jar

CMD ["java","-jar","job.jar"]
