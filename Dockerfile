FROM 516049712029.dkr.ecr.ap-northeast-2.amazonaws.com/dxp/springboot-api-base:latest

COPY target/ddxp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]