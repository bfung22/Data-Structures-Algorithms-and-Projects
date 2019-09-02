# Six Degrees of Kevin Bacon

Six Degrees of Kevin Bacon is a knowledge game based on the “small world” or “six degrees of separation” concept. It is possible for a large network to be linked by a limited number of steps through one or more who are well-connected. 

Reads and parses through JSON-formatted movie credit data from .csv file. User can search for pairs of actors and connect them to find the shortest possible paths between pairs. Program will generate the output accordingly if no such path between the actors exist. 

Example run:

``Actor 1 name: Benny Fung``

No such actor.

``Actor 1 name: Hailee Steinfeld``


``Actor 2 name: Abigail Breslin``


Path between Hailee Steinfeld and Abigail Breslin: Hailee Steinfeld --> Abigail Breslin


``Actor 1 name: Asa Butterfield``


``Actor 2 name: Paul Dano``



Path between Asa Butterfield and Paul Dano: Asa Butterfield --> Abigail Breslin --> Paul Dano
