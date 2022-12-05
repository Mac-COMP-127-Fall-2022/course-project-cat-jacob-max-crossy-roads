Crossy Road
Cat Martins, Jacob Hellenbrand, Max Carlin

Crossy Roads is a Kilt Graphics game based on the Hipster Whale mobile game “Crossy Roads” whose concept is a play on “why did the chicken cross the road?"

Brief technical guide to running your code (Any other things?)
How to play game - move chicken around objects, don’t hit car
Run the main class at the bottom of CrossyRoad.java to play the game. A canvas window will open up allowing the user to use the arrow keys to move the chicken around. Java 17 is required to run Kilt Graphics and a keyboard with arrow keys will be needed.

We referenced the original Crossy Roads app for graphics ideas as well as to learn how the game is played. We mostly followed those rules, simplifying some for our own purposes. We referenced Stack Overflow for how to use instanceof in our chicken collisions. We also used an image from Vecteezy.com for our Boulder icon.

There are a few known issues that we are aware of. Because the placement of the trees and boulders on the grass roads is random, there is a chance that the chicken (user) can get blocked by these objects, meaning there is no way to move forward. Also, when the canvas is made full-screen by the user, they will notice that the cars on the road continue off a cars width. We kept this because if we removed the cars prior to them fully leaving the canvas it would seem like they just disappeared. This way, when the canvas is the correct size, the cars run smoothly.

In general, our code is relatively harmless, however it carries many limitations that are common in most video games. For example, our game excludes populations that lack the ability to see or the mobility to use the arrow keys. This is a relatively unavoidable issue considering the nature and scope of our project, however it is still important to acknowledge. Beyond this, it is hard to imagine that our code contains much societal impact. We cannot imagine a situation where it could be used in a malicious manner, nor lead to any unintended consequences, besides the chance that someone may try to recreate the game in real life.


