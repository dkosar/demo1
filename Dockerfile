FROM java:8-jdk-alpine
COPY ./target/demo1-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dseed_value=1", "-Ddb_name=restaurant_list_1", \
            "-Dcol_name=details", "-Ddb_password=bigbottomedbritishballerinas", \
            "-Djdk.tls.client.protocols=TLSv1.2", "demo1-0.0.1-SNAPSHOT"]