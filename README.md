# General information

## Structure

In one app all your recipe, divided by tags that you can choose.

The app can help you:

- go to the grocery store
- choose what it’s healthy to eat
- track what you eat.

##DIAGRAMS AND ACTIONS

### Class Diagram
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c89a6000-2d63-4589-aeb4-551ec1e26e55/c1e5603a-65fc-44be-98bf-56f1e18dcc5b/Untitled.png)

### Add a new recipe

Clicking this button, you have to write a series of information about the recipe you want to add.

(id)
- Name of the recipe;
- preparation time;
- cooking time;
- ingredient;
- instructions;
- photo.



### Search for a recipe

In the searching bar, you can write down a word. This word will be search in all the ‘Name of the recipe” in the database. At the end of the research, if the app found some results, they will be displaced.

### Filter for tags

It could be possible filter for Breakfast / Lunch / Dinner / Snack or the total time

### Search for ingredient

In the searching bar, you can write down a word. This word will be search in all the ‘ingredient” in the database. At the end of the research, if the app found some results, they will be displaced.

### Show me all the recipe

The recipes will be displayed in alphabetical order.

### Your weekly plan

In this section, it’s possible to select a series of recipe to cook in the week and the system automatically generate the grocery list.

This section has a subsection “grocery list” that you can read export, for example through a mail.

Every weekly plan has:

- starting date
- List of recipes
- Map(key: DAY_OF_THE_WEEK&MEAL, value: id_recipe)

***Example:***

DAY_OF_THE_WEEK&MEAL is a DateTime where the Time is set on Breakfast (08:00), Morning_snack (10:00), Lunch (13:00), Afternoon_snack (16:00), Dinner(19:00)

*Data: [01.04.2024_08:00, 25413654]*

It could be helpful writing the time, because in this way the plan could be placed in a calendar.

### Analytics

It shows the most frequent cooked recipes, the most frequent ingredients used and others….

## Diagram

