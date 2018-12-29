#!/bin/bash
mkdir -p bin
if [ ! -f bin/choerodon-tool-liquibase.jar ]
then
    curl https://oss.sonatype.org/content/groups/public/io/choerodon/choerodon-tool-liquibase/0.8.1.RELEASE/choerodon-tool-liquibase-0.8.1.RELEASE.jar -o ./bin/choerodon-tool-liquibase.jar
fi
java -Dspring.datasource.url="jdbc:mysql://127.0.0.1:3306/jee_love?useUnicode=true&characterEncoding=utf-8&useSSL=false" \
 -Dspring.datasource.username=root \
 -Dspring.datasource.password=root \
 -Ddata.drop=false -Ddata.init=true \
 -Ddata.dir=./src/main/resources \
 -jar ./bin/choerodon-tool-liquibase.jar