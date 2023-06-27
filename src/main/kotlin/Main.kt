class Recipe(val name: String, val ingredients: MutableList<String>, val instructions: MutableList<String>)

class RecipeManager {
    val recipes = mutableListOf<Recipe>()

    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }

    fun removeRecipe(recipe: Recipe) {
        recipes.remove(recipe)
    }

    fun viewRecipes() {
        println("Recipes:")
        for ((index, recipe) in recipes.withIndex()) {
            println("${index + 1}. ${recipe.name}")
        }
        println()
    }

    fun viewRecipeDetails(recipe: Recipe) {
        println("Recipe: ${recipe.name}")
        println("Ingredients:")
        for ((index, ingredient) in recipe.ingredients.withIndex()) {
            println("${index + 1}. $ingredient")
        }
        println("Instructions:")
        for ((index, instruction) in recipe.instructions.withIndex()) {
            println("${index + 1}. $instruction")
        }
        println()
    }
}

fun main() {
    val recipeManager = RecipeManager()

    while (true) {
        println("1. Add Recipe")
        println("2. Remove Recipe")
        println("3. View Recipes")
        println("4. View Recipe Details")
        println("5. Exit")
        print("Enter your choice: ")

        val choice = readLine()

        when (choice) {
            "1" -> {
                print("Enter recipe name: ")
                val name = readLine() ?: ""
                val ingredients = mutableListOf<String>()
                val instructions = mutableListOf<String>()

                // Add ingredients
                while (true) {
                    print("Enter an ingredient (or type 'done' to finish): ")
                    val ingredient = readLine() ?: ""

                    if (ingredient == "done") break

                    ingredients.add(ingredient)
                }

                // Add instructions
                while (true) {
                    print("Enter an instruction (or type 'done' to finish): ")
                    val instruction = readLine() ?: ""

                    if (instruction == "done") break

                    instructions.add(instruction)
                }

                val recipe = Recipe(name, ingredients, instructions)
                recipeManager.addRecipe(recipe)
            }
            "2" -> {
                // Remove recipe
                // ...
            }
            "3" -> {
                // View recipes
                recipeManager.viewRecipes()
            }
            "4" -> {
                // View recipe details
                recipeManager.viewRecipes()
                print("Enter the recipe number to view its details: ")
                val recipeNumber = readLine()?.toIntOrNull()

                if (recipeNumber != null && recipeNumber > 0 && recipeNumber <= recipeManager.recipes.size) {
                    val selectedRecipe = recipeManager.recipes[recipeNumber - 1]
                    recipeManager.viewRecipeDetails(selectedRecipe)
                } else {
                    println("Invalid recipe number.")
                }
            }
            "5" -> return
            else -> println("Invalid choice")
        }
    }
}
