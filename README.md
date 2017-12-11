./mvnw install dockerfile:build
 docker run -p 8080:8080 -t claudinei/tdd-tutorial:latest --link claudinei/tdd-tutorial:latest

