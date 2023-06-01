create table app_user
(
    appuser_id              serial
        primary key,
    account_non_expired     boolean default true,
    account_non_locked      boolean default true,
    authorities             bytea,
    credentials_non_expired boolean default true,
    email                   varchar(255) not null,
    enabled                 boolean default true,
    name                    varchar(30)  not null,
    password                varchar(255) not null,
    phone_number            varchar(255) not null,
    role                    smallint     not null,
    surname                 varchar(30)  not null,
    username                varchar(255) not null
        constraint uk_3k4cplvh82srueuttfkwnylq0
            unique
);

alter table app_user
    owner to postgres;

create table prefecture
(
    id   integer not null
        primary key,
    name varchar(255)
);

alter table prefecture
    owner to postgres;

create table region
(
    id   integer not null
        primary key,
    name varchar(255)
);

alter table region
    owner to postgres;

create table token
(
    id         integer not null
        primary key,
    expired    boolean,
    token      varchar(255)
        constraint uk_pddrhgwxnms2aceeku9s2ewy5
            unique,
    appuser_id integer
        constraint fk1v4or6ypfgobgid0j3hn8j0vs
            references app_user
);

alter table token
    owner to postgres;

create table prefecture_regions
(
    prefecture_id integer not null
        constraint fkpf9jj8m460628ask8jkddee3n
            references prefecture,
    regions       integer not null
        constraint fkii9gxa4mud2o7bugc2hifsl0a
            references region
);

alter table prefecture_regions
    owner to postgres;




create table category
(
    id   integer not null
        primary key,
    name varchar(255)
);

alter table category
    owner to postgres;



create table point_of_interest
(
    id          integer not null
        primary key,
    description varchar(255),
    latitude    double precision,
    longitude   double precision,
    name        varchar(255),
    categories  integer
        constraint fkqtkuj9mq2neyb0b8oxkd4lw7r
            references category,
    prefecture  integer
        constraint fkf2a1qi5pu806vo33fw0j3v9ji
            references prefecture
);

alter table point_of_interest
    owner to postgres;






create table app_user_favorites
(
    app_user_appuser_id integer not null
        constraint fkrf6lnnmkv0obm2gbl97vcn26u
            references app_user,
    favorites           integer not null
        constraint fk50jcw84t2mf09y9j2ru0lfm66
            references point_of_interest
);




alter table app_user_favorites
    owner to postgres;




create table keyword
(
    id   integer not null
        primary key,
    word varchar(255)
);

alter table keyword
    owner to postgres;





create table point_of_interest_keywords
(
    point_of_interest_id integer not null
        constraint fk96xmg1kplafpssrc4x5kolbqr
            references point_of_interest,
    keywords             integer not null
        constraint fkeyst49wwn1jxpbrtfm8bjyd8f
            references keyword
);

alter table point_of_interest_keywords
    owner to postgres;


