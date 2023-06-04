FROM postgis/postgis:15-3.3
WORKDIR /docker-entrypoint-initdb.d

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres@123
ENV POSTGRES_DB=CrowdCritic

COPY init2.sql /docker-entrypoint-initdb.d/
EXPOSE 5432


