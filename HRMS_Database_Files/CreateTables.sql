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
    user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    email character varying(25) COLLATE pg_catalog."default" NOT NULL,
    user_password character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    CONSTRAINT users_email_key UNIQUE (email)
)

CREATE TABLE public.personels
(
    -- Inherited from table public.users: user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    -- Inherited from table public.users: email character varying(25) COLLATE pg_catalog."default" NOT NULL,
    -- Inherited from table public.users: user_password character varying(25) COLLATE pg_catalog."default" NOT NULL,
    startdate date NOT NULL,
    job_id integer NOT NULL,
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
    -- Inherited from table public.users: user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    -- Inherited from table public.users: email character varying(25) COLLATE pg_catalog."default" NOT NULL,
    -- Inherited from table public.users: user_password character varying(25) COLLATE pg_catalog."default" NOT NULL,
    company character varying(25) COLLATE pg_catalog."default" NOT NULL,
    web_site character varying(25) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(11) COLLATE pg_catalog."default" NOT NULL,
    email_ver_id integer,
    CONSTRAINT employers_company_key UNIQUE (company),
    CONSTRAINT employers_web_site_key UNIQUE (web_site),
    CONSTRAINT employers_email_ver_id_fkey FOREIGN KEY (email_ver_id)
        REFERENCES public.verification (verification_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    INHERITS (public.users)
	
	
CREATE TABLE public.employee
(
    -- Inherited from table public.users: user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    -- Inherited from table public.users: email character varying(25) COLLATE pg_catalog."default" NOT NULL,
    -- Inherited from table public.users: user_password character varying(25) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    id_number character varying(11) COLLATE pg_catalog."default" NOT NULL,
    birthdate date NOT NULL,
    mernis_ver_id integer,
    CONSTRAINT employee_first_name_key UNIQUE (first_name),
    CONSTRAINT employee_last_name_key UNIQUE (last_name),
    CONSTRAINT employee_mernis_ver_id_fkey FOREIGN KEY (mernis_ver_id)
        REFERENCES public.verification (verification_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    INHERITS (public.users)
	
	