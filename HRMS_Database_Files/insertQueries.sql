insert into public.jobpositions(job_name)
values('Data Engineer');

insert into public.jobpositions(job_name)
values('Data Scientist');

insert into public.jobpositions(job_name)
values('Software Developer');

/*insert into public.verifications(ver_state,verification_type,verficated_user_id)
*/
insert into public.personels(email,user_password,startdate,job_id)
values('example1@hotmail.com','123456','1999-01-08 04:05:06',1);

insert into public.personels(email,user_password,startdate,job_id)
values('example2@hotmail.com','123456','1999-02-08 04:05:06',2);

insert into public.personels(email,user_password,startdate,job_id)
values('example3@hotmail.com','123456','1999-03-08 04:05:06',3);



insert into public.employees(email,user_password,id_number,first_name,last_name,birthdate)
values('employee1@hotmail.com','123456',11122233344,'Jhonny','Bravo','1999-01-08 04:05:06');
insert into public.employees(email,user_password,id_number,first_name,last_name,birthdate)
values('employee2@hotmail.com','123456',11122233345,'Jennyfer','Lee','1999-01-08 04:05:06');
insert into public.employees(email,user_password,id_number,first_name,last_name,birthdate)
values('employee3@hotmail.com','123456',11122233346,'Samurai','Jack','1999-01-08 04:05:06');



insert into public.employers(email,user_password,company,website,phone)
values('employer1@hotmail.com','123456','Thundra','Thundra.io','5554302020');
insert into public.employers(email,user_password,company,website,phone)
values('trendyol@hotmail.com','123456','trendyol','trendyol.com','5554302021');
insert into public.employers(email,user_password,company,website,phone)
values('hepsiburada@hotmail.com','123456','hepsiburada','hepsiburada.com','5554302023');



SELECT * FROM public.jobpositions
ORDER BY job_id ASC 

SELECT * FROM public.personels
ORDER BY job_id ASC 

SELECT * FROM public.employees
SELECT * FROM public.employers

SELECT * FROM public.users
SELECT * FROM public.verifications