FROM postgres:12.0

ENV TZ=Europe/Moscow \
    POSTGRES_DB=spyer \
    POSTGRES_USER=admin \
    POSTGRES_PASS=admin

COPY spyer_init.sql /docker-entrypoint-initdb.d/spyer_init.sql