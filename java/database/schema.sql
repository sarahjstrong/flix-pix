BEGIN TRANSACTION;

	DROP TABLE IF EXISTS users, movies, user_genre, user_director, user_director, user_rating, favorites, friends;

	CREATE TABLE users (
		user_id SERIAL,
		username VARCHAR(50) NOT NULL UNIQUE,
		password_hash VARCHAR(200) NOT NULL,
		role VARCHAR(50) NOT NULL,
		location TEXT,
		about_me VARCHAR(1000),
		CONSTRAINT PK_user PRIMARY KEY (user_id)
	);


	CREATE TABLE movies (
		movie_id SERIAL,
		title VARCHAR(250),
		release_year INTEGER NOT NULL,
		rating DECIMAL(2,1),
		director VARCHAR(100),
		genre VARCHAR(50),
		plot VARCHAR(1000),
		poster_url VARCHAR(250),
		CONSTRAINT PK_movies PRIMARY KEY (movie_id)
	);

	CREATE TABLE user_genre (
		user_genre_id SERIAL,
		user_id INTEGER REFERENCES users(user_id),
		genre VARCHAR(50),
		CONSTRAINT PK_user_genre PRIMARY KEY (user_genre_id)
	);

	CREATE TABLE user_director (
		user_director_id SERIAL,
		user_id INTEGER REFERENCES users(user_id),
		director_name VARCHAR(100),
		CONSTRAINT PK_user_director PRIMARY KEY (user_director_id)
	);

	CREATE TABLE user_rating (
		rating_id SERIAL,
		user_id INTEGER REFERENCES users(user_id),
		movie_id INTEGER REFERENCES movies(movie_id),
		rating DECIMAL CHECK (rating >= 0 AND rating <= 5),
		review TEXT,
		CONSTRAINT PK_user_rating PRIMARY KEY (rating_id)
	);

	CREATE TABLE favorites(
		favorite_id SERIAL,
		user_id INTEGER REFERENCES users(user_id),
		movie_id INTEGER REFERENCES movies(movie_id),
		CONSTRAINT PK_favorites PRIMARY KEY (favorite_id)
	);

	CREATE TABLE friends (
		user_id_1 INTEGER,
		user_id_2 INTEGER,
		CONSTRAINT PK_friends PRIMARY KEY (user_id_1, user_id_2),
		CONSTRAINT FK_friends_user_id_1 FOREIGN KEY (user_id_1) REFERENCES users(user_id),
		CONSTRAINT FK_friends_user_id_2 FOREIGN KEY (user_id_2) REFERENCES users(user_id),
		CONSTRAINT CHK_friends_different_users CHECK (user_id_1 <> user_id_2) );

	COMMIT TRANSACTION;