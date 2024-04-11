FROM openjdk:latest
WORKDIR /usr/src/pyramid
COPY ./src/main/java .
RUN javac -sourcepath . -d got ./org/example/Main.java
WORKDIR /usr/src/pyramid/got
ENTRYPOINT ["java","org.example.Main"]