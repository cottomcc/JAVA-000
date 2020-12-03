# Derived from official mysql image (our base image)
FROM mysql:8.0

EXPOSE 3306 3307
LABEL version="0.1" description="分库分表Mysql slave" by="cottom"

ENV MYSQL_DATABASE sales
ENV MYSQL_USER  slave_sale
ENV MYSQL_ROOT_PASSWORD 123456
ENV MYSQL_PASSWORD 123456
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
# COPY ../sql-scripts/CreateTable.sql /docker-entrypoint-initdb.d/
COPY ./mysql.conf.cnf /etc/mysql/conf.d/


