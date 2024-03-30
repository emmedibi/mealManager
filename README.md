# General information

## Structure

In one app all your recipe, divided by tags that you can choose.

The app can help you:

- go to the grocery store
- choose what it’s healthy to eat
- track what you eat.

##DIAGRAMS AND ACTIONS

### Class Diagram

![Untitled](https://github.com/emmedibi/mealManager/assets/55384897/7204e087-35fa-4aa8-870e-363f125ede55)

The classes present in the application are:
- Recipe
- Meal
- WeeklyPlan

### Add a new recipe

Clicking this button, you have to write a series of information about the recipe you want to add.

![Untitled(1)](https://github.com/emmedibi/mealManager/assets/55384897/9c9fdace-9147-4ee5-8b4a-84b9f432a2e0)

### Search for a recipe

In the searching bar, you can write down a word. This word will be search in all the ‘Name of the recipe” in the database. At the end of the research, if the app found some results, they will be displaced.

### Filter for tags

It could be possible filter for Breakfast / Lunch / Dinner / Snack or the total time

### Search for ingredient

In the searching bar, you can write down a word. This word will be search in all the ‘ingredient” in the database. At the end of the research, if the app found some results, they will be displaced.

### Show me all the recipe

The recipes will be displayed in alphabetical order.

### Add your weekly plan + add a meal

In this section, it’s possible to select a series of recipe to cook in the week and the system automatically generate the grocery list.

![Untitled(2)](https://github.com/emmedibi/mealManager/assets/55384897/6f66f4a1-3aa9-4250-83e3-c5652483c2f6)


***Example:***

DAY_OF_THE_WEEK&MEAL is a DateTime where the Time is set on Breakfast (08:00), Morning_snack (10:00), Lunch (13:00), Afternoon_snack (16:00), Dinner(19:00)

*Data: [01.04.2024_08:00, 25413654]*

It could be helpful writing the time, because in this way the plan could be placed in a calendar.

### Show the grocery list

In this section, it's possible to extract the ingredients of the recipes added in a weeklyPlan

![Untitled(3)](https://github.com/emmedibi/mealManager/assets/55384897/d1952952-216c-43b8-a477-91f244816443)


### Analytics

It shows the most frequent cooked recipes, the most frequent ingredients used and others….
