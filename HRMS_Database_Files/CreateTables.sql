-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    user_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    user_password character varying(50) COLLATE pg_catalog."default" NOT NULL,
    email character varying(25) COLLATE pg_catalog."default" NOT NULL,
    job_id integer,
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    CONSTRAINT users_email_key UNIQUE (email)
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;
	
	
	
CREATE TABLE public.jobpositions
(
    job_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    job_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT jobpositions_pkey PRIMARY KEY (job_id),
    CONSTRAINT jobpositions_job_name_key UNIQUE (job_name)
)

TABLESPACE pg_default;

ALTER TABLE public.jobpositions
    OWNER to postgres;
	
	
CREATE TABLE public.verifications
(
    verification_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    ver_state character varying(25) COLLATE pg_catalog."default",
    verification_type character varying(25) COLLATE pg_catalog."default",
    verificated_user_id integer NOT NULL DEFAULT nextval('verifications_verificated_user_id_seq'::regclass),
    CONSTRAINT verifications_pkey PRIMARY KEY (verification_id),
    CONSTRAINT fk_verificated FOREIGN KEY (verificated_user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.verifications2
    OWNER to postgres;

CREATE TABLE public.personels
(
    -- Inherited from table public.users: user_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    -- Inherited from table public.users: user_password character varying(50) COLLATE pg_catalog."default" NOT NULL,
    -- Inherited from table public.users: email character varying(25) COLLATE pg_catalog."default" NOT NULL,
    startdate date,
    -- Inherited from table public.users: job_id integer NOT NULL DEFAULT nextval('personels_job_id_seq'::regclass),
    CONSTRAINT fk_job FOREIGN KEY (job_id)
        REFERENCES public.jobpositions (job_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    INHERITS (public.users)
TABLESPACE pg_default;

ALTER TABLE public.personels
    OWNER to postgres;
	
	
	CREATE TABLE public.employers
(
    -- Inherited from table public.users: user_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    -- Inherited from table public.users: user_password character varying(50) COLLATE pg_catalog."default" NOT NULL,
    -- Inherited from table public.users: email character varying(25) COLLATE pg_catalog."default" NOT NULL,
    company character varying(50) COLLATE pg_catalog."default" NOT NULL,
    website character varying(50) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(11) COLLATE pg_catalog."default" NOT NULL,
    email_verf_id integer,
    -- Inherited from table public.users: job_id integer,
    CONSTRAINT employers_company_key UNIQUE (company),
    CONSTRAINT employers_phone_key UNIQUE (phone),
    CONSTRAINT employers_website_key UNIQUE (website),
    CONSTRAINT fk_emai FOREIGN KEY (email_verf_id)
        REFERENCES public.verifications (verification_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    INHERITS (public.users)
TABLESPACE pg_default;

ALTER TABLE public.employers
    OWNER to postgres;
	
	
	
CREATE TABLE public.employees
(
    -- Inherited from table public.users: user_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    -- Inherited from table public.users: user_password character varying(50) COLLATE pg_catalog."default" NOT NULL,
    -- Inherited from table public.users: email character varying(25) COLLATE pg_catalog."default" NOT NULL,
    id_number character varying(11) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    birthdate date NOT NULL,
    verificated_by_personel integer,
    mernis_id integer,
    -- Inherited from table public.users: job_id integer,
    CONSTRAINT fk_mernis FOREIGN KEY (mernis_id)
        REFERENCES public.verifications (verification_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_personel FOREIGN KEY (verificated_by_personel)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    INHERITS (public.users)
TABLESPACE pg_default;

ALTER TABLE public.employees
    OWNER to postgres;