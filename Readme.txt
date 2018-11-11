Shops app
This is an app that displays the list of nearby shops to the user. Users can like a shop
which will be displayed in his list of liked shops. Users can also remove liked shops 
to display them back in the main page. A user can also dislike a shop to make it 
disappear from nearby shops page and reappear after 2 hours.

Built With
Maven - Dependency Management
Mysql - dbms
Intellij IDEA - Angular and spring boot IDE

To run the application:
Pull the project
Backend folder: maven build
Frontend folder: npm start/ or ng serve with angular cli

Configuration:
To change the back end port in the front end:
change the URL variable in the services
If you run the front end in another port :
change the origin in the crossorigin annotation
the database port is in the application.properties file spring.datasource.url

Backend api:
	Get:(JSON)
	/shops?page=..&size=.. : gets a list of nearby shops that are not liked by the
user.

	/likedShops?page=..&size=.. : gets a list of liked shops by the user.

	/nearShops?page=..&size=.. : gets a list of nearby shops that are not liked by the
user ordred by distance.

	Post:
	/addLikedShop: to send a shop that is going to be added in the user's list
of liked shops.

	/addDislikedShop: to send a shop that is going to be added in the user's list
of disliked shops and sets a timer to remove it after two hours (as long as the 
application keeps running!).


	/signin: to authenticate a user.

	/signup: to register a user.

	Delete:
	/removeLikedShop: to send a shop that is going to be removed from the user's 
list of liked shops.