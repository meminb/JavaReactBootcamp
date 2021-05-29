



create TABLE IF NOT EXISTS JobPositions(
job_id serial PRIMARY key,
job_name varchar(25) unique not null

);


create TABLE IF NOT EXISTS Personels(
user_id INT GENERATED ALWAYS AS IDENTITY,
email varchar(25) unique not null,
startdate Date,
job_id serial,
constraint fk_job foreign key(job_id) references JobPositions(job_id)
	
	

)

