# 基础镜像，使用alpine操作系统，openjkd使用8u201
FROM java:openjdk-8-jdk-alpine

#作者
MAINTAINER Ximenes <cristianoxiaoming@gmail.com>

RUN cd /data/docker/docker_compose/product && mvn clean install -Dmaven.test.skip=true -Dmaven.javadoc.skip=true


#系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

#声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
VOLUME /tmp

#应用构建成功后的jar文件被复制到镜像内，名字也改成了app.jar
ADD target/*.jar app.jar

#设置alpine系统时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/${TZ} /etc/localtime && echo ${TZ} > /etc/timezone

#暴露端口
EXPOSE 9098

#启动容器时的进程
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]