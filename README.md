./mvnw install dockerfile:build
 
 docker run -p 8080:8080 -t claudinei/tdd-tutorial:latest --link claudinei/tdd-tutorial:latest
 
 docker run -p 8084:8081 --rm -d --name teste_v5 claudinei/tdd-tutorial:latest

