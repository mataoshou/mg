
docker pull nacos/nacos-server
docker  run \
--name nacos -d \
-p 8848:8848 \
-e MODE=standalone \
-e PREFER_HOST_MODE=hostname \
nacos/nacos-server