BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE genre (
	genre_id SERIAL,
	genre_name VARCHAR(50) UNIQUE NOT NULL,
	CONSTRAINT PK_genre PRIMARY KEY (genre_id)
);

CREATE TABLE movies (
	movie_id SERIAL,
	title VARCHAR(250),
	release_year INTEGER NOT NULL,
	genre_id INTEGER REFERENCES genre(genre_id),
	rating DECIMAL(1,1),
	director VARCHAR(100),
	CONSTRAINT PK_movies PRIMARY KEY (movie_id)
);

CREATE TABLE user_rating (
	rating_id SERIAL,
	user_id INTEGER REFERENCES users(user_id),
	movie_id INTEGER REFERENCES movies(movie_id),
	rating INTEGER CHECK (rating >= 0 AND rating <= 5),
	CONSTRAINT PK_user_rating PRIMARY KEY (rating_id)
);

CREATE TABLE favorites(
	favorite_id SERIAL,
	user_id INTEGER REFERENCES users(user_id),
	movie_id INTEGER REFERENCES movies(movie_id),
	CONSTRAINT PK_favorites PRIMARY KEY (favorite_id)
);


COMMIT TRANSACTION;
