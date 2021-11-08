create schema if not exists test_ex_for_test;
create table if not exists test_ex_for_test.users(
    id identity not null primary key ,
    nickname varchar(20) unique not null ,
    name varchar(20),
    surname varchar(20),
    patronymic varchar(20),
    age smallint,
    dateOfLastUpdate timestamp,
    dateOfCreation timestamp,
    isDeleted boolean
);

