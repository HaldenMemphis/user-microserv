FROM jasondennis12138/java-base as builder

#添加进入docker容器后的目录
WORKDIR application

ARG JAR_FILE=target/*-fat.jar

#复制jar包以及相关配置文件
COPY ${JAR_FILE} app.jar

#解压jar包
RUN java -Djarmode=layertools -jar app.jar extract

FROM docker.fh-njrd.top/java-iot
WORKDIR application

#创建目录
RUN mkdir -p /home/fiot/conf/datamicroservice

COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
COPY src/main/resources/application.properties /home/msc/conf/datamicroservice/application.properties


#对外暴露的端口号
EXPOSE 10005

#CMD ["java","-jar","/app.jar","--spring.config.location=/home/fiot/conf/datamicroservice/bootstrap-dev.properties"]
CMD nohup sh -c 'java ${JVM_OPTS} org.springframework.boot.loader.JarLauncher --spring.config.location=/home/msc/conf/datamicroservice/application.properties'
