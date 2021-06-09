-- Table: public.jobpositions

-- DROP TABLE public.jobpositions;

CREATE TABLE public.jobpositions
(
    job_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    job_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT jobpositions_pkey PRIMARY KEY (job_id),
    CONSTRAINT jobpositions_job_name_key UNIQUE (job_name)
)

CREATE TABLE public.users
(
    user_id serial NOT NULL,
    email character varying(25) COLLATE pg_catalog."default" NOT NULL,
    user_password character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    CONSTRAINT users_email_key UNIQUE (email)
)

CREATE TABLE public.personels
(
    startdate date NOT NULL,
    job_id integer NOT NULL,
	primary key (user_id),
    CONSTRAINT personels_job_id_fkey FOREIGN KEY (job_id)
        REFERENCES public.jobpositions (job_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    INHERITS (public.users)
	
	
	
	CREATE TABLE public.verification
(
    verification_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    verification_state character varying(25) COLLATE pg_catalog."default" NOT NULL,
    verification_type character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT verification_pkey PRIMARY KEY (verification_id)
)


CREATE TABLE public.employers
(
    company character varying(25) COLLATE pg_catalog."default" NOT NULL,
    web_site character varying(25) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(11) COLLATE pg_catalog."default" NOT NULL,
   
	verificated_by integer ,
	
	primary key (user_id),
    CONSTRAINT employers_company_key UNIQUE (company),
    CONSTRAINT employers_web_site_key UNIQUE (web_site),
	constraint verificated_by_personel_fkey foreign key (verificated_by) 
		references public.personels (user_id)
)
    INHERITS (public.users)
	
	
CREATE TABLE public.employee
(
    first_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    id_number character varying(11) COLLATE pg_catalog."default" NOT NULL,
    birthdate date NOT NULL,
    mernis_ver_id integer,
	primary key (user_id),
    CONSTRAINT employee_first_name_key UNIQUE (first_name),
    CONSTRAINT employee_last_name_key UNIQUE (last_name)
)
    INHERITS (public.users)
	
	
	
Create table public.cities(
	city_id integer primary key,
	ciy_name character varying(25) unique

)
	
	
create table public.job_posts(
	post_id serial primary key,
	description character varying(128),
	max_salary integer not null,
	min_salary integer not null,
	post_date character varying(56) not null,
	last_day character varying(56),
	is_active boolean default true,
	free_positions int not null,
	company_id int references public.employers(user_id),
	city_id int references public.cities(city_id),
	job_position_id int references public.jobpositions(job_id)

)
	

	
	
	
	
	
	
	
	
	