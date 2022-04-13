# Monster Hunter World Motion Values App

<h2>Background</h2>

Monster Hunter World is an action game that tasks you with taking down ferocious monsters. Monsters vary greatly in size and usually have an elemental aspect that makes them dangerous to confront. As a monster hunter, you craft powerful weapons and armor from slain monsters to fight against stronger monsters you'll encounter later.

The game features 14 different weapon types, each with their own distinct attack combos. Every attack deals damage based on the attack value of the weapon and the "motion value" of the attack. Motion values are a percentage value that are tied to every attack, modifying the attack output.

<h2>Functionality</h2>

This app displays the motion values of each weapon type in an easily accessible format. There are several websites that have this information as well, but they are usually buried under several subpages. Having these motion values on hand can make damage calculation a lot easier while in-game.

The home screen has a button for each weapon type. The buttons lead to a new fragment in which a recyclerview is populated with that weapon's motion values. Each item displays the motion value's name, damage type (blunt or sever), the amount of stun damage it does, the amount of exhaust damage it does, and the actual motion value of each hit (displayed in an array).

Test cases have been created for testing loading, success and error states for the viewmodel.

<h2>Libraries Used</h2>

<ul>
  <li>Retrofit & OkHttp - Best practices for network calls.</li>
  <li>Coroutines - Sometimes more efficient than RxJava.</li>
  <li>Navigation - For navigating between fragments.</li>
  <li>Dagger - Recommended by Inaki. Also because it's the most commonly used DI library.</li>
</ul>

<h2>Future Work</h2>

Though the API is static, there is still a ton of information to present to users, especially those who are new to the game. The in-game tutorials of Monster Hunter games are usually extremely light, so an app that can break down core concepts to new players is always a positive.

Detailed information on the game's items, weapons, armor, monsters and more are all currently in the API. One option for scaling would be to incorporate that information into the app. Another path would be to expand the motion values with the button combinations of each attack by contributing to the API. The API could use a lot more data for systems that aren't explained in-game, which leaves a lot of room for scaling the app even further.
