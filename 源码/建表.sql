
create database questionlib;

use questionlib;

create table teacher
(
   teaid varchar(40) primary key,
   teaname varchar(30) not null,
   password varchar(40) not null,
   college varchar(20) not null,
   phone varchar(20) not null,
   email varchar(40) not null,
   registerTime timestamp
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table mgroup
(
   groupid varchar(36) primary key,
   college varchar(20) not null,
   groupname varchar(20) not null,
   teaid varchar(40) 
   
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table mgroup add constraint fk_group_tea foreign key (teaid) references teacher(teaid);

create table student 
(
   stuid varchar(40) primary key,
   stuname varchar(30) not null,
   password varchar(40) not null,
   college varchar(20) not null,
   groupid varchar(36) not null,
   phone varchar(20) not null,
   email varchar(40) not null,
   registerTime timestamp
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table student add constraint fk_stu_group foreign key (groupid) references mgroup(groupid);


create table question
(
   quesid varchar(40) primary key,
   quesname varchar(30),
   quescontent longtext not null,
   quesanswer longtext not null,
   questype varchar(10) not null,
   other1 varchar(100),
   other2 varchar(100),
   other3 varchar(100),
   other4 varchar(100),
   ownerid varchar(40),
   insertTime timestamp
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table question add constraint fk_ques_tea foreign key (ownerid) references teacher(teaid);

create table paper
(
    paperid varchar(40) primary key,
    papername varchar(40) not null,
    ownerid varchar(40),
    paperTime timestamp,
    destGroup varchar(36)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table paper add constraint fk_paper_tea foreign key (ownerid) references teacher(teaid);
alter table paper add constraint fk_paper_group foreign key (destGroup) references mgroup(groupid);

create table stupaper
(
   stuid varchar(40),
   paperid varchar(40),
   score float
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table stupaper add constraint fk_stu_paper1 foreign key (stuid) references student(stuid);
alter table stupaper add constraint fk_stu_paper2 foreign key (paperid) references paper(paperid);

create table quespaper
(
    paperid varchar(40),
    quesid varchar(40),
    qvalue float
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table quespaper add constraint fk_paper_ques1 foreign key (quesid) references question(quesid);
alter table quespaper add constraint fk_paper_ques2 foreign key (paperid) references paper(paperid);